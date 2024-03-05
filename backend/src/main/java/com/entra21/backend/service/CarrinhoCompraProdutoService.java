package com.entra21.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.CarrinhoCompraProduto;
import com.entra21.backend.repository.CarrinhoCompraProdutoRepository;

@Service
public class CarrinhoCompraProdutoService {
    
    @Autowired
    private CarrinhoCompraProdutoRepository carrinhoCompraProdutoRepository;

    public List<CarrinhoCompraProduto> buscarTodos(){
        return carrinhoCompraProdutoRepository.findAll();
    }

    public CarrinhoCompraProduto inserir(CarrinhoCompraProduto carrinhoCompraProduto){
        carrinhoCompraProduto.setDataCriacao(new Date());
        CarrinhoCompraProduto carrinhoCompraProdutoNovo = carrinhoCompraProdutoRepository.saveAndFlush(carrinhoCompraProduto);
        return carrinhoCompraProdutoNovo;
    }

    public CarrinhoCompraProduto alterar(CarrinhoCompraProduto carrinhoCompraProduto){
        CarrinhoCompraProduto carrinhoCompraProdutoNovo = carrinhoCompraProdutoRepository.findById(carrinhoCompraProduto.getId()).orElse(null);

        if (carrinhoCompraProdutoNovo != null) {
            carrinhoCompraProduto.setDataCriacao(carrinhoCompraProdutoNovo.getDataCriacao());

            carrinhoCompraProduto.setDataAtualizacao(new Date());

            return carrinhoCompraProdutoRepository.saveAndFlush(carrinhoCompraProduto);
        }
        return null;
    }

    public void excluir(long id){
        CarrinhoCompraProduto carrinhoCompraProduto = carrinhoCompraProdutoRepository.findById(id).get();
        carrinhoCompraProdutoRepository.delete(carrinhoCompraProduto);
    }

}
