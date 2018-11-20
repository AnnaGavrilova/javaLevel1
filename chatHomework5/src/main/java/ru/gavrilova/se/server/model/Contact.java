package ru.gavrilova.se.server.model;

import java.util.Objects;

public final class Contact {

    public String source;

    public String target;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(source, contact.source) && Objects.equals(target, contact.target);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, target);
    }
}


