package br.com.zupacademy.witer.transacao.eventoTransacao.estabelecimento;


import br.com.zupacademy.witer.transacao.eventoTransacao.Transacao;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_estabelecimento")
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private  String endereco;

    @Deprecated
    public Estabelecimento() {
    }

    public Estabelecimento(@NotBlank String nome, @NotBlank String cidade, @NotBlank String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

}