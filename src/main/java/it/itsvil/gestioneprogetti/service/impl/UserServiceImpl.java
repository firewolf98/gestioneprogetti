package it.itsvil.gestioneprogetti.service.impl;

import it.itsvil.gestioneprogetti.entity.User;
import it.itsvil.gestioneprogetti.repository.UserRepository;
import it.itsvil.gestioneprogetti.service.in.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User retrieveByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
