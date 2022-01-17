package ru.geekbrains.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("cart")
public class Cart {

    private final Map<Product, Integer> content = new HashMap<>();

    @Autowired
    private ProductRepository repo;

    public void addProduct(long id, int number) {
        repo
                .getProduct(id)
                .ifPresent(product -> content.merge(product, number, Integer::sum));
    }

    public void removeProduct(long id, int number) {
        content
                .keySet()
                .stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .ifPresent(product -> content.merge(product, number, (a, b) -> a - b > 0 ? a - b : null));

    }

    public void show() {
        System.out.println("Cart content");
        System.out.println("ID         Title      Count      Price");
        double sum = 0.0d;
        Product p;
        Integer n;
        for (Map.Entry<Product, Integer> line : content.entrySet()) {
            p = line.getKey();
            n = line.getValue();
            sum += p.getCost() * n;
            System.out.printf("%-10d %-10s %-10d %-10.2f%n",
                    p.getId(),
                    p.getTitle(),
                    n,
                    p.getCost() * n);
        }
        System.out.println("----------------------------------------");
        System.out.printf("Total: %1.2f%n%n", sum);
    }

}
