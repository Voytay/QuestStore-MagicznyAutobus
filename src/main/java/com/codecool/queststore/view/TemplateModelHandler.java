package com.codecool.queststore.view;

import com.codecool.queststore.model.classes.CodecoolClass;
import com.codecool.queststore.model.shop.artifact.Artifact;
import com.codecool.queststore.model.shop.quest.Quest;
import com.codecool.queststore.model.user.User;
import org.jtwig.JtwigModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateModelHandler implements TemplateModelInterface {
    @Override
    public JtwigModel getClassModel(User user, CodecoolClass ccClass) {
        return null;
    }

    @Override
    public JtwigModel getProfileStudentModel(User currentUser, User profile, CodecoolClass ccClass, List<Artifact> items) {
        JtwigModel model = new JtwigModel();
        model.with("currentUser", currentUser);
        model.with("profile", profile);
        model.with("ccClass", ccClass);
        model.with("items", items);
        model.with("title", "Profile");

        return model;
    }

    @Override
    public JtwigModel getProfileMentorModel(User logedUser, User user, List<CodecoolClass> classes) {
        return null;
    }

    @Override
    public JtwigModel getUserListModel(User logedUser, List<User> users) {
        return null;
    }

    @Override
    public JtwigModel getQuestModel(User logedUser, List<Quest> quests) {
        return null;
    }

    @Override
    public JtwigModel getArtifactModel(User logedUser, List<Artifact> artifacts) {
        return null;
    }
}
