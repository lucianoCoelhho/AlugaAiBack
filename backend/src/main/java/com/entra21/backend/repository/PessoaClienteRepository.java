package com.entra21.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.backend.entity.Pessoa;

public interface PessoaClienteRepository extends JpaRepository<Pessoa, Long>{

}
