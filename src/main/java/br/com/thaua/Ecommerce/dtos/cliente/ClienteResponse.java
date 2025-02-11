package br.com.thaua.Ecommerce.dtos.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteResponse {
    private Long id;
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
    private Integer pedidosFeitos;
    private String dataCadastro;
}
