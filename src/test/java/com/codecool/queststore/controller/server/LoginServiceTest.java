package com.codecool.queststore.controller.server;

import com.codecool.queststore.controller.server.service.LoginService;
import com.codecool.queststore.model.Login;
import com.codecool.queststore.model.server.session.Session;
import com.codecool.queststore.model.server.session.SessionPool;
import com.codecool.queststore.model.user.Role;
import com.codecool.queststore.model.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.*;

class LoginServiceTest {
    String name = "Seba";
    String password = "Seba";
    String surname = "Brajlich";
    String email = "sb@gmail.com";
    String address = "NeverLand";
    int id = 12;
    Role role = Role.ADMIN;

    @Test
    void testLoginServiceConstructor(){
        LoginService loginService = spy(new LoginService(name, password));
        doReturn(null).when(loginService).SignIn();
        User user = loginService.SignIn();
        loginService.sessionCreationIfUserValid(user);
        assertEquals(null, loginService.getSession());
    }

    @Test
    void ifUserHasSession(){
        User user = new User(name, surname, email, address, id, role);
        LoginService loginService = spy(new LoginService(name, password));
        doReturn(user).when(loginService).SignIn();
        User newUser = loginService.SignIn();
        loginService.sessionCreationIfUserValid(newUser);
        assertTrue(SessionPool.sessions.contains(loginService.getSession()));
    }



}