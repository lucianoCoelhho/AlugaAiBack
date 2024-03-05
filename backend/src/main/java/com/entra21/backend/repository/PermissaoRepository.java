package com.entra21.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entra21.backend.entity.Permissao;
import java.util.List;


public interface PermissaoRepository extends JpaRepository<Permissao, Long>{
    List<Permissao> findByNome(String nome);//buscara  o metodo de busca
}
