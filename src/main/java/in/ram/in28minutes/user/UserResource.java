package in.ram.in28minutes.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    private UserDaoService daoService;

    public UserResource(UserDaoService daoService) {
        this.daoService = daoService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return daoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUsersByid(@PathVariable Integer id) {
        return daoService.findById(id);
    }

}
