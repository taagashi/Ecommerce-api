package br.com.thaua.Ecommerce.entities;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public abstract class AbstractEntity<T> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
