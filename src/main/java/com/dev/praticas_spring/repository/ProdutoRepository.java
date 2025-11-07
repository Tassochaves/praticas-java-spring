package com.dev.praticas_spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.praticas_spring.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
