package com.entra21.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Cidade;
import com.entra21.backend.repository.CidadeRepository;

@Service
public class CidadeService {
    
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<Cidade> buscarTodos(){
        return cidadeRepository.findAll();
    }

    public Cidade inserir(Cidade cidade){
       cidade.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRepository.saveAndFlush(cidade);
        return cidadeNovo;
    }

    public Cidade alterar(Cidade cidade){
        Cidade cidadeNovo = cidadeRepository.findById(cidade.getId()).orElse(null);

        if (cidadeNovo != null) {
            // Preserva a data de criação original
            cidade.setDataCriacao(cidadeNovo.getDataCriacao());
    
            // Atualiza a data de atualização
            cidade.setDataAtualizacao(new Date());
    
            return cidadeRepository.saveAndFlush(cidade);
        }

        // Lógica de tratamento se o estado não existir
        return null;
    }

    public void excluir(long id){
        Cidade cidade = cidadeRepository.findById(id).get();
        cidadeRepository.delete(cidade);
    }

}
