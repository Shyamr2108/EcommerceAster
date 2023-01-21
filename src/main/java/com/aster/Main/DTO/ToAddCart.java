package com.aster.Main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToAddCart {
    private int sku;
    private int quantity;
    private int id;
}
