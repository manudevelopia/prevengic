package info.developia.prevengic.controller;

import info.developia.prevengic.model.User;
import info.developia.prevengic.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{email}")
    ResponseEntity<User> getByEmail(@PathVariable String email){
        User user = userService.getUserBy(email);

        return ResponseEntity.ok(user);
    }
}
