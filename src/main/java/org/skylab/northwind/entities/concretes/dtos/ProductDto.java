package org.skylab.northwind.entities.concretes.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String name;
    private int categoryId;
    private int supplierId;
    private double unitPrice;
    private short unitsInStock;

}
