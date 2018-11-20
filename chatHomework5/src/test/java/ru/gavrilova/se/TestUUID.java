package ru.gavrilova.se;

import org.junit.Test;

import java.util.UUID;

public class TestUUID {

    @Test
    public void test() {
        System.out.println(UUID.randomUUID().toString());
        System.out.println(System.currentTimeMillis());
    }
}
