package com.algozenith.HarmonyHub.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TransactionDto {
    private Long id;
    private Long productId;
    private Long customerId;
    private Long quantitiesSold;
    private LocalDateTime saleDateTime;
    private Double totalPrice;
}
