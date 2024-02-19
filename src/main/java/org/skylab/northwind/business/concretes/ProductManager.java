package org.skylab.northwind.business.concretes;

import org.skylab.northwind.business.abstracts.CategoryService;
import org.skylab.northwind.business.abstracts.ProductService;
import org.skylab.northwind.dataAccess.abstracts.ProductDao;
import org.skylab.northwind.entities.concretes.Product;
import org.skylab.northwind.entities.concretes.dtos.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductManager implements ProductService {

    private ProductDao productDao;

    private CategoryService categoryService;

    @Autowired
    public ProductManager(ProductDao productDao, CategoryService categoryService){
        this.productDao = productDao;
        this.categoryService = categoryService;
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
    public void Add(ProductDto productDto) {

        Product product = new Product().builder()
                .name(productDto.getName())
                .supplierId(productDto.getSupplierId())
                .unitPrice(productDto.getUnitPrice())
                .unitsInStock(productDto.getUnitsInStock())
                .category(categoryService.getById(productDto.getCategoryId())).build();

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
