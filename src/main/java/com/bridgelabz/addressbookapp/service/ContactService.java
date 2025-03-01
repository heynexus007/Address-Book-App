package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.ContactNotFoundException;
import com.bridgelabz.addressbookapp.model.Contact;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ContactService implements ContactServiceInterface {

    private final List<Contact> contactList = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1); // To generate unique IDs

    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact newContact = new Contact(idCounter.getAndIncrement(), contactDTO.getName(), contactDTO.getPhone(), contactDTO.getEmail());
        contactList.add(newContact);
        return newContact;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactList;
    }

    @Override
    public Contact getContactById(Long id) {
        return contactList.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with ID: " + id));
    }

    @Override
    public Contact updateContact(Long id, ContactDTO contactDTO) {
        Contact existingContact = getContactById(id);
        existingContact.setName(contactDTO.getName());
        existingContact.setPhone(contactDTO.getPhone());
        existingContact.setEmail(contactDTO.getEmail());
        return existingContact;
    }

    @Override
    public void deleteContact(Long id) {
        Contact contact = getContactById(id);
        contactList.remove(contact);
    }
}
