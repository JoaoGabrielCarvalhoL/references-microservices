package br.com.carv.mscreditassessor.service;

import br.com.carv.mscreditassessor.model.CustomerSituation;
import br.com.carv.mscreditassessor.model.DadosSolicitacaoEmissaoCartao;
import br.com.carv.mscreditassessor.model.ProtocoloSolicitacaoCartao;
import br.com.carv.mscreditassessor.model.ResponseEvaluationClient;

public interface CreditAssessorService {
    CustomerSituation getSituation(String certificatePerson);

    ResponseEvaluationClient makeEvaluation(String certificatePerson, Long income);

    ProtocoloSolicitacaoCartao solicitarEmissaoCartao(DadosSolicitacaoEmissaoCartao dados);
}
