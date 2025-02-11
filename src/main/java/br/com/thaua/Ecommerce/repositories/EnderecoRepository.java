package br.com.thaua.Ecommerce.repositories;

import br.com.thaua.Ecommerce.entities.EnderecoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {
    Optional<EnderecoEntity> findByClienteId(Long Long);
}
