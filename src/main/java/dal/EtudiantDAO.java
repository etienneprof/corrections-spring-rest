package dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.Etudiant;

@Repository
public interface EtudiantDAO extends JpaRepository<Etudiant, Integer> {

}
