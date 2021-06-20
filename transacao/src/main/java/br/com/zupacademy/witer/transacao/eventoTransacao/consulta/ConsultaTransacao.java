package br.com.zupacademy.witer.transacao.eventoTransacao.consulta;

import br.com.zupacademy.witer.transacao.eventoTransacao.Transacao;
import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.Cartao;
import br.com.zupacademy.witer.transacao.eventoTransacao.estabelecimento.Estabelecimento;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaTransacao {

    private Long id;

    private String idTransacao;


    private BigDecimal valor;

    private Estabelecimento estabelecimento;

    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public ConsultaTransacao(Transacao transacao) {
        this.id = transacao.getId();
        this.idTransacao = transacao.getIdTransacao();
        this.valor = transacao.getValor();
        this.estabelecimento = transacao.getEstabelecimento();
        this.cartao = transacao.getCartao();
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public Long getId() {
        return id;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public static Page<ConsultaTransacao> toDTO(Page<Transacao> transacoes) {
        return transacoes.map(ConsultaTransacao::new);
    }
}
