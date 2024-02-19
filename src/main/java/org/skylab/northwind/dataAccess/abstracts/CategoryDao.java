package org.skylab.northwind.dataAccess.abstracts;

import org.skylab.northwind.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {

    Category findById(int id);

}


//Dao: Data Access Object
