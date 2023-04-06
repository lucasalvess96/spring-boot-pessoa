package br.com.person.project.address;

import br.com.person.project.person.PersonEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
public class AddressEntity {
    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private long number;
    private String city;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "address", fetch = FetchType.EAGER)
    @JsonManagedReference
    private PersonEntity personEntity;

    public AddressEntity() {
    }

    public AddressEntity(Long id, String street, long number, String city, PersonEntity personEntity) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
        this.personEntity = personEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}
