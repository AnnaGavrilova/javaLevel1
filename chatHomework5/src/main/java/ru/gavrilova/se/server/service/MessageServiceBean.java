package ru.gavrilova.se.server.service;

import ru.gavrilova.se.server.api.MessageService;
import ru.gavrilova.se.server.api.UserService;
import ru.gavrilova.se.server.model.Message;
import ru.gavrilova.se.server.model.MessageBox;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class MessageServiceBean implements MessageService {

    private final Map<String, MessageBox> boxes = new HashMap<>();

    private final UserService userService;

    public MessageServiceBean(final UserService userService) {
        this.userService = userService;
    }

    private MessageBox getMessageBox(final String login) {
        if (login == null || login.isEmpty()) return null;
        if (!boxes.containsKey(login)) boxes.put(login, new MessageBox());
        return boxes.get(login);
    }

    @Override
    public List<Message> getMessage(final String login) {
        final MessageBox messageBox = getMessageBox(login);
        cleanMessage(login);
        return messageBox;
    }

    @Override
    public void sendBroadCast(final String source, final String text) {
        final Collection<String> logins = userService.getListLogin();
        for (final String target : logins) {
            if (source.equals(target)) continue;
            sendMessage(source, target, text);
        }
    }

    @Override
    public void sendMessage(final String source, final String target, final String text) {
        final Message message = new Message();
        message.source = source;
        message.target = target;
        message.text = text;
        final MessageBox messageBox = getMessageBox(target);
        messageBox.add(message);
    }


    @Override
    public void cleanMessage(final String login) {
        boxes.put(login, new MessageBox());
    }
}
