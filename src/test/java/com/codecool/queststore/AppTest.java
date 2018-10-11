package com.codecool.queststore;

import com.codecool.queststore.model.server.Server;
import com.codecool.queststore.model.server.session.Session;
import com.codecool.queststore.model.server.session.SessionPool;
import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.net.SocketException;

import static junit.framework.TestCase.*;


public class AppTest {

    @Test
    public void ifUserHasWalletTRUE() {
        User userTest = new User("janek", "wiśniewski", "@.pl", "asd", 1, Role.MENTOR);
        assertNull(userTest.getWallet());
    }

    @Rule
    public ExpectedException exc = ExpectedException.none();

    @Test
    public void canRunServerOnPort80FALSE() throws IOException {
        exc.expect(SocketException.class);
        exc.expectMessage("Permission denied");
        System.out.println("Cannot run on port 80!");
        Server srv = new Server();

        srv.run(80);

    }

    @Test
    public void ifSessionRemovedTRUE() {
        Session s = SessionPool.getNewSession(1);
        SessionPool.terminate(s);
        assertFalse(SessionPool.sessions.contains(s));

    }
}
