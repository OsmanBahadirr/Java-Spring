package org.skylab.northwind.business.concretes;

import org.skylab.northwind.business.abstracts.CategoryService;
import org.skylab.northwind.dataAccess.abstracts.CategoryDao;
import org.skylab.northwind.entities.concretes.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryManager implements CategoryService {

    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public void addCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public Category getById(int id) {
        return categoryDao.findById(id);
    }
}
