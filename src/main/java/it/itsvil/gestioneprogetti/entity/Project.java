package it.itsvil.gestioneprogetti.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "progetto")
public class Project {

    @Id
    private String idProject;

    private String nomeProgetto;

    public Project() {
    }

    public Project(String idProject, String nomeProgetto) {
        this.idProject = idProject;
        this.nomeProgetto = nomeProgetto;
    }

    public String getIdProject() {
        return idProject;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public String getNomeProgetto() {
        return nomeProgetto;
    }

    public void setNomeProgetto(String nomeProgetto) {
        this.nomeProgetto = nomeProgetto;
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProject='" + idProject + '\'' +
                ", nomeProgetto='" + nomeProgetto + '\'' +
                '}';
    }
}
