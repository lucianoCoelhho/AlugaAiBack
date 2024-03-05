package com.entra21.backend.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Marca;
import com.entra21.backend.repository.MarcaRepository;


@Service
public class MarcaService {
    
    @Autowired//faz o gerenciamento das pendencias
    private MarcaRepository marcaRepository;//objeto

    public List<Marca> buscarTodos(){
        return marcaRepository.findAll();//vai mostrar tudo do banco de dados
    }

    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());//vai colocar uma nova data de criacao
        Marca marcaNovo = marcaRepository.saveAndFlush(marca);//joga direto para o banco de dados
        return marcaNovo;
    }

    public Marca alterar(Marca marca){
       Marca marcaNovo = marcaRepository.findById(marca.getId()).orElse(null);

        if (marcaNovo != null) {
            // Preserva a data de criação original
            marca.setDataCriacao(marcaNovo.getDataCriacao());
    
            // Atualiza a data de atualização
            marca.setDataAtualizacao(new Date());
    
            return marcaRepository.saveAndFlush(marca);
        }

        // Lógica de tratamento se o estado não existir
        return null;
    }

    public void excluir(long id){
        Marca marca = marcaRepository.findById(id).get();
        marcaRepository.delete(marca);
    }

}
