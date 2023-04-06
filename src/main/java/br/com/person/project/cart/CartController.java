package br.com.person.project.cart;

import br.com.person.project.cart.Dto.CartDto;
import br.com.person.project.cart.Dto.CreateCartDto;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping
    public ResponseEntity<Page<CartDto>> list(@PageableDefault(direction = Sort.Direction.DESC)Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(cartService.cartList(pageable));
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<CreateCartDto> create(@RequestBody @Valid CreateCartDto createCartDto) {
        CreateCartDto cartDto = cartService.createCartDto(createCartDto);
        if(cartDto != null ) return new ResponseEntity<>(cartDto, HttpStatus.CREATED);
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
