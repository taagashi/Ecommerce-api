package br.com.thaua.Ecommerce.dtos.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {
    private String nome;
    private String email;
    private String cpf;
    private String telefone;
}
