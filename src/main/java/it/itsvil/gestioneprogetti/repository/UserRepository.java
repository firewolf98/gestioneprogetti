package it.itsvil.gestioneprogetti.repository;

import it.itsvil.gestioneprogetti.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findUserByEmail(String email);
}
