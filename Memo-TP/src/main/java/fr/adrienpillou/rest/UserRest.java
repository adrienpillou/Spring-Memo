package fr.adrienpillou.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.adrienpillou.entities.User;
import fr.adrienpillou.repositories.UserRepository;

@RestController @CrossOrigin("*")
public class UserRest {
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("login")
	public Optional<User> findByLoginAndPassword(@RequestBody User u) {
		return userRepository.findByLoginAndPassword(u.getLogin(), u.getPassword());
	}
	
}
