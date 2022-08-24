package br.com.carv.msclient.domain.dto;

public class ClientDto {

    private Long id;
    private String certificatePerson;
    private String name;
    private Integer age;

    public ClientDto() {

    }

    public ClientDto(Long id, String certificatePerson, String name, Integer age) {
        this.id = id;
        this.certificatePerson = certificatePerson;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCertificatePerson() {
        return certificatePerson;
    }

    public void setCertificatePerson(String certificatePerson) {
        this.certificatePerson = certificatePerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
