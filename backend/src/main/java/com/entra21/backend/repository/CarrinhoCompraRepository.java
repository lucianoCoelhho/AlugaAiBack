package com.entra21.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.backend.entity.CarrinhoCompra;

public interface CarrinhoCompraRepository extends JpaRepository<CarrinhoCompra, Long>{
    
}
