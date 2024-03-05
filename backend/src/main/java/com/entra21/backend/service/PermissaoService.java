package com.entra21.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Permissao;
import com.entra21.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodos(){
        return permissaoRepository.findAll();
    }

    public Permissao inserir(Permissao permissao){
        permissao.setDataCriacao(new Date());
        Permissao permissaoNovo = permissaoRepository.saveAndFlush(permissao);
        return permissaoNovo;
    }

    public Permissao alterar(Permissao permissao){
        Permissao permissaoNovo = permissaoRepository.findById(permissao.getId()).orElse(null);

        if (permissaoNovo != null) {
            // Preserva a data de criação original
            permissao.setDataCriacao(permissaoNovo.getDataCriacao());
    
            // Atualiza a data de atualização
            permissao.setDataAtualizacao(new Date());
    
            return permissaoRepository.saveAndFlush(permissao);
        }

        // Lógica de tratamento se o estado não existir
        return null;
    }

    public void excluir(long id){
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }

}
