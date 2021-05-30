package ch.hevs.businessobject;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Client")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="nom")
	private String name;
	@Column(name="prenom")
	private String firstname;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String password;
	
	//relations
	@OneToMany(mappedBy="customer")
	private Set<Order> orders;
	
	
}