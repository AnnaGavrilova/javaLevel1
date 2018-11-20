package ru.gavrilova.se.client.command;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Session;

import java.util.Scanner;

public class ClientCommandContactCreate extends AbstractClientCommand{

    public ClientCommandContactCreate(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        System.out.println("Enter login: ");
        final String login = scanner.nextLine();
        chatService.createContact(session, login);

    }
}
