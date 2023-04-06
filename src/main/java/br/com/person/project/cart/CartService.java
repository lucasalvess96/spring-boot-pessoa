package br.com.person.project.cart;

import br.com.person.project.cart.Dto.CartDto;
import br.com.person.project.cart.Dto.CreateCartDto;
import br.com.person.project.items.Items;
import br.com.person.project.items.ItemsRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private final CartRepository cartRepository;

    private final ItemsRepository itemsRepository;

    public CartService(CartRepository cartRepository, ItemsRepository itemsRepository) {
        this.cartRepository = cartRepository;
        this.itemsRepository = itemsRepository;
    }

    public CreateCartDto createCartDto (CreateCartDto createCartDto) {
        CartEntity cart = new CartEntity();
        cart.setTotal(createCartDto.getTotal());
        cart.setName(createCartDto.getName());
        cart.setItemsList(createCartDto.getItemsEntity());

        return new CreateCartDto(cartRepository.save(cart));
    }

    public Page<CartDto> cartList(Pageable pageable) {
        Page<CartEntity> cartEntityPage = cartRepository.findAll(pageable);
        Page<Items> entity2Page = itemsRepository.findAll(pageable);
        return cartEntityPage.map(CartDto::new);
    }
}
