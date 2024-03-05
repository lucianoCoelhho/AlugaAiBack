package com.entra21.backend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.entra21.backend.entity.CarrinhoCompraProduto;
import com.entra21.backend.service.CarrinhoCompraProdutoService;

@RestController
@RequestMapping("/api/carrinho")
@CrossOrigin(origins = "*")
public class CarrinhoCompraProdutoController {
    
    @Autowired
    private CarrinhoCompraProdutoService carrinhoCompraProdutoService;

    @GetMapping("/")
    public List<CarrinhoCompraProduto> buscarTodos(){
        return carrinhoCompraProdutoService.buscarTodos();
    }

    @PostMapping("/")
    public CarrinhoCompraProduto inserir(@RequestBody CarrinhoCompraProduto carrinhoCompraProduto){
        return carrinhoCompraProdutoService.inserir(carrinhoCompraProduto);
    }

    @PutMapping("/")
    public CarrinhoCompraProduto alterar(@RequestBody CarrinhoCompraProduto carrinhoCompraProduto){
        return carrinhoCompraProdutoService.alterar(carrinhoCompraProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") long id){
        carrinhoCompraProdutoService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
