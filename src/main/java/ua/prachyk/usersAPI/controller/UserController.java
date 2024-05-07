package ua.prachyk.usersAPI.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.prachyk.usersAPI.model.User;
import ua.prachyk.usersAPI.service.UserService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> registerUser(@RequestBody User user) {
        userService.registerUser(user.getFirstName(), user.getLastName(), user.getEmail(),
                user.getDateOfBirth(), user.getAddress(), user.getPhone());
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateUser(@RequestBody User updateUser) {
        userService.updateUser(updateUser);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Void> updateEmail(@RequestBody User emailUser) {
        userService.findById(emailUser.getId());
        userService.updateEmail(emailUser);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/fields")
    public ResponseEntity<Void> updateUserFields(@RequestBody User userUpdated) {
        userService.findById(userUpdated.getId());
        userService.updateFields(userUpdated);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/data-range")
    public ResponseEntity<List<User>> findUsersByDateOfBirthBetween(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
                                                                    @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        List<User> users = userService.findUsersByDateOfBirthBetween(from, to);
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}









