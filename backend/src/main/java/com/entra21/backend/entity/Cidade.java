package com.entra21.backend.entity;

import java.util.*;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cidade")
@Data
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nome;

    @ManyToOne//muitas cidades para um estado
    @JoinColumn(name = "idEstado")//nome da coluna de relacionamento
    private Estado estado;//objeto Estado do tipo estado
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;
    
}
//entidade pronta
//elas sao as que mudam 