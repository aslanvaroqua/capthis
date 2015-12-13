package com.nyxtech.capthis.controllers;

import com.nyxtech.capthis.converters.CaptionRequestToCaption;
import com.nyxtech.capthis.entity.*;
import com.nyxtech.capthis.models.CaptionRequest;
import com.nyxtech.capthis.repository.CaptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@EnableAutoConfiguration
@ContextConfiguration(classes = {CaptionControllerTestIt.class})
public class CaptionControllerTestIt extends AbstractControllerTest {

    public static final String FAKE_ID = "fake-id";
    public static final String FAKE_TEXT = "fake-text";
    public static final String FAKE_USER_ID = "fake-user-id";
    public static final String FAKE_PIC_ID = "fake-pic-id";
    public static final String JSON_ID_LIST_PATH_ITEM_1 = "$[0].id";
    public static final String JSON_ID_LIST_PATH_ITEM_2 = "$[1].id";

    private static final String CREATE_CAPTION_ENDPOINT = "http://localhost:8080/api/v1/captions";
    private static final String GET_CAPTIONS_FOR_PIC = "http://localhost:8080/api/v1/captions/";
    public static final String JSON_ID_PATH = "$.id";
    public static final String JSON_TEXT = "$.text";
    public static final String JSON_USER_ID = "$.userId";
    public static final String JSON_PIC_ID_ = "$.picId";
    public static final String JSON_ERROR_PATH = "$.error";
    public static final String JSON_MESSAGE_PATH = "$.message";


    @Inject
    private CaptionController captionController;

    @Inject
    private CaptionRepository captionRepository;

    private ArgumentCaptor<Caption> captionArgumentCaptor = ArgumentCaptor.forClass(Caption.class);


    @Override
    public void setUpTest(MockMvc mockMvc) {
        reset(captionRepository);
        this.mockMvc = mockMvc;
    }


    @Test
    public void shouldCallRepositorySaveWhenCreateCaption() throws Exception {
        CaptionRequest captionRequest = new CaptionRequest();
        captionRequest.setPicId(FAKE_PIC_ID);
        captionRequest.setUserId(FAKE_USER_ID);
        captionRequest.setText(FAKE_TEXT);

        Caption caption = new Caption();

        caption.setPicId(FAKE_PIC_ID);
        caption.setText(FAKE_TEXT);
        caption.setUserId(FAKE_USER_ID);

        ReflectionTestUtils.setField(caption, "id", FAKE_ID);

        when(captionRepository.save(captionArgumentCaptor.capture())).thenReturn(caption);

        String captionJson = objectMapper.writeValueAsString(captionRequest);

        this.mockMvc.perform(post(CREATE_CAPTION_ENDPOINT).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(captionJson))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath(JSON_ID_PATH).value(FAKE_ID))
                .andExpect(jsonPath(JSON_TEXT).value(FAKE_TEXT))
                .andExpect(jsonPath(JSON_PIC_ID_).value(FAKE_PIC_ID))
                .andExpect(jsonPath(JSON_USER_ID).value(FAKE_USER_ID));

        // Asserting converter functionality and repository calls
        verify(captionRepository).save(captionArgumentCaptor.getValue());
        Caption value = captionArgumentCaptor.getValue();
        assertThat(value, is(notNullValue()));
        assertThat(value.getPicId(), is(FAKE_PIC_ID));
        assertThat(value.getText(), is(FAKE_TEXT));
        assertThat(value.getUserId(),is(FAKE_USER_ID));
        assertThat(value.getDownVotes(),is(0));
        assertThat(value.getUpVotes(), is(0));
    }

  @Test
    public void shouldCallRepositorySaveWhenUpdateCaption() throws Exception {

    }

    @Test
    public void shouldFindCaptionsByPicId() throws Exception {
        Caption firstCaption = new Caption();
        firstCaption.setUserId(FAKE_USER_ID);
        firstCaption.setPicId(FAKE_PIC_ID);
        firstCaption.setText(FAKE_TEXT);
        Caption secondCaption = new Caption();
        secondCaption.setUserId(FAKE_USER_ID);
        secondCaption.setPicId(FAKE_PIC_ID);
        secondCaption.setText(FAKE_TEXT);
        ReflectionTestUtils.setField(firstCaption, "id", FAKE_ID + "-1");
        ReflectionTestUtils.setField(secondCaption, "id", FAKE_ID + "-2");

        List<Caption> captionList = new ArrayList<Caption>();

        captionList.add(firstCaption);
        captionList.add(secondCaption);

        when(captionRepository.findByPicId(FAKE_PIC_ID)).thenReturn(captionList);

        this.mockMvc.perform(get(GET_CAPTIONS_FOR_PIC + FAKE_PIC_ID).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath(JSON_ID_LIST_PATH_ITEM_1).value(FAKE_ID + "-1"))
                .andExpect(jsonPath(JSON_ID_LIST_PATH_ITEM_2).value(FAKE_ID + "-2"));

        verify(captionRepository).findAll();
    }


    @Test
    public void shouldThrownExceptionWhenEmptyText() throws Exception {
        CaptionRequest captionRequest = new CaptionRequest();

        Caption firstCaption = new Caption();
        firstCaption.setUserId(FAKE_USER_ID);
        firstCaption.setPicId(FAKE_PIC_ID);

        this.mockMvc.perform(post(CREATE_CAPTION_ENDPOINT).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(captionRequest)))
                .andDo(print())
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath(JSON_ERROR_PATH).value(true))
                .andExpect(jsonPath(JSON_MESSAGE_PATH)
                        .value(containsString("Field error in object 'captionRequest' on field 'text'")));

        verify(captionRepository, never()).save(any(Caption.class));
    }


    @Test
    public void shouldReturn404ForNotFoundCaption() throws Exception {


    }

    @Test
    public void shouldDeleteCaptionById() throws Exception {
    }


    @Bean
    public CaptionRepository captionRepository() {
        return mock(CaptionRepository.class);
    }

    @Bean
    public CaptionController captionController() {
        return new CaptionController();
    }

    @Bean
    public CaptionRequestToCaption captionRequestToCaption() {
        return new CaptionRequestToCaption();
    }

    @Bean
    public GlobalExceptionController globalExceptionController() {
        return new GlobalExceptionController();
    }


}

