package com.algozenith.HarmonyHub.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Product product;
    @ManyToOne
    private Customer customer;
    private Long quantitiesSold;
    private LocalDateTime saleDateTime;
    private Double totalPrice;
}
