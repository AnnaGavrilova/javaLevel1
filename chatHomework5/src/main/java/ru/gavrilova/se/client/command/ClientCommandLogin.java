package ru.gavrilova.se.client.command;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Session;

import java.util.Scanner;

public class ClientCommandLogin extends AbstractClientCommand {

    public ClientCommandLogin(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println("Enter login: ");
        final String login = scanner.nextLine();
        System.out.println("Enter password: ");
        final String password = scanner.nextLine();
        session = chatService.signIn(login, password);
        final String msg = session != null ? "Ok" : "Error";
        System.out.println("Auth: " + msg);
    }
}
