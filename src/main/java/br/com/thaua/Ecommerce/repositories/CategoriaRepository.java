package br.com.thaua.Ecommerce.repositories;

import br.com.thaua.Ecommerce.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
