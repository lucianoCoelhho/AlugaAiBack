package com.entra21.backend.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "carrinhoCompra")
@Data
public class CarrinhoCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date dataCompra;
    private String descricao;
    private String situacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
