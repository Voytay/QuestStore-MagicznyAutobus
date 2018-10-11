package com.codecool.queststore.model;

import com.codecool.queststore.DAO.LoginDAO;
import com.codecool.queststore.DAO.UserDAO;
import com.codecool.queststore.model.user.User;

import java.sql.SQLException;

public class Login {

    private final String LOGIN;
    private final String PASSWORD;

    public Login(String login, String password) {
        this.LOGIN = login;
        this.PASSWORD = password;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    @Override
    public String toString() {
        return "Login{" +
                "LOGIN='" + LOGIN + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }
}
