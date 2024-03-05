package com.entra21.backend.service;

import java.text.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.Pessoa;
import com.entra21.backend.repository.PessoaRepository;

@Service
public class PessoaGerenciamentoService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EmailService emailService;

    public String solicitarCodigo(String email) {

        Pessoa pessoa = pessoaRepository.findByEmail(email);
        if(pessoa != null){
            pessoa.setCodigoRecuperacaoSenha(getCodigoRecuperacaoSenha(pessoa.getId()));
            pessoa.setDataEnvioCodigo(new Date());
            pessoaRepository.saveAndFlush(pessoa);
            emailService.enviarEmailTexto(pessoa.getEmail(), "codigo de recuperacao de senha ",
                "o seu codigo de recuperacao de senha e o seguinte: " + pessoa.getCodigoRecuperacaoSenha());

            return "codigo enviado!";
        }else{
            return "Nenhuma pessoa encontrada com o email fornecido";
        }

    }// ira salvar a pessoa

        public String alterarSenha(Pessoa pessoa){

            Pessoa pessoaBanco = pessoaRepository.findByEmailAndCodigoRecuperacaoSenha(pessoa.getEmail(), pessoa.getCodigoRecuperacaoSenha());
            if(pessoaBanco != null){
                Date diferente = new Date(new Date().getTime() - pessoaBanco.getDataEnvioCodigo().getTime());
                if (diferente.getTime()/1000<900) {
                    pessoaBanco.setSenha(pessoa.getSenha());
                    pessoaBanco.setCodigoRecuperacaoSenha(null);
                    pessoaRepository.saveAndFlush(pessoaBanco);
                    return "senha alterado com sucesso";
                }else {
                    return "tempo expirado, solicite um novo codigo";
                }
            }else{
                return "email ou codigo nao encontrado";
            }
        }
    

    private String getCodigoRecuperacaoSenha(Long id) {
        DateFormat format = new SimpleDateFormat("ddMMyyyyHHmmssmm");
        return format.format(new Date()) + id;
    }

}
