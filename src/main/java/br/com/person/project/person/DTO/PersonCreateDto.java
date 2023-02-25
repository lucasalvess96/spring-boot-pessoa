package br.com.person.project.person.DTO;

import br.com.person.project.address.AddressEntity;
import br.com.person.project.person.PersonEntity;
import jakarta.validation.constraints.*;

public class PersonCreateDto {

    @NotBlank(message = "Nome nao deve está vazio")
    @Size(min = 3, max = 32)
    @Pattern(regexp = "^([A-Za-z]+[A-Za-z ])*$")
    private String name;

    @NotBlank(message = "idade deve ser preenchida")
    @Size(min =2, max = 2)
    private String age;

    @NotBlank(message = "cpf deve ser preenchido")
    @Size( min= 14, max = 14)
    private String cpf;

    @NotBlank(message = "email deve ser preenchido")
    @Email
    private String email;

    @NotBlank(message = "senha deve ter entre 3 e 16 caracters")
    @Size(min = 3, max = 16)
    private String password;

    private AddressEntity addressEntity;

    public PersonCreateDto() {
    }

    public PersonCreateDto(PersonEntity personEntity) {
        this.name = personEntity.getName();
        this.age = personEntity.getAge();
        this.cpf = personEntity.getCpf();
        this.email = personEntity.getEmail();
        this.password = personEntity.getPassword();
        this.addressEntity = personEntity.getAddress();
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }
}
