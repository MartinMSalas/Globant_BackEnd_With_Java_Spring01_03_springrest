package com.martin.egg.springbootrest.controller;

import com.martin.egg.springbootrest.dto.ClientDTO;
import com.martin.egg.springbootrest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping("/one") //localhost:8081/client/one
    public ResponseEntity<String> getOneClient(){
        String client = clientService.getOneClient();
        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {

        ClientDTO client = clientService.createClient(clientDTO);

        return new ResponseEntity<>(client, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Long id) {

        ClientDTO clientDTO = clientService.deleteClient(id);
        if(clientDTO == null){
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Client deleted", HttpStatus.OK);
    }

}
