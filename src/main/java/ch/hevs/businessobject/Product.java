package ch.hevs.businessobject;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@JoinColumn(name = "FK_categorie")
	private Category category;
	
	
	@OneToMany(mappedBy="product")
	private Set <OrderDetails> orderDetails;

	//id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//product
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	//price
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	//category
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	//orderDetails
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	public Product() {
	}

	public Product(String product, double price) {
		this.product = product;
		this.price = price;
	}
	
	

}