package ru.geekbrains.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Product {

    private final long id;
    private final String title;
    private final double cost;

}
