package br.com.carv.msclient.repository;

import br.com.carv.msclient.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByCertificatePerson(String certificate);
}
