package com.algozenith.HarmonyHub.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerNotFoundException extends Exception {
    private Long id;
    private String message;
    public CustomerNotFoundException(Long id,String message){
        super(message);
        this.id=id;
    }
}
