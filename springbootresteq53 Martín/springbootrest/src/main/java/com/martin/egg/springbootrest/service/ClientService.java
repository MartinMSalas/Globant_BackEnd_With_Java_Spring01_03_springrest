package com.martin.egg.springbootrest.service;

import com.martin.egg.springbootrest.dto.ClientDTO;

public interface ClientService {

    String getOneClient();

    ClientDTO createClient(ClientDTO clientDTO);

    ClientDTO deleteClient(Long id);
}
