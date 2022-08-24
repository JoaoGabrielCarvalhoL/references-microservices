package br.com.carv.mscreditassessor.controller;

import br.com.carv.mscreditassessor.exception.ErroSolicitacaoCartao;
import br.com.carv.mscreditassessor.exception.ErrorOnCommunicationMSException;
import br.com.carv.mscreditassessor.exception.ResourceNotFoundException;
import br.com.carv.mscreditassessor.model.*;
import br.com.carv.mscreditassessor.service.CreditAssessorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("available")
public class CreditAssessorController {

    private final CreditAssessorService creditAssessorService;

    public CreditAssessorController(CreditAssessorService creditAssessorService) {
        this.creditAssessorService = creditAssessorService;
    }


    @GetMapping(value = "/situation-client", params = "certificatePerson")
    public ResponseEntity<?> customerSituationConsultation(@RequestParam ("certificatePerson") String certificatePerson) {

        try{
            CustomerSituation customerSituation = creditAssessorService.getSituation(certificatePerson);
            return ResponseEntity.ok(customerSituation);
        } catch (ResourceNotFoundException exception) {
            exception.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (ErrorOnCommunicationMSException exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.resolve(exception.getStatus())).body(exception.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity evaluation(@RequestBody EvaluationData data) {

        try{

            ResponseEvaluationClient response = creditAssessorService.makeEvaluation(data.getCertificatePerson(), data.getIncome());
            return ResponseEntity.ok(response);
        } catch (ResourceNotFoundException exception) {
            exception.printStackTrace();
            return ResponseEntity.notFound().build();
        } catch (ErrorOnCommunicationMSException exception) {
            exception.printStackTrace();
            return ResponseEntity.status(HttpStatus.resolve(exception.getStatus())).body(exception.getMessage());
        }

    }

    @PostMapping("solicitar-cartao")
    public ResponseEntity solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados) {
        try{
            ProtocoloSolicitacaoCartao protocoloSolicitacaoCartao = creditAssessorService.solicitarEmissaoCartao(dados);
            return ResponseEntity.ok(protocoloSolicitacaoCartao);

        } catch (ErroSolicitacaoCartao exception) {
            return ResponseEntity.internalServerError().body(exception.getMessage());
        }
    }

}
