package org.skylab.northwind.api.controller;

import org.skylab.northwind.business.abstracts.UserService;
import org.skylab.northwind.core.security.JwtService;
import org.skylab.northwind.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;

    private JwtService jwtService;

    private UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtService jwtService, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.userService = userService;
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestParam String username, @RequestParam String password){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        if(authentication.isAuthenticated()){
            return jwtService.generateToken(username);
        }
        throw new UsernameNotFoundException("kullanıcı adı ve şifre hatalı!");
    }

    @PostMapping("/registerUser")
    public void regsiterUser(@RequestBody User user){
        userService.addUser(user);
    }

    @PostMapping("/registerAdmin")
    public void registerAdmin(@RequestBody User user){
        userService.addAdmin(user);
    }
}
