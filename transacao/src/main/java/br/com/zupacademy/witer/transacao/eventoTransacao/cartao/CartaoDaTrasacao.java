package br.com.zupacademy.witer.transacao.eventoTransacao.cartao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CartaoDaTrasacao {

    @NotBlank
    private String id;

    @Email
    @NotBlank
    private String email;

    public CartaoDaTrasacao() {
    }

    public String getId() { return id; }

    public String getEmail() { return email; }

    public Cartao toModel(){
        return  new Cartao(id,email);
    }

}
