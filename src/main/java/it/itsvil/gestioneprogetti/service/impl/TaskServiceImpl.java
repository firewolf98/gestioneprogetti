package it.itsvil.gestioneprogetti.service.impl;

import it.itsvil.gestioneprogetti.entity.Task;
import it.itsvil.gestioneprogetti.repository.TaskRepository;
import it.itsvil.gestioneprogetti.service.in.TaskService;
import it.itsvil.gestioneprogetti.utils.StatoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addNewTask(Task task) {
        if (task != null)
        {
            Task result = taskRepository.save(task);
            return result;
        }
        return null;
    }

    @Override
    public Task updateTask(String nomeTask, String nuovoNome, StatoTask nuovoStato) {
        if (nomeTask != null) {
            Task task = taskRepository.findByNomeTask(nomeTask);
            if (task != null) {
                task.setNomeTask(nuovoNome);
                task.setStatoTask(nuovoStato);
                Task updatedTask = taskRepository.save(task);
                return updatedTask;
            }
        }
        return null;
    }


    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public List<Task> findByIdProject(Long id) {
        if(id!=null && id>0){
            List<Task> tasks = taskRepository.findByProgettoId(id);
            return tasks.size()>=1 ? tasks : null;
        }
        return null;
    }

    @Override
    public List<Task> findTaskByEmail(String email) {
        if(email != null){
            List<Task> tasks = taskRepository.findByEmail(email);
            return tasks.size()>=1?tasks:null;
        }return null;
    }
}
