package ru.gb.springrest.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.springrest.dao.CartDao;
import ru.gb.springrest.dao.ProductDao;
import ru.gb.springrest.entity.Cart;
import ru.gb.springrest.entity.Product;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private final ProductDao productDao;
    private final CartDao cartDao;

    public Product addProductInCart(Long id) {
        Cart cart = cartDao.getById(id);
        Product product = productDao.getById(id);
        cart.addProduct(product);
        cartDao.save(cart);
        return product;
    }

    public Set<Product> allProductInCart() {
        return cartDao.getById(1L).getProducts();
    }

    public void deleteFromCartById(Long id) {
        Cart cart = cartDao.getById(id);
        for (Product p : cart.getProducts()) {
            if (p.getId().equals(id)) {
                cart.deleteProduct(p);
                return;
            }
        }
    }
}
