package com.entra21.backend.repository;
//O segundo 
import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.backend.entity.Estado;

//interface por que nao vai ter implementacoes
//jpa vai nos fornecer todas os metodos de excluir, alterar, consultar...
public interface EstadoRepository extends JpaRepository<Estado, Long>{
    
}