package ru.gavrilova.se.server.service;

import ru.gavrilova.se.server.api.ContactService;
import ru.gavrilova.se.server.model.Contact;
import ru.gavrilova.se.server.model.ContactBox;

import java.util.LinkedHashMap;
import java.util.Map;

public final class ContactServiceBean implements ContactService {

    private final Map<String, ContactBox> contacts = new LinkedHashMap<>();

    @Override
    public ContactBox contacts(String login) {
        if (login == null || login.isEmpty()) return null;
        if (!contacts.containsKey(login)) contacts.put(login, new ContactBox());
        return contacts.get(login);
    }

    @Override
    public void remove(final String source, final String target) {
        if (source == null || source.isEmpty()) return;
        if (target == null || target.isEmpty()) return;
        final ContactBox contacts = contacts(source);
        //contacts.removeIf(e -> e.source.equals(source) && e.target.equals(target));
    }

    @Override
    public Contact create(String source, String target) {
        if (source == null || source.isEmpty()) return null;
        if (target == null || target.isEmpty()) return null;
        final Contact contact = new Contact();
        contact.source = source;
        contact.target = target;
        contacts(source).add(contact);
        return contact;
    }

    @Override
    public void removeAll(String login) {
        contacts.put(login, new ContactBox());
    }

}
