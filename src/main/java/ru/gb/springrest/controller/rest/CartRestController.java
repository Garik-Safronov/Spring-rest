package ru.gb.springrest.controller.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.springrest.entity.Product;
import ru.gb.springrest.service.CartService;
import ru.gb.springrest.service.ProductService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartRestController {

    private final CartService cartService;
    private final ProductService productService;

    @GetMapping("")
    public Set<Product> getProductListInCart() {
        return cartService.allProductInCart();
    }

    @GetMapping("/cart/{productId}")
    public ResponseEntity<Product> addProductInCartById (@PathVariable("productId") Long id) {
        Product product;
        if (id != null) {
            product = productService.findById(id);
            if (product != null) {
                cartService.addProductInCart(id);
                return new ResponseEntity<>(product, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/cart/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductFromCart (@PathVariable("productId") Long id) {
        cartService.deleteFromCartById(id);
    }
}
