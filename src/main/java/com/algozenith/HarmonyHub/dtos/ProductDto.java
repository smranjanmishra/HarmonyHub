package com.algozenith.HarmonyHub.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {
    private String name;
    private String description;
    private Double price;
    private String category;
    private String supplier;
    private Long stockLevel;
}
