package com.martin.egg.springbootrest.service.impl;

import com.martin.egg.springbootrest.dto.ClientDTO;
import com.martin.egg.springbootrest.entity.Client;
import com.martin.egg.springbootrest.mapper.ClientMapper;
import com.martin.egg.springbootrest.repository.ClientRepository;
import com.martin.egg.springbootrest.service.impl.ClientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private ClientMapper clientMapper;

    @InjectMocks
    private ClientService clientService;

    @Test
    public void testGetOneClient() {
        String expectedClient = "{'name':'Martin','surname':'Egg','age':25}";
        String actualClient = clientService.getOneClient();
        assertEquals(expectedClient, actualClient);
    }

    @Test
    public void testCreateClient() {
        ClientDTO clientDTO = new ClientDTO();
        Client client = new Client();
        Client savedClient = new Client();

        when(clientMapper.clientDTOToClient(clientDTO)).thenReturn(client);
        when(clientRepository.save(client)).thenReturn(savedClient);
        when(clientMapper.clientToClientDTO(savedClient)).thenReturn(clientDTO);

        ClientDTO actualClientDTO = clientService.createClient(clientDTO);

        verify(clientRepository, times(1)).save(client);
        assertEquals(clientDTO, actualClientDTO);
    }

    @Test
    public void testDeleteClient() {
        Long id = 1L;
        doNothing().when(clientRepository).deleteById(id);
        clientService.deleteClient(id);
        verify(clientRepository, times(1)).deleteById(id);
    }
}