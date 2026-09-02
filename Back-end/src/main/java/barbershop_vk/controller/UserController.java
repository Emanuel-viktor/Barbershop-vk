package barbershop_vk.controller;

import barbershop_vk.entity.User;
import barbershop_vk.repository.UserRepository;
import barbershop_vk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user=userService.insert(user);
        return user;
    }
    @DeleteMapping
    public void deleteUser(@RequestBody Long id) {
        userService.delete(id);
    }
}

