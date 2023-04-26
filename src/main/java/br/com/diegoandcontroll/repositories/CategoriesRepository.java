package br.com.diegoandcontroll.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.diegoandcontroll.domain.Categories;


public interface CategoriesRepository extends JpaRepository<Categories, UUID>{
  
}
