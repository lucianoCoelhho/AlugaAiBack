package com.entra21.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.backend.entity.Categoria;

//interface por que nao vai ter implementacoes
//jpa vai nos fornecer todas os metodos de excluir, alterar, consultar...
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

    
} 
