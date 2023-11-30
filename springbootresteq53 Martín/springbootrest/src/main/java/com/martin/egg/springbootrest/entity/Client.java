package com.martin.egg.springbootrest.entity;
// id, nombre, email, telefono, apellido;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Client {
    @Id
    private Long clientId;

    private String name;
    private String email;
    private String phone;
    private String surname;


}
