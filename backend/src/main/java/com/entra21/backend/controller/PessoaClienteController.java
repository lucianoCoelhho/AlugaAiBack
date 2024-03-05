package com.entra21.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entra21.backend.dto.PessoaClienteRequestDTO;
import com.entra21.backend.entity.Pessoa;
import com.entra21.backend.service.PessoaClienteService;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*")
public class PessoaClienteController {

    @Autowired

    private PessoaClienteService pessoaClienteService;

    @PostMapping("/")
    public Pessoa inserir(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        return pessoaClienteService.registrar(pessoaClienteRequestDTO);
    }

}
