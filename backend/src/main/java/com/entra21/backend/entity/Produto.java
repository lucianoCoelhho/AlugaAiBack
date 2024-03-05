package com.entra21.backend.entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "produto")
@Data
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String image;
    private String name;
    private String descricaoCurta;
    private String descricaoDetalhada;
    private double valorAluguel;

    @ManyToOne
    @JoinColumn(name = "idMarca")//uma marca pode ter muitos  produtos
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "idCategoria")//uma categoria pode ter muitos  produtos
    private Categoria categoria;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
