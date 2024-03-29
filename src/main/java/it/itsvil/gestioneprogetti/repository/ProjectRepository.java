package it.itsvil.gestioneprogetti.repository;

import com.mongodb.client.model.Projections;
import it.itsvil.gestioneprogetti.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
    Project findByNomeProgetto(String nomeProgetto);
}
