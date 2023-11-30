package com.martin.egg.springbootrest.mapper;

import com.martin.egg.springbootrest.dto.ClientDTO;
import com.martin.egg.springbootrest.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

/*
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses= {Client.class, ClientDTO.class})
*/
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ClientMapper {

    Client clientDTOToClient(ClientDTO clientDTO);

    ClientDTO clientToClientDTO(Client client);
}
