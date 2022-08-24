package br.com.carv.msclient.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_client")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String certificatePerson;

    @Column(nullable = false)
    private String name;

    private Integer age;

    public Client() {
    }

    public Client(String certificatePerson, String name, Integer age) {
        this.certificatePerson = certificatePerson;
        this.name = name;
        this.age = age;
    }
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCertificatePerson() {
        return certificatePerson;
    }
    public void setCertificatePerson(String certificatePerson) {
        this.certificatePerson = certificatePerson;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "Client\nName: " + getName() + "C.P.F: " + getCertificatePerson();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id.equals(client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
