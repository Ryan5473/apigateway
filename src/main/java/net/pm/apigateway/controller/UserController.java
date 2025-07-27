package net.pm.apigateway.controller;
import net.pm.apigateway.model.Users;
import net.pm.apigateway.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public Users register(@RequestBody Users user) {
        return service.register(user);

    }

    @PostMapping("/login")
    public String login(@RequestBody Users user) {

        return service.verify(user);
    }
    @PostMapping("/others")
    public List<Users> getAllOtherUsers(@RequestBody Map<String, Integer> body) {
        Integer id = body.get("id");
        return service.getAllExcept(id);
    }
}