package it.itsvil.gestioneprogetti.service.impl;

import it.itsvil.gestioneprogetti.entity.Project;
import it.itsvil.gestioneprogetti.repository.ProjectRepository;
import it.itsvil.gestioneprogetti.service.in.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Project addNewProject(Project project) {
        if (project!=null){
            Project result= projectRepository.save(project);
            return result;
        }
        return  null;
    }
    @Override
    public Project updateProject(String nomeProgetto, String string) {
        if (nomeProgetto!=null){
            Project project= projectRepository.findByNomeProgetto(nomeProgetto);
            if (project!=null){
                project.setNomeProgetto(string);
                return project;
            }
        }
        return null;
    }
    @Override
    public void deleteProject(String nomeProgetto) {
        if (nomeProgetto!=null){
            Project project= projectRepository.findByNomeProgetto(nomeProgetto);
            if (project!=null)
                projectRepository.delete(project);
        }
    }
}
