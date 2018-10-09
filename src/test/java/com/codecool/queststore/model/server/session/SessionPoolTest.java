package com.codecool.queststore.model.server.session;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpCookie;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SessionPoolTest {

    @Test
    void TestIfSessionRegisterToSessionPool() {
        SessionPool sp = new SessionPool();
        Session session = sp.getNewSession(1);
        Assertions.assertEquals(true,sp.sessions.contains(session));
    }

    @Test
    void TestIfSessionsForSameIdDifferent() {
        SessionPool sp = new SessionPool();
        Session session1 = sp.getNewSession(1);
        Session session2 = sp.getNewSession(1);
        Assertions.assertEquals(false, session1.equals(session2));
    }

    @Test
    void TestGettingSessionByCookie(){
        SessionPool sp = new SessionPool();
        Session session = sp.getNewSession(1);
        HttpCookie cookie = new HttpCookie("ID-Session", session.getUuid().toString());
        Assertions.assertEquals(true, sp.isSessionByCookie(cookie));
    }

    @Test
    void TestGettingNonExistingSessionByCookie(){
        SessionPool sp = new SessionPool();
        Session session = new Session(1);
        HttpCookie cookie = new HttpCookie("ID-Session", session.getUuid().toString());
        Assertions.assertEquals(false, sp.isSessionByCookie(cookie));
    }
}