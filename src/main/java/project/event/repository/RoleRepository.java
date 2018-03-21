package project.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import project.event.model.Role;


public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Role findOneByRole(String role);

}
