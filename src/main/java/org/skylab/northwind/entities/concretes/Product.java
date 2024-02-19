package org.skylab.northwind.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "supplier_id")
    private int supplierId;


    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;


    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "quantity_per_unit")
    private String quantityPerUnit;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    /*
    @Column(name = "units_on_order")
    private int unitsOnOrder;

    @Column(name = "reorder_level")
    private int reorderLevel;

    @Column(name = "discontinued")
    private int discontinued;

     */


}
