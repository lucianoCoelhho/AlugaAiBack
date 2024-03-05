package com.entra21.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Pessoa;
import com.entra21.backend.repository.PessoaRepository;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> buscarTodos(){
        return pessoaRepository.findAll();
    }

    public Pessoa inserir(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
        return pessoaNova;
    }

    public Pessoa alterar(Pessoa pessoa){
       Pessoa pessoaNovo = pessoaRepository.findById(pessoa.getId()).orElse(null);

        if (pessoaNovo != null) {
            // Preserva a data de criação original
            pessoa.setDataCriacao(pessoaNovo.getDataCriacao());
    
            // Atualiza a data de atualização
            pessoa.setDataAtualizacao(new Date());
    
            return pessoaRepository.saveAndFlush(pessoa);
        }

        // Lógica de tratamento se o estado não existir
        return null;
    }

    public void excluir(long id){
        Pessoa pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }

}
