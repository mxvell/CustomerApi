package ua.prachyk.usersAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.prachyk.usersAPI.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);

    List<User> findByDateOfBirthBetween(LocalDate fromDate, LocalDate toDate);


}
