package it.itsvil.gestioneprogetti.control;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.itsvil.gestioneprogetti.entity.Task;
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
        if (saved!=null)
            return new ResponseEntity<>(saved, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PostMapping("/loginUser")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String pass){
        User saved = userService.login(email,pass);
        if (saved!=null)
            return new ResponseEntity<>(saved, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PostMapping("/addNewTask")
    public ResponseEntity<Task> addNewTask (@RequestParam String email ,@RequestParam String password ,@RequestParam Task task ){
        Task taskSaved = userService.addNewTask(email, password,task);
        if (taskSaved!=null)
            return new ResponseEntity<>(taskSaved, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
