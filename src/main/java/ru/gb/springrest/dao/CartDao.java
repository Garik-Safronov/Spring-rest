package ru.gb.springrest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.springrest.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Long> {

    Cart save(Cart cart);
}
