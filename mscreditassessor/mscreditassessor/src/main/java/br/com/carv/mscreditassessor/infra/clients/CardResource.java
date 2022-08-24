package br.com.carv.mscreditassessor.infra.clients;

import br.com.carv.mscreditassessor.model.Card;
import br.com.carv.mscreditassessor.model.ClientCard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardResource {

    @GetMapping(params = "certificate")
    ResponseEntity<List<ClientCard>> getCardByClient(@RequestParam("certificate") String certificate);

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardByIncome(@RequestParam("income") Long income);
}
