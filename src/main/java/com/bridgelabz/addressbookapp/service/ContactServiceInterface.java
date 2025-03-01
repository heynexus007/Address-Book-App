package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.model.Contact;
import java.util.*;

public interface ContactServiceInterface {
    Contact addContact(ContactDTO contactDTO);
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact updateContact(Long id, ContactDTO contactDTO);
    void deleteContact(Long id);
}
