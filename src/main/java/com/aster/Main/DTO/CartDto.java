package com.aster.Main.DTO;

import com.aster.Main.Entity.Cart;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDto {
    private int grandTotal;
    private int id;
}
