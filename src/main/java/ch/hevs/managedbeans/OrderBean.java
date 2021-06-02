package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Product;
import ch.hevs.shopservice.Shop;

public class OrderBean {

	private Shop shop;
	private List<Customer> customers;

	private List<Product> products;
	private Product product;
	private int productSize;
	
	private String street;
	private String city;
	private String postalCode;


	private Product[] selectedProducts;
	private Customer customer;

	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to bank EJB
		InitialContext ctx = new InitialContext();
		shop = (Shop) ctx.lookup("java:global/JEE_MiniProject_RGSW-0.0.1-SNAPSHOT/ShopBean!ch.hevs.shopservice.Shop");

		// get customers
		customers = shop.getCustomers();
	
		
		
		products = shop.getProducts();
		productSize = products.size();

	}

	
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Product> getProducts() {
		return products;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(final Customer customer) {
		this.customer = customer;
	}


	public void setSelectedProducts(Product[] selectedProducts) {
		this.selectedProducts = selectedProducts;
	}
	
	public Product[] getSelectedProducts() {
		return selectedProducts;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(final Product product) {
		this.product = product;
	}

	public int getProductSize() {
		return productSize;
	}



	public void setProductSize(int productSize) {
		this.productSize = productSize;
	}



	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getPostalCode() {
		return postalCode;
	}



	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
