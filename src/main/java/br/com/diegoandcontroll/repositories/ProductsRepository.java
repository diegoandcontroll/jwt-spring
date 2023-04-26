package br.com.diegoandcontroll.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diegoandcontroll.domain.Products;

public interface ProductsRepository extends JpaRepository<Products, UUID> {
  
}
