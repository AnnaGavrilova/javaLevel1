package ru.gavrilova.se.server.api;

import ru.gavrilova.se.server.model.Contact;
import ru.gavrilova.se.server.model.ContactBox;

public interface ContactService {

    ContactBox contacts(String login);

    Contact create(String source, String target);

    void remove(String source, String target);

    void removeAll(String login);
}
