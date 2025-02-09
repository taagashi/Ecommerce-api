package br.com.thaua.Ecommerce.services;

import br.com.thaua.Ecommerce.dtos.ClienteRequest;
import br.com.thaua.Ecommerce.entities.ClienteEntity;
import br.com.thaua.Ecommerce.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    public ClienteEntity adicionarCliente(ClienteEntity clienteEntity)
    {
        return clienteRepository.save(clienteEntity);
    }
}
