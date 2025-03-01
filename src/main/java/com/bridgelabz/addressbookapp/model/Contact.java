package com.bridgelabz.addressbookapp.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "contacts")
@Data
@NoArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;

    // Constructor using DTO
    public Contact(Long id,String name, String phone, String email) {
        this.id=id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
}
