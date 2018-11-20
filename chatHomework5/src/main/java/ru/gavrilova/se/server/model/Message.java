package ru.gavrilova.se.server.model;

import java.util.UUID;

public final class Message {
    public String id = UUID.randomUUID().toString();
    public Long timestamp = System.currentTimeMillis();
    public String source;// отправитель
    public String target;//получатель
    public String text;
}
