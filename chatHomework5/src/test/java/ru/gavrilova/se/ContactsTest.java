package ru.gavrilova.se;

import org.junit.Assert;
import org.junit.Test;
import ru.gavrilova.se.server.api.ContactService;
import ru.gavrilova.se.server.service.ContactServiceBean;


public class ContactsTest {
    @Test
    public void CreateContactTest() {

        final ContactService service = new ContactServiceBean();

        service.create("admin", "Anna");

        Assert.assertFalse(service.contacts("admin").isEmpty());


    }
}
