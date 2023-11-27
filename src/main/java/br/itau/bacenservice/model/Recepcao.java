package br.itau.bacenservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "TB_RECEPCAO")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Recepcao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDENTIFICADOR_RECEPCAO")
    public Integer identificadorRecepcao;

    @Column(name = "HASH_TRANSACAO")
    public String hashTransacao;

    @Column(name = "CODIGO_BANCO_ORIGEM")
    public Integer codigoBancoOrigem;
}
