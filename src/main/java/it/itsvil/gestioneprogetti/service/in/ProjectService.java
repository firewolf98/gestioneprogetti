package it.itsvil.gestioneprogetti.service.in;

import it.itsvil.gestioneprogetti.entity.Project;
public interface ProjectService {
    Project addNewProject(Project project);
    Project updateProject (String nomeProgetto,String s);
    void deleteProject (String nomeProgetto);
}
