package br.com.zupacademy.witer.transacao.eventoTransacao.estabelecimento;

import javax.validation.constraints.NotBlank;

public class EstabelecimentoDaTransacao {

    @NotBlank
    private String nome;

    @NotBlank
    private String cidade;

    @NotBlank
    private  String endereco;

    public EstabelecimentoDaTransacao() {
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estabelecimento toModel(){
        return new Estabelecimento(nome,cidade,endereco);
    }
}
