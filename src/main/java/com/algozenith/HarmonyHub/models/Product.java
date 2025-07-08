package com.algozenith.HarmonyHub.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    @ManyToOne
    private Category category;
    @ManyToOne
    private Supplier supplier;
    private Long stockLevel;
    @OneToMany(mappedBy = "product")
    private List<Transaction> transactions;
}
