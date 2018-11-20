package ru.gavrilova.se.client.command;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Message;
import ru.gavrilova.se.server.model.Session;

import java.util.List;
import java.util.Scanner;

public class ClientCommandRead extends AbstractClientCommand {

    public ClientCommandRead(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        final List<Message> messages = chatService.getMessage(session);
        for (final Message message : messages) {
            System.out.println("** Incom message **");
            System.out.println("From: " + message.source);
            System.out.println("Text: " + message.text);
        }
    }
}
