package barbershop_vk.resources;

import barbershop_vk.repository.UserRepository;
import barbershop_vk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResources {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
}
