package br.com.thaua.Ecommerce.mappers;

import br.com.thaua.Ecommerce.dtos.cliente.ClienteRequest;
import br.com.thaua.Ecommerce.dtos.cliente.ClienteResponse;
import br.com.thaua.Ecommerce.dtos.endereco.EnderecoRequest;
import br.com.thaua.Ecommerce.dtos.endereco.EnderecoResponse;
import br.com.thaua.Ecommerce.entities.ClienteEntity;
import br.com.thaua.Ecommerce.entities.EnderecoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface Converter {
    ClienteEntity toEntity(ClienteRequest clienteRequest);
    @Mapping(target = "dataCadastro", source = "dataCadastro", qualifiedByName = "formatarData")
    @Mapping(target = "pedidosFeitos", expression = "java(clienteEntity.getPedidos() != null ? clienteEntity.getPedidos().size() : 0)")
    ClienteResponse toResponse(ClienteEntity clienteEntity);

    @Named("formatarData")
    default String formatarData(LocalDateTime localDateTime)
    {
        return localDateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    EnderecoEntity toEntity(EnderecoRequest enderecoRequest);
    @Mapping(target = "cliente", expression = "java(enderecoEntity.getCliente().getNome())")
    EnderecoResponse toResponse(EnderecoEntity enderecoEntity);
}
