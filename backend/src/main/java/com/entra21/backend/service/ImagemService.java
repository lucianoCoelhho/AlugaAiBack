package com.entra21.backend.service;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entra21.backend.entity.Imagem;
import com.entra21.backend.entity.Produto;
import com.entra21.backend.repository.ImagemRepository;
import com.entra21.backend.repository.ProdutoRepository;

@Service
public class ImagemService {
    
    @Autowired
    private ImagemRepository imagemRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Imagem> buscarTodos(){
        return imagemRepository.findAll();
    }

    public Imagem inserir(Long idProduto, MultipartFile file){   
        Produto  produto = produtoRepository.findById(idProduto).get();
        Imagem objeto = new Imagem();

        try{
            if (!file.isEmpty()) {
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                    .get("c:/imagens/" + nomeImagem);
                Files.write(caminho,bytes);

                objeto.setNome(nomeImagem);
                
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        objeto.setProdutoImagem(produto);
        objeto.setDataCriacao(new Date());
        objeto = imagemRepository.saveAndFlush(objeto);
        return objeto;
    }

    public Imagem alterar(Imagem imagem){
        Imagem imagemNova = imagemRepository.findById(imagem.getId()).orElse(null);
        
        if (imagemNova != null) {
            // Preserva a data de criação original
            imagem.setDataCriacao(imagemNova.getDataCriacao());
    
            // Atualiza a data de atualização
            imagem.setDataAtualizacao(new Date());
    
            return imagemRepository.saveAndFlush(imagem);
        }

        // Lógica de tratamento se o estado não existir
        return null;

    }

    public void excluir(long id){
        Imagem imagem  = imagemRepository.findById(id).get();
        imagemRepository.delete(imagem);
    }
    
}
