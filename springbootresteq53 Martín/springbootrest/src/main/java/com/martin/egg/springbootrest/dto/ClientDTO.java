package com.martin.egg.springbootrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ClientDTO {

    private Long clientId;

    private String name;
    private String email;
    private String phone;
    private String surname;

}
