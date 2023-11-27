package br.itau.bacenservice.service;

import br.itau.bacenservice.exception.ApiBacenException;
import br.itau.bacenservice.model.Recepcao;
import br.itau.bacenservice.repository.RecepcaoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecepcaoService {

    @Autowired
    RecepcaoRepository recepcaoRepository;

    private static final Logger logger = LoggerFactory.getLogger(RecepcaoService.class);

    public Recepcao salvarRecepcao(Recepcao recepcao) throws ApiBacenException {

        try {
            Recepcao recepcaoPersitida = recepcaoRepository.saveAndFlush(recepcao);

            return recepcaoPersitida;
        } catch (Exception e) {
            logger.error("Ocorreu um erro ao salvar recepção de transferência: " + e.getMessage(), e);
            throw new ApiBacenException("Ocorreu um erro ao salvar recepção de transferência: " + e.getMessage());
        }
    }
}
