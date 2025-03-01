package com.bridgelabz.addressbookapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContactDTO {
    private String name;
    private String phone;
    private String email;
}
