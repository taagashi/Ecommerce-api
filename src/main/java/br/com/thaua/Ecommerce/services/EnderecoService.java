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
    public EnderecoEntity adicionarEndereco(Long clienteId, EnderecoEntity enderecoEntity)
    {
        ClienteEntity clienteEntity = clienteRepository.findById(clienteId).orElse(null);

        if(clienteEntity == null || clienteEntity.getEndereco() != null) {return null;}

        EnderecoEntity enderecoEntitySave = enderecoRepository.save(enderecoEntity);
        enderecoEntitySave.setCliente(clienteEntity);

        clienteEntity.setEndereco(enderecoEntitySave);
        clienteRepository.save(clienteEntity);

        return enderecoEntitySave;
    }

    public EnderecoEntity exibirEnderecoCliente(Long clienteId)
    {
        return enderecoRepository.findByClienteId(clienteId).orElse(null);
    }

    public EnderecoEntity atualizarEnderecoCliente(Long idCliente, EnderecoEntity enderecoEntity)
    {
        ClienteEntity clienteEntity = clienteRepository.findById(idCliente).orElse(null);

        if(clienteEntity == null){return null;}

        if(clienteEntity.getEndereco() == null){adicionarEndereco(idCliente, enderecoEntity);}

        clienteEntity.getEndereco().setRua(enderecoEntity.getRua());
        clienteEntity.getEndereco().setNumero(enderecoEntity.getNumero());
        clienteEntity.getEndereco().setBairro(enderecoEntity.getBairro());
        clienteEntity.getEndereco().setCidade(enderecoEntity.getCidade());
        clienteEntity.getEndereco().setEstado(enderecoEntity.getEstado());
        clienteEntity.getEndereco().setCep(enderecoEntity.getCep());

        clienteRepository.save(clienteEntity);

        enderecoEntity.setId(clienteEntity.getEndereco().getId());
        enderecoEntity.setCliente(clienteEntity);

        return enderecoEntity;
    }

    public String deletarEnderecoCliente(Long clienteId)
    {
       ClienteEntity clienteEntity = clienteRepository.findById(clienteId).orElse(null);

       if(clienteEntity == null){return "Não foi possivel encontrar cliente com esse id";}

       clienteEntity.setEndereco(null);

       clienteRepository.save(clienteEntity);

       return "Endereço de " + clienteEntity.getNome() + " foi removido com sucesso";
    }
}
