package fr.adrienpillou.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.adrienpillou.entities.Event;
import fr.adrienpillou.repositories.EventRepository;

@RestController @CrossOrigin("*")
public class EventRest {
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	EventRepository eventRepository;
	
	@PostMapping("/events")
	public Event saveEvent(@RequestBody Event event){
		return eventRepository.save(event);
	}
	
	@GetMapping("/events/after")
	public Iterable<Event> allEventsAfter(){
		Date d = new Date();
		return eventRepository.findByEventDateAfter(d);
	}
	
	@GetMapping("/events/before")
	public Iterable<Event> allEventsBefore(){
		Date d = new Date();
		return eventRepository.findByEventDateBefore(d);
	}
	
	/*@GetMapping("/events/before")
	public Iterable<Event> allEventsBefore(){
		Date d;
		try {
			d = dateFormat.parse(LocalDate.now().toString());
			System.out.println(d);
		}catch(Exception e){
			return null;
		}
		
		return eventRepository.findByStartDateBefore(d);
	}*/
}
