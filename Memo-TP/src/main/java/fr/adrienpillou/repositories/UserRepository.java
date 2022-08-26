package fr.adrienpillou.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.adrienpillou.entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	//public List<User> findByLogin(@PathVariable String login);
	
	//@Query(value = "SELECT p FROM User p WHERE p.login = ?1 AND p.password = ?2")
	public Optional<User> findByLoginAndPassword(String login, String password);
}
