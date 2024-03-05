package com.entra21.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.entra21.backend.entity.CarrinhoCompra;
import com.entra21.backend.service.CarrinhoCompraService;

@RestController
@RequestMapping("/api/carrinhoCompra")
@CrossOrigin(origins = "*")
public class CarrinhoCompraController {

    @Autowired
    private CarrinhoCompraService carrinhoCompraService;

    @GetMapping("/")
    public List<CarrinhoCompra> buscarTodos(){
        return carrinhoCompraService.buscarTodos();
    }

    @PostMapping("/")
    public CarrinhoCompra inserir(@RequestBody CarrinhoCompra carrinhoCompra){
        return carrinhoCompraService.inserir(carrinhoCompra);
    }
    
    @PutMapping("/")
    public CarrinhoCompra alterar(@RequestBody CarrinhoCompra carrinhoCompra){
        return carrinhoCompraService.alterar(carrinhoCompra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") long id){
        carrinhoCompraService.excluir(id);
        return ResponseEntity.ok().build();
    }
    
}
