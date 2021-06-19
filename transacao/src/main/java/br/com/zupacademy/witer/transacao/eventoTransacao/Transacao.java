package br.com.zupacademy.witer.transacao.eventoTransacao;

import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.Cartao;
import br.com.zupacademy.witer.transacao.eventoTransacao.estabelecimento.Estabelecimento;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_transacao")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String idTransacao;

    @Positive
    @NotNull
    private BigDecimal valor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Estabelecimento estabelecimento;

    @ManyToOne
    private Cartao cartao;

    @NotNull
    private LocalDateTime efetivadaEm;

    @Deprecated
    public Transacao() {
    }

    public Transacao(@NotBlank String id, @Positive @NotNull BigDecimal valor, Estabelecimento estabelecimento,
                     Cartao cartao,@NotNull LocalDateTime efetivadaEm) {
        this.idTransacao = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

}
