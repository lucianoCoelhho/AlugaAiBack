package com.entra21.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.backend.entity.Cidade;

//interface por que nao vai ter implementacoes
//jpa vai nos fornecer todas os metodos de excluir, alterar, consultar...
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
    //nao muda nada
} 