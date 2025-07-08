package com.algozenith.HarmonyHub.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long contact_Number;
    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;
}
