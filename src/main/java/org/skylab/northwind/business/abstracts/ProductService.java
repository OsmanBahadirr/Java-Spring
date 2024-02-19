package org.skylab.northwind.business.abstracts;

import org.skylab.northwind.entities.concretes.Product;
import org.skylab.northwind.entities.concretes.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    Product getById(int id);
    List<Product> getAll();

    void Add(ProductDto product);
    List<Product> getBySupplierId(int id);
    List<Product> getBySupplierIdAfter(int supplierId);
    Product findByNameAndSupplierId(String productName, int supplierId);
}
