package org.skylab.northwind.api.controller;

import org.skylab.northwind.business.abstracts.CategoryService;
import org.skylab.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
    }




}
