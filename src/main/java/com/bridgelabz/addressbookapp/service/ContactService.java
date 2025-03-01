package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
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

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact saveContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO.getName(), contactDTO.getPhone(), contactDTO.getEmail());
        return contactRepository.save(contact);
    }

    public Contact updateContact(Long id, ContactDTO updatedContactDTO) {
        return contactRepository.findById(id)
                .map(contact -> {
                    contact.setName(updatedContactDTO.getName());
                    contact.setPhone(updatedContactDTO.getPhone());
                    contact.setEmail(updatedContactDTO.getEmail());
                    return contactRepository.save(contact);
                })
                .orElse(null);
    }

    public boolean deleteContact(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
