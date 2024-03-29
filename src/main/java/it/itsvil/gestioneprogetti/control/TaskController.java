package it.itsvil.gestioneprogetti.control;

import it.itsvil.gestioneprogetti.entity.Project;
import it.itsvil.gestioneprogetti.entity.Task;
import it.itsvil.gestioneprogetti.entity.User;
import it.itsvil.gestioneprogetti.service.impl.TaskServiceImpl;
import it.itsvil.gestioneprogetti.service.in.TaskService;
import it.itsvil.gestioneprogetti.utils.Ruolo;
import it.itsvil.gestioneprogetti.utils.StatoTask;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/taskController")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/add")
    public ResponseEntity<Task> addNewTask(@RequestBody Task task, HttpSession session) {
        UUID uuid = UUID.randomUUID();
        task.setId(Math.abs(uuid.getLeastSignificantBits()));
        Task newTask = taskService.addNewTask(task);
        User user = keepUser(session);
        if (user.getRuolo().equals(Ruolo.PROJECT_MANAGER)) {
            if (newTask != null) {
                return new ResponseEntity<>(newTask, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @PutMapping("/{nomeTask}")
    public ResponseEntity<Task> updateTask(
            @PathVariable String nomeTask,
            @RequestParam String nuovoNome,
            @RequestParam StatoTask newstatoTask) {

        Task updatedTask = taskService.updateTask(nomeTask, nuovoNome, newstatoTask);

        if (updatedTask != null) {
            return new ResponseEntity<>(updatedTask, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/getByProjectId/{idProject}")
    public ResponseEntity<List<Task>> getTaskByProjectId(@PathVariable Long idProject, HttpSession session) {
        if(checkProject(session)){
            List<Task> tasks = taskService.findByIdProject(idProject);
            if(tasks!=null){
                return new ResponseEntity<>(tasks, HttpStatus.OK);
            }
            else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/keepMyTask")
    public ResponseEntity<List<Task>> getMyTasks(HttpSession session){
        User user = keepUser(session);
        if(user!=null && user.getRuolo().equals(Ruolo.DEVELOPER)){
            List<Task> tasks = taskService.findTaskByEmail(user.getEmail());
            return new ResponseEntity<>(tasks,HttpStatus.OK);
        }else
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
    }

    private User keepUser(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    private Boolean checkProject(HttpSession session){
        User user = keepUser(session);
        return user.getRuolo().equals(Ruolo.PROJECT_MANAGER);
    }
}
