package ru.gavrilova.se.server.api;

import ru.gavrilova.se.server.model.Message;

import java.util.List;

public interface MessageService {
    List<Message> getMessage(String login);

    void sendBroadCast(String source, String text);

    void sendMessage(String source, String target, String text);

    void cleanMessage(String login);
}
