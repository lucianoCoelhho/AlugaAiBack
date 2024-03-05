package com.entra21.backend.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entra21.backend.entity.CarrinhoCompra;
import com.entra21.backend.repository.CarrinhoCompraRepository;


@Service
public class CarrinhoCompraService {
    
    @Autowired
    private CarrinhoCompraRepository carrinhoCompraRepository;

    public List<CarrinhoCompra> buscarTodos(){
        return carrinhoCompraRepository.findAll();
    }

    public CarrinhoCompra inserir(CarrinhoCompra carrinhoCompra){
        carrinhoCompra.setDataCriacao(new Date());
        CarrinhoCompra carrinhoCompraNovo = carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
        return carrinhoCompraNovo;
    }

    public CarrinhoCompra alterar(CarrinhoCompra carrinhoCompra){
        CarrinhoCompra carrinhoCompraNovo = carrinhoCompraRepository.findById(carrinhoCompra.getId()).orElse(null);

        if (carrinhoCompraNovo != null) {
            // Preserva a data de criação original
            carrinhoCompra.setDataCriacao(carrinhoCompraNovo.getDataCriacao());
    
            // Atualiza a data de atualização
            carrinhoCompra.setDataAtualizacao(new Date());
    
            return carrinhoCompraRepository.saveAndFlush(carrinhoCompra);
        }

        // Lógica de tratamento se o estado não existir
        return null;      
    }

    public void excluir(long id){
        CarrinhoCompra carrinhoCompra = carrinhoCompraRepository.findById(id).get();
        carrinhoCompraRepository.delete(carrinhoCompra);
    }

}
