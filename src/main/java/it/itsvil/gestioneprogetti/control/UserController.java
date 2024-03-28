package it.itsvil.gestioneprogetti.control;

import io.swagger.v3.oas.annotations.tags.Tag;
import it.itsvil.gestioneprogetti.entity.User;
import it.itsvil.gestioneprogetti.service.in.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Tag(name = "User Controller", description = "Operazioni su user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){

        User saved = userService.addUser(user);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    @PostMapping("/find")
    public ResponseEntity<User> addUser(@RequestParam String user){

        User saved = userService.retrieveByEmail(user);
        return new ResponseEntity<>(saved, HttpStatus.OK);
    }


}
