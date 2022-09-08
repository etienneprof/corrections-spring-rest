package dal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleDAO extends JpaRepository<bo.Module, Integer> {

}
