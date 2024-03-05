package com.entra21.backend.service;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Categoria;
import com.entra21.backend.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscarTodos(){
        return categoriaRepository.findAll();
    }

    public Categoria inserir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria categoriaNovo = categoriaRepository.saveAndFlush(categoria);
        return categoriaNovo;
    }

    public Categoria alterar(Categoria categoria){
        Categoria categoriaNovo = categoriaRepository.findById(categoria.getId()).orElse(null);

        if (categoriaNovo != null) {
            // Preserva a data de criação original
            categoria.setDataCriacao(categoriaNovo.getDataCriacao());
    
            // Atualiza a data de atualização
            categoria.setDataAtualizacao(new Date());
    
            return categoriaRepository.saveAndFlush(categoria);
        }

        // Lógica de tratamento se o estado não existir
        return null;
    }

    public void excluir(long id){
        Categoria categoria = categoriaRepository.findById(id).get();
        categoriaRepository.delete(categoria);
    }

}
