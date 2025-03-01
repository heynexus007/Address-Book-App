package com.bridgelabz.addressbookapp.controller;

import com.bridgelabz.addressbookapp.model.Contact;
import com.bridgelabz.addressbookapp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public Contact createContact(@RequestBody Contact contact) {
        return contactService.saveContact(contact);
    }

    @GetMapping
    public List<Contact> getContacts() {
        return contactService.getAllContacts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}

