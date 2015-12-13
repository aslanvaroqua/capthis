package com.nyxtech.capthis.repository;

import com.nyxtech.capthis.entity.Caption;
import com.github.fakemongo.Fongo;
import com.mongodb.Mongo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@IntegrationTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CaptionRepositoryTest.class)
@EnableAutoConfiguration
public class CaptionRepositoryTest {
    public static final String PIC_ID = "9874789049";
    public static final String TEXT = "Look at this hipster";
    public static final String USER_ID = "39839839439";

    @Autowired
    private CaptionRepository captionRepository;

    @Test
    public void shouldSaveCaption() {
        Caption caption = new Caption();
        Caption saved = captionRepository.save(caption);
        caption.setPicId(PIC_ID);
        caption.setText(TEXT);
        caption.setUserId(USER_ID);
        assertThat(saved.getId(), is(notNullValue()));
        assertThat(saved.getUserId(), is(USER_ID));
        assertThat(saved.getPicId(), is(PIC_ID));
        assertThat(saved.getText(), is(TEXT));
        assertThat(saved.getUpVotes(), is(0));
        assertThat(saved.getDownVotes(), is(0));
    }

    @Bean
    public Mongo mongo() {
        return new Fongo("test-mongo").getMongo();
    }
}
