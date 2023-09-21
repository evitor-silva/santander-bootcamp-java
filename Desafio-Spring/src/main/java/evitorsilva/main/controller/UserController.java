package evitorsilva.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import evitorsilva.main.model.TokenObject;
import evitorsilva.main.model.User;
import evitorsilva.main.service.UserImpl;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserImpl service;

    @PostMapping("/login")
    public TokenObject loginUser(@RequestBody User FazerLogin) {
        return service.LoginUser(FazerLogin);
    }

    @PostMapping("/add")
    public void postUser(@RequestBody User user) {
        service.createUser(user);
    }
}
