package br.com.thaua.Ecommerce.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "produtos_db")
@Getter
@Setter
public class ProdutoEntity extends AbstractEntity<Long> {
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private Integer estoque;

    @ManyToMany(mappedBy = "produtos")
    private List<CategoriaEntity> categorias;
}
