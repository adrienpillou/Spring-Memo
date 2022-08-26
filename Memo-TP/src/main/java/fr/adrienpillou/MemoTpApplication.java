package fr.adrienpillou;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.adrienpillou.entities.*;
import fr.adrienpillou.repositories.*;

@SpringBootApplication
public class MemoTpApplication implements CommandLineRunner{
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MemoRepository memoRepository; 
	
	@Autowired
	private EventRepository eventRepository;
	
	private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public static void main(String[] args) {
		SpringApplication.run(MemoTpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Spring server is running...");
		
		User yvette = new User(null, "yvette.lynch@gmail.com", "0000");
		userRepository.save(yvette);
		
		User john= new User(null, "john.doe@gmail.com", "1234");
		userRepository.save(john);
		
		memoRepository.save(new Memo(null, null, "Premier memo", yvette, null, true));
		memoRepository.save(new Memo(null, null, "Deuxieme memo", yvette, null, true));
		memoRepository.save(new Memo(null, null, "Pour tous", john, null, true));
		memoRepository.save(new Memo(null, null, "Salut John", yvette, john, false));
		
		Event e = new Event(null,
							"Match de foot",
							"Paris contre Marseille au vélodrome",
							null,
							dateFormat.parse("26/09/2022"),
							john
		);
		eventRepository.save(e);
		
		e = new Event(null,
					"Match de Basket",
					"Match de NBA",
					null,
					dateFormat.parse("06/09/2022"),
					yvette
		);
		
		eventRepository.save(e);
		
		e = new Event(null,
				"Match de Baseball",
				"Baseball",
				null,
				dateFormat.parse("01/01/2022"),
				yvette
	);
	
	eventRepository.save(e);
	}

}
