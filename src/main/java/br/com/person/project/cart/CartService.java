package br.com.person.project.cart;

import br.com.person.project.cart.Dto.CartDto;
import br.com.person.project.cart.Dto.CreateCartDto;
import br.com.person.project.items.Items;
import br.com.person.project.items.ItemsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final ItemsRepository itemsRepository;

    public CartService(CartRepository cartRepository, ItemsRepository itemsRepository) {
        this.cartRepository = cartRepository;
        this.itemsRepository = itemsRepository;
    }

    public CreateCartDto createCartDto(CreateCartDto createCartDto) {
        CartEntity cart = new CartEntity();
        cart.setTotal(createCartDto.getTotal());
        cart.setName(createCartDto.getName());
        cart.setItemsList(createCartDto.getItemsEntity());

        Items items = new Items();
        items.setItemTotal(createCartDto.getItemsEntity().get(0).getItemTotal());
        items.setQuantity(createCartDto.getItemsEntity().get(0).getQuantity());

        cart.getItemsList().add(items);
        items.setCart(cart);
        return new CreateCartDto(cartRepository.save(cart));
    }

    public Page<CartDto> cartList(Pageable pageable) {
        Page<CartEntity> cartEntityPage = cartRepository.findAll(pageable);
        return cartEntityPage.map(CartDto::new);
    }
}
