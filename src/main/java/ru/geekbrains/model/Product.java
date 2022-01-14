package ru.geekbrains.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Product {
    private final long id;
    private final String title;
    private final double cost;
}
