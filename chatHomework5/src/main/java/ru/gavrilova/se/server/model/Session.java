package ru.gavrilova.se.server.model;


import java.util.Objects;
import java.util.UUID;

public final class Session {

    public Long timestamp = System.currentTimeMillis();

    public String id = UUID.randomUUID().toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        final boolean checkTimeatamp = Objects.equals(timestamp, session.timestamp);
        final boolean checkSessionId = Objects.equals(id, session.id);
        return checkTimeatamp && checkSessionId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, id);
    }
}
