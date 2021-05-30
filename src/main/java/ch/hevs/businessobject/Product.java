package ch.hevs.businessobject;


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
@Table(name="Produit")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="produit")
	private String product;
	@Column(name="prix")
	private double price;
	
	//relations
	@ManyToOne
	private Category category;
	
	@ManyToMany(mappedBy="products")
	private Set <OrderDetails> orderDetails;

}