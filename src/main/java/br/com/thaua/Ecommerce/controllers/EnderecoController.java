package br.com.thaua.Ecommerce.controllers;

import br.com.thaua.Ecommerce.dtos.endereco.EnderecoRequest;
import br.com.thaua.Ecommerce.dtos.endereco.EnderecoResponse;
import br.com.thaua.Ecommerce.entities.EnderecoEntity;
import br.com.thaua.Ecommerce.mappers.Converter;
import br.com.thaua.Ecommerce.services.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
@Tag(
        name = "Controlador de enderecos",
        description = "Controlador de enderecos de clientes"
)
public class EnderecoController {
    private EnderecoService enderecoService;
    private Converter converter;

    @Operation(
            summary = "Adicionar endereco para um cliente",
            description = "Adiciona um endereco para um cliente atribuindo id do cliente e todos os campos do endereco"
    )
    @PostMapping("/{clienteId}/enderecos")
    public ResponseEntity<EnderecoResponse> adicionarEnderecoCliente(@PathVariable Long clienteId, @RequestBody EnderecoRequest enderecoRequest)
    {
        EnderecoEntity enderecoEntity = converter.toEntity(enderecoRequest);
        EnderecoEntity enderecoAdicionado = enderecoService.adicionarEndereco(clienteId, enderecoEntity);
        return ResponseEntity.ok(converter.toResponse(enderecoAdicionado));
    }

    @Operation(
            summary = "Exibir endereco de cliente",
            description = "Exibe o endereco de um cliente atraves do id do cliente"
    )
    @GetMapping("/{clienteId}/enderecos")
    public ResponseEntity<EnderecoResponse> exibirEnderecoCliente(@PathVariable Long clienteId)
    {
        EnderecoEntity enderecoEntity = enderecoService.exibirEnderecoCliente(clienteId);
        return ResponseEntity.ok(converter.toResponse(enderecoEntity));
    }

    @Operation(
            summary = "Atualizar informacoes de endereco do cliente",
            description = "Atualiza informacoes passando um novo endereco para um cliente rastreado pelo seu id"
    )
    @PutMapping("/{clienteId}/enderecos")
    public ResponseEntity<EnderecoResponse> atualizarEnderecoCliente(@PathVariable Long clienteId, @RequestBody EnderecoRequest enderecoRequest)
    {
       EnderecoEntity enderecoEntity = converter.toEntity(enderecoRequest);
       return ResponseEntity.ok(converter.toResponse(enderecoService.atualizarEnderecoCliente(
               clienteId, enderecoEntity
       )));
    }

    @Operation(
            summary = "Deletar endereco do cliente",
            description = "Deleta endereco do cliente atraves do id do cliente"
    )
    @DeleteMapping("/{clienteId}/enderecos")
    public ResponseEntity<String> deletarEnderecoDeCliente(@PathVariable Long clienteId)
    {
        return ResponseEntity.ok(enderecoService.deletarEnderecoCliente(clienteId));
    }
}
