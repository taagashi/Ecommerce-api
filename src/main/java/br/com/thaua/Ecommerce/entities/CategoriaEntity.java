package br.com.thaua.Ecommerce.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "categorias_db")
@Getter
@Setter
public class CategoriaEntity extends AbstractEntity<Long>{
    private String nomeCategoria;

    @ManyToMany
    @JoinTable(
            name = "categoria_produto",
            joinColumns = @JoinColumn(name = "categoria_id"),
            inverseJoinColumns = @JoinColumn(name = "produto_id")
    )
    private List<ProdutoEntity> produtos;
}
