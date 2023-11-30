package com.martin.egg.springbootrest.controller;

import com.martin.egg.springbootrest.controller.ClientController;
import com.martin.egg.springbootrest.dto.ClientDTO;
import com.martin.egg.springbootrest.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClientService clientService;

    @Test
    public void getOneClientReturnsClient() throws Exception {
        String expectedClient = "{'name':'Martin','surname':'Egg','age':25}";


        when(clientService.getOneClient()).thenReturn(expectedClient);


        mockMvc.perform(get("/client/one"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedClient));
    }

    @Test
    public void createClientReturnsCreatedClient() throws Exception {
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Martin");
        clientDTO.setSurname("Egg");
        clientDTO.setEmail("a@a.com.ar");
        clientDTO.setPhone("123456789");

        when(clientService.createClient(any(ClientDTO.class))).thenReturn(clientDTO);

        mockMvc.perform(post("/client/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"Juan\",\"surname\":\"Reyes\",\"email\":\"a@r\",\"phone\":\"1234563333789\"}"))
                        .andExpect(status().isOk())
                        .andExpect(content().json("{\"name\":\"Martin\",\"surname\":\"Egg\",\"email\":\"a@a.com.ar\",\"phone\":\"123456789\"}"));
    }

    @Test
    public void deleteClientReturnsSuccessMessage() throws Exception {
        //doNothing().when(clientService).deleteClient(anyLong());
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Martin");
        clientDTO.setSurname("Egg");
        clientDTO.setEmail("a@a.com.ar");
        clientDTO.setPhone("123456789");

        when(clientService.deleteClient(anyLong())).thenReturn(clientDTO);
        mockMvc.perform(delete("/client/delete/10000"))
                .andExpect(status().isOk())
                .andExpect(content().string("Client deleted"));
    }
}