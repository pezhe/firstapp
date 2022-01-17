package ru.geekbrains.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("repo")
public class ProductRepository {

    @Value("product.list")
    private String sourceFilePath;

    private final List<Product> productList = new ArrayList<>();

    @PostConstruct
    public void initializeRepo() {
        try {
            Files
                    .readAllLines(Paths.get(sourceFilePath))
                    .stream()
                    .map(this::parseProduct)
                    .forEachOrdered(productList::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Product parseProduct(String line) {
        String[] args = line.split(",");
        return new Product(Integer.parseInt(args[0]), args[1], Double.parseDouble(args[2]));
    }

    public Optional<Product> getProduct(long id) {
        return productList
                .stream()
                .filter(c -> c.getId() == id)
                .findAny();
    }

    public void show() {
        System.out.println(productList);
    }

}