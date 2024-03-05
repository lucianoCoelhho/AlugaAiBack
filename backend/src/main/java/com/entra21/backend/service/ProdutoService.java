package com.entra21.backend.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Produto;
import com.entra21.backend.repository.ProdutoRepository;


@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Produto inserir(Produto produto){
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepository.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto alterar(Produto produto){
        Produto produtoNovo = produtoRepository.findById(produto.getId()).orElse(null);

        if (produtoNovo != null) {
            // Preserva a data de criação original
            produto.setDataCriacao(produtoNovo.getDataCriacao());
    
            // Atualiza a data de atualização
            produto.setDataAtualizacao(new Date());
    
            return produtoRepository.saveAndFlush(produto);
        }

        // Lógica de tratamento se o estado não existir
        return null;
    }

    public  void excluir(long id){
        Produto produto  = produtoRepository.findById(id).get();
        produtoRepository.delete(produto);
    }

}
