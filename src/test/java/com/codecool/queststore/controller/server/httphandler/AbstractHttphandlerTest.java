package com.codecool.queststore.controller.server.httphandler;

import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AbstractHttphandlerTest {

    @Test
    void checkIfParseFormDataHandlesEmptyLoginData() throws IOException {
        ProfileHandler profileHandler = new ProfileHandler();
        InputStream stream = new ByteArrayInputStream("login=".getBytes(StandardCharsets.UTF_8));
        try {
            HttpExchange spy = Mockito.spy(HttpExchange.class);
            Mockito.doReturn(stream).when(spy).getRequestBody();
            profileHandler.parseFormData(spy);
        }
        catch (NullPointerException ex) {
            fail("Expected no exception, but got: " + ex.getMessage());
        }
    }
}

