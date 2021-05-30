package ch.hevs.businessobject;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetailCommande")
public class OrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="quantite")
	private int quantity;
	
	//relations
	@ManyToOne
	private Order order;
	
	@ManyToMany
	private Set <Product> products;
}