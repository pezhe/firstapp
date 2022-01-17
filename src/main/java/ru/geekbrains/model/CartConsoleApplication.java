package ru.geekbrains.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartConsoleApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CartApplicationConfig.class);
        Cart cart = context.getBean("cart", Cart.class);
        cart.addProduct(1, 2);
        cart.addProduct(1, 1);
        cart.addProduct(2, 1);
        cart.show();
        cart.removeProduct(1, 1);
        cart.removeProduct(2, 2);
        cart.show();
    }
}
