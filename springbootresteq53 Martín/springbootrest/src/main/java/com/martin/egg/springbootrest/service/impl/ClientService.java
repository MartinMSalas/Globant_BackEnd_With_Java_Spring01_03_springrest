package com.martin.egg.springbootrest.service.impl;

import com.martin.egg.springbootrest.dto.ClientDTO;
import com.martin.egg.springbootrest.entity.Client;
import com.martin.egg.springbootrest.mapper.ClientMapper;
import com.martin.egg.springbootrest.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements com.martin.egg.springbootrest.service.ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientMapper clientMapper, ClientRepository clientRepository) {
        this.clientMapper = clientMapper;
        this.clientRepository = clientRepository;
    }
    @Override
    public String getOneClient() {
        String client = "{'name':'Martin','surname':'Egg','age':25}"; //JSON
        List<Client> clientList =clientRepository.findAll();
        //Client client = clientList.get(0);

        return client;
    }

    @Override
    public ClientDTO createClient(ClientDTO clientDTO) {
        Client client = clientMapper.clientDTOToClient(clientDTO);
        clientDTO.setName("Dario");
        System.out.println(client);

        Client clientSaved = clientRepository.save(client);

        ClientDTO clientDTOSaved = clientMapper.clientToClientDTO(clientSaved);
        return clientDTOSaved;
    }

    @Override
    public ClientDTO deleteClient(Long id) {
        Optional<Client> client  = clientRepository.findById(id);
        if(client.isPresent()){

            clientRepository.deleteById(id);
            ClientDTO clientDTO = clientMapper.clientToClientDTO(client.get());
            return clientDTO;
        }
        return null;
    }


}
