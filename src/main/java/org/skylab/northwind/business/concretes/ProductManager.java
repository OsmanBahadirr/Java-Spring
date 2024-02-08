package org.skylab.northwind.business.concretes;

import org.skylab.northwind.business.abstracts.ProductService;
import org.skylab.northwind.dataAccess.abstracts.ProductDao;
import org.skylab.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    @Autowired
    public ProductManager(ProductDao productDao){
        this.productDao = productDao;
    }

    @Override
    public Product getById(int id) {
        var optProduct = productDao.findById(id);
        return optProduct.get();
    }

    @Override
    public List<Product> getAll() {
        return productDao.findAll();
    }

    @Override
    public void Add(Product product) {
        productDao.save(product);
    }

    @Override
    public List<Product> getBySupplierId(int id) {
       return productDao.findBySupplierId(id);
    }

    @Override
    public List<Product> getBySupplierIdAfter(int supplierId) {
       return productDao.findBySupplierIdAfter(supplierId);
    }

    @Override
    public Product findByNameAndSupplierId(String productName, int supplierId) {
       return productDao.findByNameAndSupplierId(productName,supplierId);
    }
}
