package com.entra21.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Permissao;
import com.entra21.backend.entity.PermissaoPessoa;
import com.entra21.backend.entity.Pessoa;
import com.entra21.backend.repository.PermissaoPessoaRepository;
import com.entra21.backend.repository.PermissaoRepository;

@Service
public class PermissaoPessoaService {

    @Autowired
    private PermissaoPessoaRepository permissaoPessoaRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    // recebera uma objeto do tipo pessoa
    public void vincularPessoaPermissaoCliente(Pessoa pessoa) {
        List<Permissao> listaPermissao = permissaoRepository.findByNome("cliente");// a consulta
        if(listaPermissao.size() > 0){
              PermissaoPessoa permissaoPessoa = new PermissaoPessoa();
              permissaoPessoa.setPessoa(pessoa);
              permissaoPessoa.setPermissao(listaPermissao.get(0));
              permissaoPessoa.setDataCriacao(new Date());
              permissaoPessoaRepository.saveAndFlush(permissaoPessoa);
        }
    }
}
