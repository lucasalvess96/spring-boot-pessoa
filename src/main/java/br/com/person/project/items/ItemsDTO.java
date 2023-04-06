package br.com.person.project.items;

import br.com.person.project.cart.CartEntity;

public class ItemsDTO {

    private long id;

    private double itemTotal;

    private int quantity;

    private CartEntity cartEntity;

    public ItemsDTO() {
    }

    public ItemsDTO(Items items) {
        this.id = items.getId();
        this.itemTotal = items.getItemTotal();
        this.quantity = items.getQuantity();
        this.cartEntity = items.getCart();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getItemTotal() {
        return itemTotal;
    }

    public void setItemTotal(double itemTotal) {
        this.itemTotal = itemTotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CartEntity getCartEntity() {
        return cartEntity;
    }

    public void setCartEntity(CartEntity cartEntity) {
        this.cartEntity = cartEntity;
    }
}
