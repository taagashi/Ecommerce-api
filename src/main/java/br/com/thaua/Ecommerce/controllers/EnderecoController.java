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
    @PostMapping("/{id}/enderecos")
    public ResponseEntity<EnderecoResponse> adicionarEnderecoCliente(@PathVariable Long id, @RequestBody EnderecoRequest enderecoRequest)
    {
        EnderecoEntity enderecoEntity = converter.toEntity(enderecoRequest);
        EnderecoEntity enderecoAdicionado = enderecoService.adicionarEndereco(id, enderecoEntity);
        return ResponseEntity.ok(converter.toResponse(enderecoAdicionado));
    }
}
