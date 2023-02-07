package br.com.person.project.person.DTO;

import br.com.person.project.person.PersonEntity;

public class PersonListDto {
    private String name;
    private String email;

    public PersonListDto() {
    }

    public PersonListDto(PersonEntity personEntity) {
        this.name = personEntity.getName();
        this.email = personEntity.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
