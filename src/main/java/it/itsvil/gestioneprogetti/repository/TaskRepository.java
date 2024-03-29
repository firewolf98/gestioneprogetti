package it.itsvil.gestioneprogetti.repository;

import it.itsvil.gestioneprogetti.entity.Task;
import it.itsvil.gestioneprogetti.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task,String> {

    List<Task> findByEmail(String email);
    Task findByNomeTask(String nomeTask);

    List<Task> findByProgettoId(Long id);

}
