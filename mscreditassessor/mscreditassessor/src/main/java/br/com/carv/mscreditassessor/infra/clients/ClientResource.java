package br.com.carv.mscreditassessor.infra.clients;

import br.com.carv.mscreditassessor.model.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclient", path = "/client")
public interface ClientResource {

    @GetMapping("findByCertificatePerson")
    ResponseEntity<ClientData> getClient(@RequestParam("certificatePerson") String certificatePerson);
}
