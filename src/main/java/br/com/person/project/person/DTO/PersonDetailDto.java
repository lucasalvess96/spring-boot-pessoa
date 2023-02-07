package br.com.person.project.person.DTO;

import br.com.person.project.person.PersonEntity;

public class PersonDetailDto {
    private String name;
    private String age;
    private String cpf;
    private String email;

    public PersonDetailDto() {
    }

    public PersonDetailDto(PersonEntity personEntity) {
        this.name = personEntity.getName();
        this.age = personEntity.getAge();
        this.cpf = personEntity.getCpf();
        this.email = personEntity.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
