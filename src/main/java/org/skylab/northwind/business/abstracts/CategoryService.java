package org.skylab.northwind.business.abstracts;

import org.skylab.northwind.entities.concretes.Category;

public interface CategoryService {

    void addCategory(Category category);

    Category getById(int id);

}
