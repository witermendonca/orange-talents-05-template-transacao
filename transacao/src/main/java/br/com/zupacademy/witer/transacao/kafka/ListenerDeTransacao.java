package br.com.zupacademy.witer.transacao.kafka;

import br.com.zupacademy.witer.transacao.eventoTransacao.EventoDeTransacao;
import br.com.zupacademy.witer.transacao.eventoTransacao.TransacaoRepository;
import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.Cartao;
import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.CartaoDaTrasacao;
import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.CartaoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ListenerDeTransacao {

    private TransacaoRepository transacaoRepository;
    private CartaoRepository cartaoRepository;

    @Autowired
    public ListenerDeTransacao(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    private Logger logger = LogManager.getLogger(ListenerDeTransacao.class);

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    public void ouvir(EventoDeTransacao eventoDeTransacao) {

        logger.info("Transação recebida. Id Transação: {}", eventoDeTransacao.getId());

        CartaoDaTrasacao cartaoResposta = eventoDeTransacao.getCartao();
        Optional<Cartao> cartao = cartaoRepository.findById(cartaoResposta.getId());
        if (cartao.isEmpty()){
            cartaoRepository.save(cartaoResposta.toModel());
        }

        transacaoRepository.save(eventoDeTransacao.toModel(cartaoResposta.toModel()));
        logger.info("Transação salva. Id Transação: {}", eventoDeTransacao.getId());
    }
}
