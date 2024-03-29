package it.itsvil.gestioneprogetti.service.in;

import it.itsvil.gestioneprogetti.entity.Task;
import it.itsvil.gestioneprogetti.utils.StatoTask;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    Task addNewTask(Task task);

    Task updateTask(String nomeTask, String nuovoNome, StatoTask nuovoStato);

    List<Task> getAllTasks();

    List<Task> findByIdProject(Long id);

    List<Task> findTaskByEmail(String email);


}
