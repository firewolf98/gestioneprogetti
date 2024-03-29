package it.itsvil.gestioneprogetti.control;
import it.itsvil.gestioneprogetti.entity.Project;
import it.itsvil.gestioneprogetti.entity.User;
import it.itsvil.gestioneprogetti.service.in.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.security.PublicKey;
@RestController
@RequestMapping("/projectRest")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    @PostMapping("/addProject")
    public ResponseEntity<Project> addUser(@RequestBody Project project){
        Project saved = projectService.addNewProject(project);
        if (saved!=null)
            return new ResponseEntity<>(saved, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @PutMapping("/updateProject")
    public ResponseEntity<Project> updateProject (@RequestParam String nomeProgetto, @RequestParam String newNomeProgetto){
        Project project= projectService.updateProject(nomeProgetto, newNomeProgetto);
        if (project!=null)
            return new ResponseEntity<>(project,HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/deleteProject")
    public void deleteProject (@RequestParam String nomeProgetto){
        projectService.deleteProject(nomeProgetto);
    }

}
