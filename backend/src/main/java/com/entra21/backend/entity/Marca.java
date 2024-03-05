package com.entra21.backend.entity;

import java.util.*;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "marca")
@Data
public class Marca {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

}
