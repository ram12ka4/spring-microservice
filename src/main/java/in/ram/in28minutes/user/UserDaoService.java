package in.ram.in28minutes.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int count = 0;

    static {
        users.addAll(List.of(
                new User(++count, "Ram", LocalDate.now().minusYears(30)),
                new User(++count, "Krish", LocalDate.now().minusYears(35)),
                new User(++count, "Ricky", LocalDate.now().minusYears(25))));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

     public void deleteById(Integer id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }

    public User save(User user) {
        user.setId(++count);
        users.add(user);
        return user;
    }

}
