package ch.hevs.businessobject;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Commande")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="date")
	private Date date;
	
	//relations
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy="order")
	private Set<OrderDetails> orderDetails;
	
	@Embedded
	private Address address;
}