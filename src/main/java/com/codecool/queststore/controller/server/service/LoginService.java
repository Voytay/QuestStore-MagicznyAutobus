package com.codecool.queststore.controller.server.service;

import com.codecool.queststore.DAO.LoginDAO;
import com.codecool.queststore.DAO.UserDAO;
import com.codecool.queststore.model.Login;
import com.codecool.queststore.model.server.session.Session;
import com.codecool.queststore.model.server.session.SessionPool;
import com.codecool.queststore.model.user.User;

import java.sql.SQLException;

public class LoginService {
    private Session session;
    private Login login;

    public LoginService(String name, String password) {
        this.login = new Login(name, password);

    }
    public User SignIn() {
        try {
            int userID = new LoginDAO().validation(this.login);

            if (userID > 0) {
                return new UserDAO().getUser(userID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void sessionCreationIfUserValid(User user){

        if (user != null)
            this.session = SessionPool.getNewSession(user.getID());
        else
            this.session = null;
    }

    public Session getSession(){
        return this.session;
    }
}
