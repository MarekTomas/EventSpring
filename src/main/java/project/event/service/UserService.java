package project.event.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.event.model.User;
import project.event.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepository;
	
	@Autowired
	private UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User save (User user) {
		User savedUser = userRepository.save(user);
		System.out.println("savedUser :" + savedUser);
		return savedUser;
	}
	
	public boolean isNewUserExists(String email) {
		return userRepository.findOneByEmail(email) != null;
	}
}
