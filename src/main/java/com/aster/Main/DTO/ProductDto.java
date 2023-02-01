package com.aster.Main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private int id;
    private int quantity;
    private String imageUrl;
    private double price;
    private boolean status;

    public boolean getStatus() {
        return status;
    }
}
