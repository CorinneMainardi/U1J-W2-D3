package it.epicode.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Prodotto {
    private long id;
    private String name;
    private String category;
    private double price;
}
