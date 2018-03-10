package project.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.event.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
