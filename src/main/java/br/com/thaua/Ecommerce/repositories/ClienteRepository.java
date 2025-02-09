package br.com.thaua.Ecommerce.repositories;

import br.com.thaua.Ecommerce.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
