package org.skylab.northwind.business.concretes;

import org.skylab.northwind.business.abstracts.UserService;
import org.skylab.northwind.dataAccess.abstracts.UserDao;
import org.skylab.northwind.entities.concretes.Role;
import org.skylab.northwind.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserManager implements UserDetailsService, UserService {

    private UserDao userDao;

    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserManager(UserDao userDao, BCryptPasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var result = userDao.findByUsername(username);
        if (result == null) {
                throw new UsernameNotFoundException("User not found");
            }
        return result;
    }

    @Override
    public void addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities(Set.of(Role.ROLE_USER));


        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);

        userDao.save(user);
    }

    @Override
    public void addAdmin(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAuthorities(Set.of(Role.ROLE_ADMIN));


        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setEnabled(true);
        user.setCredentialsNonExpired(true);

        userDao.save(user);
    }
}
