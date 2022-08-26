package fr.adrienpillou.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
@Entity
public class Event {
	@GeneratedValue @Id
	private Long id;
	private String titre;
	private String description;
	@CreationTimestamp @Temporal(TemporalType.DATE) 
	private Date creationDate;
	@Temporal(TemporalType.DATE) 
	private Date eventDate;
	@ManyToOne
	private User user;
}
