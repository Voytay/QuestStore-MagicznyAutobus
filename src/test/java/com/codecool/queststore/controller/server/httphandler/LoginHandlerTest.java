package com.codecool.queststore.controller.server.httphandler;

import com.codecool.queststore.controller.server.httphandler.LoginHandler;
import com.codecool.queststore.model.server.session.Session;
import com.codecool.queststore.model.server.session.SessionPool;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LoginHandlerTest {

    static LoginHandler loginHandler;

    @BeforeAll
    static void setUp() {
        loginHandler = spy(new LoginHandler());
    }


    @Test
    void testIfHandlePostMethodGetsCalled() throws Exception {
        HttpExchange mockHttpExchange = mock(HttpExchange.class);
        doReturn("POST").when(mockHttpExchange).getRequestMethod();
        doNothing().when(loginHandler).handlePost(mockHttpExchange);
        loginHandler.handle(mockHttpExchange);
        verify(loginHandler).handlePost(mockHttpExchange);
    }

    @Test
    void testIfRedirectMethodGetsBalld() throws Exception {
        Headers headers = new Headers();
        Session session = SessionPool.getNewSession(12);
        headers.add("Cookie", session.getUuid().toString());
        HttpExchange mockHttpExchange = mock(HttpExchange.class);
        doReturn(headers).when(mockHttpExchange).getRequestHeaders();
        doNothing().when(loginHandler).redirect(mockHttpExchange, "/profile/");
        loginHandler.handleSession(mockHttpExchange);
        verify(loginHandler).redirect(mockHttpExchange,"/profile/");
        SessionPool.terminate(session);
    }


}