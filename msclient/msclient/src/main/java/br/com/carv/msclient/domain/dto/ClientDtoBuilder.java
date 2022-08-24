package br.com.carv.msclient.domain.dto;

import br.com.carv.msclient.domain.Client;

public class ClientDtoBuilder {

    private ClientDto client;

    public ClientDtoBuilder() {
        this.client = new ClientDto();
    }

    public static ClientDtoBuilder builder() {
        return new ClientDtoBuilder();
    }

    public ClientDtoBuilder id(Long id) {
        this.client.setId(id);
        return this;
    }

    public ClientDtoBuilder certificatePerson(String certificatePerson) {
        this.client.setCertificatePerson(certificatePerson);
        return this;
    }

    public ClientDtoBuilder name(String name) {
        this.client.setName(name);
        return this;
    }

    public ClientDtoBuilder age(Integer age) {
        this.client.setAge(age);
        return this;
    }

    public ClientDto build() {
        return this.client;
    }
}
