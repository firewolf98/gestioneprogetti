package it.itsvil.gestioneprogetti.entity;
import it.itsvil.gestioneprogetti.utils.StatoTask;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
@Document(collection = "attivita")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeTask;

    private Long progettoId;
    private StatoTask statoTask;
    private String email;



    public Task() {
    }

    public Task(Long id, String nomeTask, StatoTask statoTask, String email) {
        this.id = id;
        this.nomeTask = nomeTask;
        this.statoTask = statoTask;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeTask() {
        return nomeTask;
    }
    public void setNomeTask(String nomeTask) {
        this.nomeTask = nomeTask;
    }

    public Long getProgettoId() {
        return progettoId;
    }

    public void setProgettoId(Long progettoId) {
        this.progettoId = progettoId;
    }

    public StatoTask getStatoTask() {
        return statoTask;
    }
    public void setStatoTask(StatoTask statoTask) {
        this.statoTask = statoTask;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", nomeTask='" + nomeTask + '\'' +
                ", progettoId=" + progettoId +
                ", statoTask=" + statoTask +
                ", email='" + email + '\'' +
                '}';
    }
}
