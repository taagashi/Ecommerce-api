package br.com.thaua.Ecommerce.services;

import br.com.thaua.Ecommerce.entities.ClienteEntity;
import br.com.thaua.Ecommerce.entities.EnderecoEntity;
import br.com.thaua.Ecommerce.repositories.ClienteRepository;
import br.com.thaua.Ecommerce.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EnderecoService {
    private EnderecoRepository enderecoRepository;
    private ClienteRepository clienteRepository;

    @Transactional
    public EnderecoEntity adicionarEndereco(Long id, EnderecoEntity enderecoEntity)
    {
        ClienteEntity clienteEntity = clienteRepository.findById(id).orElse(null);

        if(clienteEntity == null || clienteEntity.getEndereco() != null) {return null;}

        EnderecoEntity enderecoEntitySave = enderecoRepository.save(enderecoEntity);
        enderecoEntitySave.setCliente(clienteEntity);

        clienteEntity.setEndereco(enderecoEntitySave);
        clienteRepository.save(clienteEntity);

        return enderecoEntitySave;
    }
}
