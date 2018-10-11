package com.codecool.queststore.controller.server.httphandler;

import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;

class AbstractHttphandlerTest {

    @Test
    void checkIfParseFormDataHandlesEmptyLoginData() throws IOException {
        ProfileHandler profileHandler = new ProfileHandler();
        InputStream stream = new ByteArrayInputStream("login=".getBytes(StandardCharsets.UTF_8));
        HttpExchange spy = Mockito.spy(HttpExchange.class);
        Mockito.doReturn(stream).when(spy).getRequestBody();

        Map<String,String> formData = profileHandler.parseFormData(spy);

        Assertions.assertEquals("puci", formData.get("login"));
    }
}
