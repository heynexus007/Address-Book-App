package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}

