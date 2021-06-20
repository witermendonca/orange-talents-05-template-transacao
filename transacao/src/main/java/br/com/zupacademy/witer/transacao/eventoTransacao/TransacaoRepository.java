package br.com.zupacademy.witer.transacao.eventoTransacao;

import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.Cartao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    Page<Transacao> findAllByCartao(Cartao cartao, Pageable page);
}
