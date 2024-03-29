package it.itsvil.gestioneprogetti.control;
import it.itsvil.gestioneprogetti.entity.Project;
import it.itsvil.gestioneprogetti.entity.User;
import it.itsvil.gestioneprogetti.service.in.ProjectService;
import it.itsvil.gestioneprogetti.utils.Ruolo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import java.security.PublicKey;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/projectRest")
public class ProjectController {
    @Autowired
    private ProjectService projectService;
    private UUID uuid = UUID.randomUUID();
    @PostMapping("/addProject")
    public ResponseEntity<Project> addNewProject(@RequestParam String nomeProject, HttpSession session){
        User user = keepUser(session);
        if(user.getRuolo().equals(Ruolo.PROJECT_MANAGER)) {
            Project project = new Project();
            project.setEmail(user.getEmail());
            project.setNomeProgetto(nomeProject);
            project.setId(Math.abs(uuid.getLeastSignificantBits()));
            Project saved = projectService.addNewProject(project);
            if (saved != null)
                return new ResponseEntity<>(saved, HttpStatus.OK);
            else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }
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


    private User keepUser(HttpSession session){
        return (User) session.getAttribute("user");
    }
}
