package com.codecool.queststore.controller.server.httphandler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ProfileHandlerTest {

    @Test
    void testIfHandlesInvalidCookie() throws IOException {
        ProfileHandler profileHandler = new ProfileHandler();
        Headers spyMap = new Headers();
        List<String> list = new ArrayList<>();
        list.add("wrong cookie");
        spyMap.put("Cookie", list);

        HttpExchange spy = Mockito.spy(HttpExchange.class);
        Mockito.doReturn(spyMap).when(spy).getRequestHeaders();
        Mockito.doReturn(spyMap).when(spy).getResponseHeaders();
        Mockito.doReturn("GET").when(spy).getRequestMethod();

        profileHandler.handle(spy);
        Assertions.assertEquals("/", spy.getResponseHeaders().getFirst("Location"));

    }

    @Test
    void testIfHandlesNullCookie() throws IOException {
        ProfileHandler profileHandler = new ProfileHandler();
        Headers spyMap = new Headers();
        spyMap.put("Cookie", null);

        HttpExchange spy = Mockito.spy(HttpExchange.class);
        Mockito.doReturn(spyMap).when(spy).getRequestHeaders();
        Mockito.doReturn(spyMap).when(spy).getResponseHeaders();
        Mockito.doReturn("GET").when(spy).getRequestMethod();

        profileHandler.handle(spy);
        Assertions.assertEquals("/", spy.getResponseHeaders().getFirst("Location"));
    }

}