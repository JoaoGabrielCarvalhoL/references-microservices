package br.com.carv.msclient.domain;

public class ClientBuilder {

    private Client client;
    public ClientBuilder() {
        client = new Client();
    }
    public static ClientBuilder builder() {
        return new ClientBuilder();
    }
    public ClientBuilder certificatePerson(String certficatePerson) {
        this.client.setCertificatePerson(certficatePerson);
        return this;
    }
    public ClientBuilder name(String name) {
        this.client.setName(name);
        return this;
    }
    public ClientBuilder age(Integer age) {
        this.client.setAge(age);
        return this;
    }
    public Client build() {
        return this.client;
    }
}
