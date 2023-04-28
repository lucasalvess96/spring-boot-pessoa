package br.com.person.project.cart;

import br.com.person.project.items.Items;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="CART")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private long id;

    private double total;

    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Items> itemsList = new HashSet<>();

    public CartEntity() {
    }

    public CartEntity(long id, double total, String name, Set<Items> itemsList) {
        this.id = id;
        this.total = total;
        this.name = name;
        this.itemsList = itemsList;
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

    public Set<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(Set<Items> itemsList) {
        this.itemsList = itemsList;
    }
}
