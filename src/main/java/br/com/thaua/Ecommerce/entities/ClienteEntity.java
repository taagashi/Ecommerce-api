package br.com.thaua.Ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "clientes_tb")
@Getter
@Setter
public class ClienteEntity extends AbstractEntity<Long>{
    private String nome;
    private String email;
    private String cpf;
    private String telefone;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PedidoEntity> pedidos;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "endereco_id")
    private EnderecoEntity endereco;
}
