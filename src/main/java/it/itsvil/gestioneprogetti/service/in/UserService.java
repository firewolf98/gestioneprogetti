package it.itsvil.gestioneprogetti.service.in;
import it.itsvil.gestioneprogetti.entity.Task;
import it.itsvil.gestioneprogetti.entity.User;
public interface UserService {
    User addUser(User user);
    User login(String email, String password);
    Task addNewTask(String email, String password, Task task);
}
