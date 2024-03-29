package it.itsvil.gestioneprogetti.control;

import it.itsvil.gestioneprogetti.entity.Project;
import it.itsvil.gestioneprogetti.entity.Task;
import it.itsvil.gestioneprogetti.entity.User;
import it.itsvil.gestioneprogetti.service.impl.TaskServiceImpl;
import it.itsvil.gestioneprogetti.service.in.TaskService;
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

    // Aggiungere un nuovo task
    @PostMapping("/add")
    public ResponseEntity<Task> addNewTask(@RequestBody Task task) {
        UUID uuid = UUID.randomUUID();
        task.setId(Math.abs(uuid.getLeastSignificantBits()));  // Impostare l'ID
        Task newTask = taskService.addNewTask(task);
        if (newTask != null) {
            return new ResponseEntity<>(newTask, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Aggiornare un task esistente
    @PutMapping("/{nomeTask}")
    public ResponseEntity<Task> updateTask(
            @PathVariable String nomeTask,
            @RequestParam String nuovoNome,
            @RequestParam StatoTask statoTask,
            @RequestParam StatoTask newstatoTask) {

        Task updatedTask = taskService.updateTask(nomeTask, nuovoNome, statoTask, newstatoTask);

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


}
