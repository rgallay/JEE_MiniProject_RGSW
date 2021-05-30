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
@Table(name="Categorie")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name="categorie")
	private String category;
	
	
	//relations
	@OneToMany(mappedBy="category")
	private Set<Product> products;
	
}
