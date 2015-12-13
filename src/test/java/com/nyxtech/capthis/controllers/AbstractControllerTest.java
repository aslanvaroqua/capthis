package com.nyxtech.capthis.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@EnableAutoConfiguration
@WebAppConfiguration
public abstract class AbstractControllerTest {

    public MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    public ObjectMapper objectMapper;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();

        objectMapper = new ObjectMapper();

        setUpTest(mockMvc);
    }

    protected abstract void setUpTest(MockMvc mockMvc);
}