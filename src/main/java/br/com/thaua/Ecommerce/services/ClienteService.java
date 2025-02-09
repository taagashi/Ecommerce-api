package br.com.thaua.Ecommerce.services;

import br.com.thaua.Ecommerce.dtos.ClienteRequest;
import br.com.thaua.Ecommerce.entities.ClienteEntity;
import br.com.thaua.Ecommerce.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@Service
@AllArgsConstructor
public class ClienteService {
    private ClienteRepository clienteRepository;

    @Transactional
    public ClienteEntity adicionarCliente(ClienteEntity clienteEntity)
    {
        return clienteRepository.save(clienteEntity);
    }

    public Page<ClienteEntity> exibirClientes(Pageable pageable)
    {
        return clienteRepository.findAll(pageable);
    }
}
