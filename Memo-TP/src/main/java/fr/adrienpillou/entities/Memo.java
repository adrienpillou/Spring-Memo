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
public class Memo {
	@GeneratedValue @Id
	private Long id;
	@CreationTimestamp @Temporal(TemporalType.DATE) 
	private Date date;
	private String content;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private User toUser;
	
	private Boolean forAll;
	
}
