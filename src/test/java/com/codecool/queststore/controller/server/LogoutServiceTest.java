package com.codecool.queststore.controller.server;

import com.codecool.queststore.controller.server.service.LogoutService;
import com.codecool.queststore.model.server.session.Session;
import com.codecool.queststore.model.server.session.SessionPool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpCookie;


public class LogoutServiceTest {

    @Test
    void checksIfsessionExistswhenLogout() {
        Session session = SessionPool.getNewSession(12);
        HttpCookie cookie = session.getCookie();
        LogoutService logoutService = new LogoutService(cookie);
        Assertions.assertFalse(SessionPool.sessions.contains(session));

    }
}
