package it.itsvil.gestioneprogetti.service.in;

import it.itsvil.gestioneprogetti.entity.User;

public interface UserService {

    User addUser(User user);

    User retrieveByEmail(String email);
}
