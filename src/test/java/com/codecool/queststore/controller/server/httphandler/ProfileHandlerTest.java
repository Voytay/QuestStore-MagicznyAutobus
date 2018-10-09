package com.codecool.queststore.controller.server.httphandler;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ProfileHandlerTest {

    @Test
    void testIfCreatesNewCookieIfWrong() throws IOException {
        ProfileHandler profileHandler = new ProfileHandler();
        Headers spyMap = new Headers();
        List<String> list = new ArrayList<>();
        list.add("random cookie");
        spyMap.put("Cookie", list);
        HttpExchange spy = Mockito.spy(HttpExchange.class);
        Mockito.doReturn(spyMap).when(spy).getRequestHeaders();
        Mockito.doReturn(spyMap).when(spy).getResponseHeaders();
        Mockito.doReturn("GET").when(spy).getRequestMethod();
        profileHandler.handle(spy);
    }

}