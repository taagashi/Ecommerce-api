package br.com.thaua.Ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Table(name = "pedidos_db")
@Getter
@Setter
public class PedidoEntity extends AbstractEntity<Long>{
    private Integer quantidade;
    private BigDecimal precoTotal;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private ProdutoEntity produto;
}
