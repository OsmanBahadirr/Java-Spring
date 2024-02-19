package org.skylab.northwind.business.abstracts;

import org.skylab.northwind.entities.concretes.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{

    void addUser(User user);

    void addAdmin(User user);

}
