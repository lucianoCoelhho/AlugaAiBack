package com.entra21.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.dto.PessoaClienteRequestDTO;
import com.entra21.backend.entity.Pessoa;
import com.entra21.backend.repository.PessoaClienteRepository;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaClienteRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new PessoaClienteRequestDTO().converter(pessoaClienteRequestDTO);// foi convertido

        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNova);
        //emailService.enviarEmailTexto(pessoaNova.getEmail(), "cadastro no AlugaAi", "O registro foi feito com sucesso. em breve voce recebera a senha de acesso por e-mail!! ");
        Map<String, Object> proprMap = new HashMap<>(); 
        proprMap.put("nome", pessoaNova.getNome());
        proprMap.put("mensagem", " O registro foi feito com sucesso. em breve voce recebera a senha de acesso por e-mail!! ");
        emailService.enviarEmailTemplate( pessoaNova.getEmail(), "Cadastro no AlugaAi", proprMap);
        return pessoaNova;
    }// ira salvar a pessoa

}
