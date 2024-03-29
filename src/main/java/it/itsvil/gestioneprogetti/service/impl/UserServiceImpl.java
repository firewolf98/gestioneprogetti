package it.itsvil.gestioneprogetti.service.impl;
import it.itsvil.gestioneprogetti.entity.Task;
import it.itsvil.gestioneprogetti.entity.User;
import it.itsvil.gestioneprogetti.repository.TaskRepository;
import it.itsvil.gestioneprogetti.repository.UserRepository;
import it.itsvil.gestioneprogetti.service.in.UserService;
import it.itsvil.gestioneprogetti.utils.Ruolo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TaskRepository taskRepository;
    @Override
    public User addUser(User user) {
        if (user!=null)
            return userRepository.save(user);
        else return null;
    }
    @Override
    public User login(String email, String password) {
        if(email!=null && password!=null) {
            User user= userRepository.findUserByEmail(email);
            if (user!=null && user.getPwd().equals(password))
                return user;
        }
        return null;
    }
    @Override
    public Task addNewTask(String email, String password, Task task) {
        if (email!=null && task!=null && password!=null){
            User u = login(email, password);
            if (u.getRuolo().equals(Ruolo.PROJECT_MANAGER)){
                return taskRepository.save(task);
            }
        }
        return null;
    }
}
