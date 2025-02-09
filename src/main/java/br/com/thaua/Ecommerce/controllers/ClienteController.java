package br.com.thaua.Ecommerce.controllers;

import br.com.thaua.Ecommerce.dtos.ClienteRequest;
import br.com.thaua.Ecommerce.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@Tag(
        name = "Controlador de clientes",
        description = "responsavel por gerenciar tudo relacionado ao cliente"
)
public class ClienteController {
    private ClienteService clienteService;

    @Operation(
            summary = "Adicionar cliente",
            description = "Adiciona um cliente passando campos de nome, email, cpf e telefone"
    )
    @PostMapping
    public ResponseEntity<ClienteRequest> adicionarCliente(@RequestBody ClienteRequest clienteRequest)
    {
        return ResponseEntity.ok(clienteRequest);
    }
}
