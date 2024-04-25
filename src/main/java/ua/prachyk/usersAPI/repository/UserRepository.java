package ua.prachyk.usersAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.prachyk.usersAPI.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
