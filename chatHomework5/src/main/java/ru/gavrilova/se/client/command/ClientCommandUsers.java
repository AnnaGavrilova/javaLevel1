package ru.gavrilova.se.client.command;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Session;

import java.util.Scanner;

public class ClientCommandUsers extends AbstractClientCommand {

    public ClientCommandUsers(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        System.out.println(chatService.getListLogin());
    }
}
