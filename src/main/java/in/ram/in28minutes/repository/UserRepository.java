package in.ram.in28minutes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ram.in28minutes.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
