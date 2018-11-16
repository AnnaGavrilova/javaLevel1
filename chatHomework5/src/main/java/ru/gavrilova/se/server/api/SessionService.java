package ru.gavrilova.se.server.api;

import ru.gavrilova.se.server.model.Session;
import ru.gavrilova.se.server.model.User;

public interface SessionService {

    Session signIn(String login, String password);

    User getUser(Session session);

    void signOut(Session session);
}
