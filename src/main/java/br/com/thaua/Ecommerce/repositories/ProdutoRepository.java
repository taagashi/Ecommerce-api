package br.com.thaua.Ecommerce.repositories;

import br.com.thaua.Ecommerce.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
}
