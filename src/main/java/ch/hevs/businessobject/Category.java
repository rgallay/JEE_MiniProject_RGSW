package ch.hevs.businessobject;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Categorie")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="categorie")
	private String category;
	
	
	//relations
	@OneToMany(mappedBy="category" , cascade = CascadeType.ALL)
	private Set<Product> products;
	
	
	//id
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	//category
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	//product
	public Set<Product> getProducts() {
		return products;
	}


	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	//Constructors
	public Category(String category) {
		this.category = category;
	}
	
	public Category() {
	
	}
	
	
	
}
