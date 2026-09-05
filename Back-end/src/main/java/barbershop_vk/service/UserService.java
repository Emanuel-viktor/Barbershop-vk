package barbershop_vk.service;

import barbershop_vk.entity.User;
import barbershop_vk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User insert(User obj) {
        return userRepository.save(obj);
    }
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User update(Long id, User user) {

        User entity = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setTelephone(user.getTelephone());

        return userRepository.save(entity);
    }

    }
