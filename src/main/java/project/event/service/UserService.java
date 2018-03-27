package project.event.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.event.model.Role;
import project.event.model.User;
import project.event.repository.RoleRepository;
import project.event.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	
	@Autowired
	private UserService(UserRepository userRepository, RoleRepository roleRepository ) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}
	
	public User save (User user) {
		Set<Role> roles = new HashSet<>();
		Role role = roleRepository.findOneByRole("User");
		roles.add(role);
		user.setRoles(roles);
		user.setActive(true);
		return userRepository.save(user);
	}
	
	public boolean isNewUserExists(String email) {
		return userRepository.findOneByEmail(email) != null;
	}
	public void deleteUser(Long id) {
		userRepository.delete(id);
	}
	public User getUserById(Long id) {
		return userRepository.findOne(id);
	}
	public List<User> findAll() {
		List<User> user = userRepository.findAll();
		return user;
	}
}
