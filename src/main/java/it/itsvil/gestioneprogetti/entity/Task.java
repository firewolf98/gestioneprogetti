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
    @DBRef
    private Project progettoId;
    private StatoTask statoTask;
    public Task() {
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
    public Project getProgettoId() {
        return progettoId;
    }
    public void setProgettoId(Project progettoId) {
        this.progettoId = progettoId;
    }

    public StatoTask getStatoTask() {
        return statoTask;
    }
    public void setStatoTask(StatoTask statoTask) {
        this.statoTask = statoTask;
    }
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", nomeTask='" + nomeTask + '\'' +
                ", progettoId=" + progettoId +
                ", statoTask=" + statoTask +
                '}';
    }
}
