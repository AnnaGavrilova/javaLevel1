package ru.gavrilova.se.client.command;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Session;

import java.util.Scanner;

public abstract class AbstractClientCommand implements Command {

    protected ChatService chatService;

    protected Session session;

    protected Scanner scanner;

    public AbstractClientCommand(ChatService chatService, Session session, Scanner scanner) {
        this.chatService = chatService;
        this.session = session;
        this.scanner = scanner;
    }

}
