package com.martin.egg.springbootrest.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OrderDTO {

    private Long orderId;
    private LocalDate date;
    private ClientDTO clientDTO;

    private String description;
}
