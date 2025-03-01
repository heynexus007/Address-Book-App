package com.bridgelabz.addressbookapp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;

    // Constructor using DTO
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

//    // Add Getters
//    public String getName() { return name; }
//    public String getPhone() { return phone; }
//    public String getEmail() { return email; }
//
//    // Add Setters (if needed)
//    public void setName(String name) { this.name = name; }
//    public void setPhone(String phone) { this.phone = phone; }
//    public void setEmail(String email) { this.email = email; }
}
