package ru.gavrilova.se;

import org.junit.Assert;
import org.junit.Test;
import ru.gavrilova.se.server.api.ChatService;
import ru.gavrilova.se.server.model.Session;
import ru.gavrilova.se.server.service.ChatServiceBean;

public class ChatServerTest {

    @Test
    public void testRegister() {
        final ChatService service = new ChatServiceBean();
        Assert.assertTrue(service.register("admin", "admin"));
        Assert.assertFalse(service.register("admin", "admin"));
    }

    @Test
    public void testSignIn() {
        final ChatService service = new ChatServiceBean();
        Assert.assertNull(service.signIn("admin", "admin"));
        service.register("admin", "admin");
        Assert.assertNotNull(service.signIn("admin", "admin"));
    }

    @Test
    public void testSignOut() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");

        final Session sessionAdmin = service.signIn("admin", "admin");
        Assert.assertNotNull(sessionAdmin);
        Assert.assertNotNull(service.getUser(sessionAdmin));
        service.signOut(sessionAdmin);
        Assert.assertNull(service.getUser(sessionAdmin));
    }

    @Test
    public void testSendBroadCast() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("test", "test");
        service.register("Anna", "Anna");


        final Session sessionAdmin = service.signIn("admin", "admin");
        service.sendBroadCast(sessionAdmin, "Hello world!");
        Assert.assertTrue(service.getMessage(sessionAdmin).isEmpty());

        final Session sessionTest = service.signIn("test", "test");
        Assert.assertFalse(service.getMessage(sessionTest).isEmpty());
        Assert.assertTrue(service.getMessage(sessionTest).isEmpty());

        final Session sessionAnna = service.signIn("Anna", "Anna");
        Assert.assertFalse(service.getMessage(sessionAnna).isEmpty());
        Assert.assertTrue(service.getMessage(sessionAnna).isEmpty());
    }

    @Test
    public void testSendMessage() {
        final ChatService service = new ChatServiceBean();
        service.register("admin", "admin");
        service.register("test", "test");

        final Session sessionAdmin = service.signIn("admin", "admin");
        service.sendMessage(sessionAdmin, "test", "Hello world!");
        Assert.assertTrue(service.getMessage(sessionAdmin).isEmpty());

        final Session sessionTest = service.signIn("test", "test");
        Assert.assertFalse(service.getMessage(sessionTest).isEmpty());
        Assert.assertTrue(service.getMessage(sessionTest).isEmpty());
    }
}





