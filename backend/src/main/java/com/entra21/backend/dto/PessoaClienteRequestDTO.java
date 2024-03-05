package com.entra21.backend.dto;

import org.springframework.beans.BeanUtils;

import com.entra21.backend.entity.Cidade;
import com.entra21.backend.entity.Pessoa;

import lombok.Data;

//padrao para transferencia de dados
@Data
public class PessoaClienteRequestDTO {

    private String nome;
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Cidade cidade;

    // vai copiar todas as propriedades de RequestDTO para a pessoa
    public Pessoa converter(PessoaClienteRequestDTO pessoaClienteRequestDTO) {
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoa);
        return pessoa;
    }

}
