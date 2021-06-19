package br.com.zupacademy.witer.transacao.eventoTransacao.cartao;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_cartao")
public class Cartao {

    @Id
    @NotBlank
    private String id;

    @Email
    @NotBlank
    private String email;

    @Deprecated
    public Cartao() {
    }

    public Cartao(@NotBlank String id, @Email @NotBlank String email) {
        this.id = id;
        this.email = email;
    }

}
