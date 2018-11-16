package ru.gavrilova.se.server.service;

import com.sun.corba.se.spi.protocol.RequestDispatcherRegistry;
import ru.gavrilova.se.server.api.SessionService;
import ru.gavrilova.se.server.api.UserService;
import ru.gavrilova.se.server.model.Session;
import ru.gavrilova.se.server.model.User;

import java.util.HashMap;
import java.util.Map;

public final class SessionServiceBean implements SessionService {

    private final UserService userService;

    private final Map<Session, User> sessions = new HashMap<>();

    public SessionServiceBean(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public Session signIn(final String login, final String password) {
        if (login == null || login.isEmpty()) return null;
        if (password == null || password.isEmpty()) return null;
        final User user = userService.getUser(login);
        if (user == null) return null;
        if (!password.equals(user.password)) return null;
        final Session session = new Session();
        sessions.put(session, user);
        return session;
    }

    @Override
    public User getUser(final Session session) {
        if (session == null) return null;
        return sessions.get(session);
    }

    @Override
    public void signOut(final Session session) {
        if (session == null) return;
        sessions.remove(session);
    }
}
