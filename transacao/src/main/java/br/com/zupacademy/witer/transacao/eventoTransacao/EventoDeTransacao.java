package br.com.zupacademy.witer.transacao.eventoTransacao;

import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.Cartao;
import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.CartaoDaTrasacao;
import br.com.zupacademy.witer.transacao.eventoTransacao.estabelecimento.Estabelecimento;
import br.com.zupacademy.witer.transacao.eventoTransacao.estabelecimento.EstabelecimentoDaTransacao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventoDeTransacao {

    @NotBlank
    private String id;

    @Positive
    @NotNull
    private BigDecimal valor;

    @NotNull
    private EstabelecimentoDaTransacao estabelecimento;

    @NotNull
    private CartaoDaTrasacao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    public EventoDeTransacao() {
    }

    public String getId() {
        return id;
    }

    public BigDecimal getValor() { return valor; }

    public EstabelecimentoDaTransacao getEstabelecimento() { return estabelecimento; }

    public CartaoDaTrasacao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() { return efetivadaEm; }

    public Transacao toModel(Cartao cartao){
        Estabelecimento estabelecimento = this.estabelecimento.toModel();
        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }

}


