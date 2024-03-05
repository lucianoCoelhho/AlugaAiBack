package com.entra21.backend.service;
//o service vai tratar de tudo: altera, remove... 
//o terceiro 
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Estado;
import com.entra21.backend.repository.EstadoRepository;

@Service
public class EstadoService {

    @Autowired // faz o gerenciamento das pendencias
    private EstadoRepository estadoRepository;// objeto

    public List<Estado> buscarTodos() {
        return estadoRepository.findAll();// vai mostrar tudo do banco de dados
    }

    public Estado inserir(Estado estado) {
        estado.setDataCriacao(new Date());// vai colocar uma nova data de criacao
        Estado estadoNovo = estadoRepository.saveAndFlush(estado);// joga direto para o banaco
        return estadoNovo;
    }

    public Estado alterar(Estado estado) {
        Estado estadoExistente = estadoRepository.findById(estado.getId()).orElse(null);

        if (estadoExistente != null) {
            // Preserva a data de criação original
            estado.setDataCriacao(estadoExistente.getDataCriacao());
    
            // Atualiza a data de atualização
            estado.setDataAtualizacao(new Date());
    
            return estadoRepository.saveAndFlush(estado);
        }

        // Lógica de tratamento se o estado não existir
        return null;
    }

    public void excluir(long id) {
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }

}