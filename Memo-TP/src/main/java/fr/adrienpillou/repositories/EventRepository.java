package fr.adrienpillou.repositories;

import java.util.Date;
import java.lang.Iterable;

import org.springframework.data.repository.CrudRepository;

import fr.adrienpillou.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long>{
	public Iterable<Event> findByEventDateAfter(Date d);
	public Iterable<Event> findByEventDateBefore(Date d);
}
