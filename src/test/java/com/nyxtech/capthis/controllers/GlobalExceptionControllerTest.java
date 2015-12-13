package com.nyxtech.capthis.controllers;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class GlobalExceptionControllerTest {

    @Test
    public void shouldReturnRootExceptionMessage() throws Exception {
        GlobalExceptionController controller = new GlobalExceptionController();
        RuntimeException rootException = new RuntimeException("Expected Root Exception");
        RuntimeException childException = new RuntimeException("Expected Child Exception", rootException);
        CapThisApiError response = controller.handleException(childException);
        assertThat(response.getMessage(), is("Expected Root Exception"));
    }

}
