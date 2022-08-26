package fr.adrienpillou.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;

import fr.adrienpillou.entities.Memo;
import fr.adrienpillou.entities.User;

public interface MemoRepository extends CrudRepository<Memo, Long>{
	public Iterable<Memo> findByUserId(Long id) ;
}
