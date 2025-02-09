package br.com.thaua.Ecommerce.repositories;

import br.com.thaua.Ecommerce.entities.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
