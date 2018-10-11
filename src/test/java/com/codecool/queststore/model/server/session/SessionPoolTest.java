package com.codecool.queststore.model.server.session;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.HttpCookie;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/*This test covers following methods of SessionPool class:
* - getNewSession
* - isSessionByCookie */

class SessionPoolTest {

    /* Check if creating new session with getNewSession method is properly
     added to sessions field in SessionPool Class
     */
    @Test
    void TestIfSessionRegisterToSessionPool() {
        Session session = SessionPool.getNewSession(1);
        Assertions.assertTrue(SessionPool.sessions.contains(session));
    }

    /* Check if two sessions created with method getNewSession and same userId
    argument have different uuid field number which makes them different sessions
    */
    @Test
    void TestIfSessionsForSameIdDifferent() {
        Session session1 = SessionPool.getNewSession(1);
        Session session2 = SessionPool.getNewSession(1);
        Assertions.assertFalse(session1.equals(session2));
    }

    /* Check if isSessionByCookie method finds existing session in sessions field
    of SessionPool class by its cookie
     */
    @Test
    void TestIsSessionByCookie(){
        Session session = SessionPool.getNewSession(1);
        HttpCookie cookie = new HttpCookie("ID-Session", session.getUuid().toString());
        Assertions.assertTrue(SessionPool.isSessionByCookie(cookie));
    }

    /* Check if isSessionByCookie method finds session not included in sessions field
    of SessionPool class by its cookie
     */
    @Test
    void TestIsNonExistingSessionByCookie(){
        Session session = new Session(1);
        HttpCookie cookie = new HttpCookie("ID-Session", session.getUuid().toString());
        Assertions.assertFalse(SessionPool.isSessionByCookie(cookie));
    }
}