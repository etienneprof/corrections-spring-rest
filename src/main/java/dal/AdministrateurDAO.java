package dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bo.Administrateur;

@Repository
public interface AdministrateurDAO extends JpaRepository<Administrateur, Integer> {

}
