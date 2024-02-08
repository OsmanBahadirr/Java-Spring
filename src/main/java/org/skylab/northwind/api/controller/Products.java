package org.skylab.northwind.api.controller;

import org.skylab.northwind.business.abstracts.ProductService;
import org.skylab.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class Products {


    private ProductService productService;

    @Autowired
    public Products(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/getbyid")
    public Product getById(@RequestParam int id){
        return productService.getById(id);
    }

    @RequestMapping("/getall")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @RequestMapping("create")
    public void add(@RequestBody Product product){
        productService.Add(product);
    }

    @RequestMapping("/getbySupplierId")
    public List<Product> getBySupplierId(@RequestParam int id){
        return productService.getBySupplierId(id);
    }

    @RequestMapping("/getbySupplierIdAfter")
    public List<Product> getBySupplierIdAfter(@RequestParam int id){
        return productService.getBySupplierIdAfter(id);
    }

    @RequestMapping("/getbyNameAndSupplierIdAfter")
    public Product getBySupplierIdAfter(@RequestParam String productName, int supplierId){
        return productService.findByNameAndSupplierId(productName,supplierId);
    }
}
