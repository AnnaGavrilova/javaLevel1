package ru.gavrilova.se.client;


import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Message;
import ru.gavrilova.se.server.model.Session;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.List;
import java.util.Scanner;


public class ClientService {

    private static final String CMD_EXIT = "exit";
    private static final String CMD_LOGIN = "login";
    private static final String CMD_LOGOUT = "logout";
    private static final String CMD_READ = "read";
    private static final String CMD_SEND = "send";
    private static final String CMD_USERS = "users";
    private static final String CMD_BROADCAST = "broadcast";

    private static final String LOCAL_PART = "ChatServiceBeanService";
    private static final String LOCAL_NAMESPACE = "http://service.server.se.gavrilova.ru";
    private static final String WSDL = "http://localhost:8080/ChatService?wsdl";

    private final URL url;
    private final QName qname;
    private final Service service;
    private final ChatService chatService;
    private final Scanner scanner;

    private Session session = null;

    public ClientService() throws Exception {
        url = new URL(WSDL);
        qname = new QName(LOCAL_NAMESPACE, LOCAL_PART);
        service = Service.create(url, qname);
        chatService = service.getPort(ChatService.class);
        scanner = new Scanner(System.in);
    }

    public void run() {
        String cmd = "";
        while (!CMD_EXIT.equals(cmd)) {
            System.out.println("Enter CMD: ");
            cmd = scanner.nextLine();
            switch (cmd) {
                case CMD_LOGIN:
                    login();
                    break;

                case CMD_LOGOUT:
                    logout();
                    break;

                case CMD_READ:
                    read();
                    break;

                case CMD_SEND:
                    send();
                    break;

                case CMD_USERS:
                    users();
                    break;

                case CMD_BROADCAST:
                    broadcast();
                    break;
            }
            System.out.println();
        }
    }

    private void login() {
        System.out.println("Enter login: ");
        final String login = scanner.nextLine();
        System.out.println("Enter password: ");
        final String password = scanner.nextLine();
        session = chatService.signIn(login, password);
        final String msg = session != null ? "Ok" : "Error";
        System.out.println("Auth: " + msg);
    }

    private void logout() {
        chatService.signOut(session);
    }

    private void send() {
        System.out.println("Enter login: ");
        final String login = scanner.nextLine();
        System.out.println("Enter message: ");
        final String message = scanner.nextLine();
        chatService.sendMessage(session, login, message);
    }

    private void read() {
        final List<Message> messages = chatService.getMessage(session);
        for (final Message message : messages) {
            System.out.println("** Incom message **");
            System.out.println("From: " + message.source);
            System.out.println("Text: " + message.text);
        }
    }

    private void users() {
        System.out.println(chatService.getListLogin());
    }

    private void broadcast() {
        System.out.println("Enter message: ");
        final String message = scanner.nextLine();
        chatService.sendBroadCast(session, message);
    }
}
