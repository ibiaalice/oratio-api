package br.com.oratio.oratio.domain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.oratio.oratio.database.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    User findByEmail(String email);

}

    
