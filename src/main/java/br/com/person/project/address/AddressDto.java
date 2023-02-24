package br.com.person.project.address;

public class AddressDto {
    private String street;
    private long number;
    private String city;

    public AddressDto() {
    }

    public AddressDto(AddressEntity address) {
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.city = address.getCity();
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
}
