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
        SessionPool sessionPool = new SessionPool();
        Session session = sessionPool.getNewSession(12);
        HttpCookie cookie = new HttpCookie("ID-Session", session.getUuid().toString());

        LogoutService logoutService = new LogoutService(cookie);

        Assertions.assertFalse(sessionPool.sessions.contains(session));
    }
}
