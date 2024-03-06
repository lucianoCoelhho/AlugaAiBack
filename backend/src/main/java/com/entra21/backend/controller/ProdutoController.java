package com.entra21.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.entra21.backend.entity.Produto;
import com.entra21.backend.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
@CrossOrigin(origins = "*")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/get")
    public List<Produto> buscarTodos(){
        return produtoService.buscarTodos();
    }

    @PostMapping("/post")
    public Produto inserir(@RequestBody Produto produto){
        return produtoService.inserir(produto);
    }

    @PutMapping("/put")
    public Produto alterar(@RequestBody Produto produto){
        return produtoService.alterar(produto);
    }

    @DeleteMapping("/{id}delete")
    public ResponseEntity<Void> excluir(@PathVariable("id") long id){
        produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
