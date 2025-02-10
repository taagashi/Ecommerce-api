package br.com.thaua.Ecommerce.controllers;

import br.com.thaua.Ecommerce.dtos.cliente.ClienteRequest;
import br.com.thaua.Ecommerce.dtos.cliente.ClienteResponse;
import br.com.thaua.Ecommerce.entities.ClienteEntity;
import br.com.thaua.Ecommerce.mappers.Converter;
import br.com.thaua.Ecommerce.pagination.Pagina;
import br.com.thaua.Ecommerce.services.ClienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
@Tag(
        name = "Controlador de clientes",
        description = "responsavel por gerenciar tudo relacionado ao cliente"
)
public class ClienteController {
    private ClienteService clienteService;
    private Converter converter;

    @Operation(
            summary = "Adicionar cliente",
            description = "Adiciona um cliente passando campos de nome, email, cpf e telefone"
    )
    @PostMapping
    public ResponseEntity<ClienteResponse> adicionarCliente(@RequestBody ClienteRequest clienteRequest)
    {
        ClienteEntity clienteEntity = clienteService.adicionarCliente(converter.toEntity(clienteRequest));
        return ResponseEntity.ok(converter.toResponse(clienteEntity));
    }

    @Operation(
            summary = "Exibir clientes",
            description = "Devolve uma lista de clientes com paginação"
    )
    @GetMapping
    public ResponseEntity<Pagina<ClienteResponse>> exibirClientes(@ParameterObject @PageableDefault(size = 4)Pageable pageable)
    {
        Page<ClienteEntity> page = clienteService.exibirClientes(pageable);

        Pagina<ClienteResponse> paginaClienteResponse = new Pagina<>(page.map(clienteEntity -> converter.toResponse(clienteEntity)));

        return ResponseEntity.ok(paginaClienteResponse);
    }

    @Operation(
            summary = "Buscar cliente por id",
            description = "Exibe cliente atraves de seu id do tipo long"
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponse> buscarClienteId(@PathVariable Long id)
    {
        return ResponseEntity.ok(converter.toResponse(clienteService.buscarClienteId(id)));
    }

    @Operation(
            summary = "Atualizar informacoes do cliente",
            description = "Atualiza informacoes do cliente passando o id do cliente que vai ser atualiado"
    )
    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> atualizarInformacoes(@PathVariable Long id, @RequestBody ClienteRequest clienteRequest)
    {
        return ResponseEntity.ok(converter.toResponse(clienteService.atualizarCliente(id, clienteRequest)));
    }
}
