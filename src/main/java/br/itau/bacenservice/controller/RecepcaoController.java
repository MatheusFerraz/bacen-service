package br.itau.bacenservice.controller;

import br.itau.bacenservice.exception.ApiBacenException;
import br.itau.bacenservice.exception.EndpointException;
import br.itau.bacenservice.model.Recepcao;
import br.itau.bacenservice.payload.RecepcaoRequest;
import br.itau.bacenservice.service.RecepcaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bacen")
public class RecepcaoController {

    @Autowired
    RecepcaoService recepcaoService;

    private static final Logger logger = LoggerFactory.getLogger(RecepcaoController.class);

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Recepcao> persistirRecepcaoTransferencia(@RequestBody RecepcaoRequest recepcaoRequest) throws EndpointException {

        try {
            Recepcao recepcaoPersistir = new Recepcao();
            recepcaoPersistir.setHashTransacao(recepcaoRequest.getHashTransacao());
            recepcaoPersistir.setCodigoBancoOrigem(recepcaoRequest.getCodigoBancoOrigem());

            Recepcao recepcaoPersistida = recepcaoService.salvarRecepcao(recepcaoPersistir);

            return ResponseEntity.ok(recepcaoPersistida);
        } catch (ApiBacenException e) {
            logger.error("Erro: " + e.getMessage(), e);
            throw new EndpointException("Erro: " + e.getMessage());
        }
    }
}
