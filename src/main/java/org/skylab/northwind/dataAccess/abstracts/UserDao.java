package org.skylab.northwind.dataAccess.abstracts;

import org.skylab.northwind.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    User findById(int id);

    User findByUsername(String userName);
}
