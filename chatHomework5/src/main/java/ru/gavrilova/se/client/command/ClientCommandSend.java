package ru.gavrilova.se.client.command;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Session;

import java.util.Scanner;

public class ClientCommandSend extends AbstractClientCommand {

    public ClientCommandSend(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println("Enter login: ");
        final String login = scanner.nextLine();
        System.out.println("Enter message: ");
        final String message = scanner.nextLine();
        chatService.sendMessage(session, login, message);
    }
}
