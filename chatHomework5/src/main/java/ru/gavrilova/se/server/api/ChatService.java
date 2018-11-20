package ru.gavrilova.se.server.api;

import ru.gavrilova.se.server.model.Contact;
import ru.gavrilova.se.server.model.Message;
import ru.gavrilova.se.server.model.Session;
import ru.gavrilova.se.server.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Set;

@WebService
public interface ChatService {

    @WebMethod
    boolean register(@WebParam String login, @WebParam String password);

    @WebMethod
    List<String> getListLogin();

    @WebMethod
    boolean isLoginExists(@WebParam String login);

    @WebMethod
    Session signIn(@WebParam String login, @WebParam String password);

    @WebMethod
    User getUser(@WebParam Session session);

    @WebMethod
    void signOut(@WebParam Session session);

    @WebMethod
    List<Message> getMessage(@WebParam Session session);

    @WebMethod
    void sendMessage(@WebParam Session session, @WebParam String login, @WebParam String message);

    @WebMethod
    void sendBroadCast(@WebParam Session session, @WebParam String message);

    @WebMethod
    void clearMessage(@WebParam Session session);


    @WebMethod
    void removeContscts(@WebParam Session session); //new

    @WebMethod
    Set<Contact> getContacts(@WebParam Session session); //new

    @WebMethod
    void createContact(@WebParam Session session, String login);  //new

    @WebMethod
    void removeContact(@WebParam Session session, String login);  //new
}
