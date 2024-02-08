package org.skylab.northwind.dataAccess.abstracts;

import org.skylab.northwind.entities.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    List<Product> findBySupplierId(int supplierId);
    List<Product> findBySupplierIdAfter(int supplierId);
    
    @Query("From Product where name=:productName and supplierId=:supplierId")
    Product findByNameAndSupplierId(String productName, int supplierId);

}
