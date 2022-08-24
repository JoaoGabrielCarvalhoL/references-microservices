package br.com.carv.mscards.repository;

import br.com.carv.mscards.model.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {


    List<ClientCard> findClientCardByCertificatePerson(String certificatePerson);
}
