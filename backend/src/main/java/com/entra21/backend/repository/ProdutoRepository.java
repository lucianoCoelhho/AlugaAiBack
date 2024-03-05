package com.entra21.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.backend.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}