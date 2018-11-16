package ru.gavrilova.se.server.service;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.api.MessageService;
import ru.gavrilova.se.server.api.SessionService;
import ru.gavrilova.se.server.api.UserService;
import ru.gavrilova.se.server.model.Message;
import ru.gavrilova.se.server.model.Session;
import ru.gavrilova.se.server.model.User;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ru.gavrilova.se.server.api.ChatServise")
public final class ChatServiceBean implements ChatService {
    private final UserService userService = new UserServiceBean();

    private final MessageService messageService = new MessageServiceBean(userService);

    private final SessionService sessionService = new SessionServiceBean(userService);

    @Override
    @WebMethod
    public boolean isLoginExists(final String login) {
        return userService.isLoginExists(login);
    }

    @Override
    @WebMethod
    public boolean register(final String login, final String password) {
        return userService.register(login, password);
    }

    @Override
    @WebMethod
    public User getUser(final Session session) {
        return sessionService.getUser(session);
    }

    @Override
    @WebMethod
    public Session signIn(final String login, final String password) {
        return sessionService.signIn(login, password);
    }

    @Override
    @WebMethod
    public void signOut(final Session session) {
        sessionService.signOut(session);
    }

    @Override
    @WebMethod
    public List<Message> getMessage(final Session session) {
        final User user = sessionService.getUser(session);
        return messageService.getMessage(user.login);
    }


    @Override
    @WebMethod
    public void sendBroadCast(final Session session, final String message) {
        final User user = sessionService.getUser(session);
        messageService.sendBroadCast(user.login, message);
    }

    @Override
    @WebMethod
    public void sendMessage(final Session session, final String login, final String message) {
        final User source = sessionService.getUser(session);
        final User target = userService.getUser(login);
        messageService.sendMessage(source.login, target.login, message);
    }

    @Override
    @WebMethod
    public void clearMessage(Session session) {
        final User user = sessionService.getUser(session);
        messageService.cleanMessage(user.login);
    }

    @Override
    public List<String> getListLogin() {
        return userService.getListLogin();
    }

}
