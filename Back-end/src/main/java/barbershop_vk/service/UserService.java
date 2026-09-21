package barbershop_vk.service;

import barbershop_vk.dto.LoginResponse;
import barbershop_vk.entity.User;
import barbershop_vk.security.JWTService;
import barbershop_vk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insert(User obj) {
        obj.setPassword(passwordEncoder.encode(obj.getPassword()));
        return userRepository.save(obj);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {

        User entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setTelephone(user.getTelephone());

        return userRepository.save(entity);
    }

    public LoginResponse login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("E-mail ou senha inválidos"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("E-mail ou senha inválidos");
        }

        String token = jwtService.generateToken(
                user.getId(),
                "CLIENTE"
        );

        return new LoginResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                token
        );
    }

}
