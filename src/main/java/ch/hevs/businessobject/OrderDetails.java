package ch.hevs.businessobject;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	@JoinColumn(name = "FK_commande")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "FK_produit")
	private Product product;

	//id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	//quantity
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//order
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	//products
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public OrderDetails() {
	}

	public OrderDetails(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}