package ru.gavrilova.se.client.command;

import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Contact;
import ru.gavrilova.se.server.model.Session;

import java.util.Scanner;
import java.util.Set;

public class ClientCommandContacts extends AbstractClientCommand {

    public ClientCommandContacts(ChatService chatService, Session session, Scanner scanner) {
        super(chatService, session, scanner);
    }

    @Override
    public void execute() {
        if (session == null) return;
        final Set<Contact> contacts = chatService.getContacts(session);
        for (final Contact contact : contacts) {
            if (contact == null) continue;
            System.out.println(contact.target);
        }
    }
}
