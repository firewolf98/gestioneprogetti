package it.itsvil.gestioneprogetti.entity;
import it.itsvil.gestioneprogetti.utils.StatoTask;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Document(collection = "attivita")
public class Task {
    @Id
    private String id;
    private String nomeTask;
    @DBRef
    private Project progettoId;
    @DBRef
    private List<User> utentiAssegnati;
    private StatoTask statoTask;
    public Task() {
    }
    public Task(String id, String nomeTask, Project progettoId, List<User> utentiAssegnati, StatoTask statoTask) {
        this.id = id;
        this.nomeTask = nomeTask;
        this.progettoId = progettoId;
        this.utentiAssegnati = utentiAssegnati;
        this.statoTask = statoTask;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    public List<User> getUtentiAssegnati() {
        return utentiAssegnati;
    }
    public void setUtentiAssegnati(List<User> utentiAssegnati) {
        this.utentiAssegnati = utentiAssegnati;
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
                ", utentiAssegnati=" + utentiAssegnati +
                ", statoTask=" + statoTask +
                '}';
    }
}
