package br.com.zupacademy.witer.transacao.eventoTransacao.consulta;

import br.com.zupacademy.witer.transacao.eventoTransacao.Transacao;
import br.com.zupacademy.witer.transacao.eventoTransacao.TransacaoRepository;
import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.Cartao;
import br.com.zupacademy.witer.transacao.eventoTransacao.cartao.CartaoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api/transacoes")
public class ConsultaTransacaoController {

    private TransacaoRepository transacaoRepository;
    private CartaoRepository cartaoRepository;

    @Autowired
    public ConsultaTransacaoController(TransacaoRepository transacaoRepository, CartaoRepository cartaoRepository) {
        this.transacaoRepository = transacaoRepository;
        this.cartaoRepository = cartaoRepository;
    }

    private Logger logger = LogManager.getLogger(ConsultaTransacaoController.class);

    @GetMapping("/{idCartao}")
    public ResponseEntity<?> consultaTransacoes(@PathVariable("idCartao") String idCartao,
                                                @PageableDefault(sort = "efetivadaEm") Pageable page){
        //valor default @PageableDefault direction = Sort.Direction.ASC, page = 0, size = 10

        //valida Cartão existente.
        Optional<Cartao> cartaoCadastrado = cartaoRepository.findById(idCartao);
        if(cartaoCadastrado.isEmpty()){
            logger.warn("Cartão não encontrado.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cartão não encontrado.");
        }

        Page<Transacao> listTransacoes = transacaoRepository.findAllByCartao(cartaoCadastrado.get(), page);
        return ResponseEntity.ok().body(ConsultaTransacao.toDTO(listTransacoes));
    }
}
