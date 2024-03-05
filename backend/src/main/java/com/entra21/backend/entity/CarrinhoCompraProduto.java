package com.entra21.backend.entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "carrinhoCompraProdu")
@Data
public class CarrinhoCompraProduto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double valor;

    private double quantidade;

    private String observacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
