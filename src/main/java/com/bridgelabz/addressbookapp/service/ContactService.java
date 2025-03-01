package com.bridgelabz.addressbookapp.service;

import com.bridgelabz.addressbookapp.dto.ContactDTO;
import com.bridgelabz.addressbookapp.exception.ContactNotFoundException;
import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService implements ContactServiceInterface{

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO.getName(), contactDTO.getPhone(), contactDTO.getEmail());
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("Contact not found with ID: " + id));
    }

    @Override
    public Contact updateContact(Long id, ContactDTO contactDTO) {
        Contact existingContact = getContactById(id);
        existingContact.setName(contactDTO.getName());
        existingContact.setPhone(contactDTO.getPhone());
        existingContact.setEmail(contactDTO.getEmail());
        return contactRepository.save(existingContact);
    }

    @Override
    public void deleteContact(Long id) {
        Contact contact = getContactById(id);
        contactRepository.delete(contact);
    }
}
