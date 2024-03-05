package com.entra21.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.entra21.backend.entity.Marca;
import com.entra21.backend.service.MarcaService;

@RestController
@RequestMapping("/api/marca")
@CrossOrigin(origins = "*")
public class MarcaController {
    
    @Autowired
    private MarcaService maracaService;

    @GetMapping("/")
    public List<Marca> buscarTodos(){
        return maracaService.buscarTodos();
    }

    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca){
        return maracaService.inserir(marca);
    }

    @PutMapping("/")
    public Marca alterar(@RequestBody Marca marca){
        return maracaService.alterar(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") long id){
        maracaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
