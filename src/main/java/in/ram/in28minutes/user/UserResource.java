package in.ram.in28minutes.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.support.HttpComponentsHeadersAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService daoService;

    // public UserResource(UserDaoService daoService) {
    // this.daoService = daoService;
    // }

    @GetMapping("/users")
    public List<User> getUsers() {
        return daoService.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUsersByid(@PathVariable Integer id) {
        User user = daoService.findById(id);

        if (user == null)
            throw new UserNotFoundException("id:" + id);
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = daoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
