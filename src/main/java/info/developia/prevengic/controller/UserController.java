package info.developia.prevengic.controller;

import info.developia.prevengic.model.User;
import info.developia.prevengic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    ResponseEntity<User> getByEmail(@PathVariable String email) {
        User user = userService.getUserBy(email);

        return ResponseEntity.ok(user);
    }
}
