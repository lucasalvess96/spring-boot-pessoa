package br.com.person.project.cart.Dto;

import br.com.person.project.cart.CartEntity;
import br.com.person.project.items.Items;
import jakarta.validation.constraints.NotBlank;

import java.util.ArrayList;
import java.util.List;

public class CreateCartDto {

    private long id;
    private double total;

    @NotBlank(message = "Nome nao deve está vazio")
    private String name;

    private List<Items> itemsEntity = new ArrayList<>();

    public CreateCartDto() {
    }

    public CreateCartDto(CartEntity cart) {
        this.id = cart.getId();
        this.total = cart.getTotal();
        this.name = cart.getName();
        this.itemsEntity = cart.getItemsList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Items> getItemsEntity() {
        return itemsEntity;
    }

    public void setItemsEntity(List<Items> itemsEntity) {
        this.itemsEntity = itemsEntity;
    }
}
