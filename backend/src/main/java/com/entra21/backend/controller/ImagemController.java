package com.entra21.backend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.entra21.backend.entity.Imagem;
import com.entra21.backend.service.ImagemService;

@RestController
@RequestMapping("/api/imagem")
@CrossOrigin(origins = "*")
public class ImagemController {
    
    @Autowired
    private ImagemService imagemService;

    @GetMapping("/")
    public List<Imagem> buscarTodos(){
        return imagemService.buscarTodos();
    }

    @PostMapping("/")
    public Imagem inserir(@RequestParam("idProduto") Long idProduto ,@RequestParam("file") MultipartFile file){
        return imagemService.inserir(idProduto, file);
    }

    @PutMapping("/")
    public Imagem alterar(@RequestBody Imagem imagem){
        return imagemService.alterar(imagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") long id){
        imagemService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
