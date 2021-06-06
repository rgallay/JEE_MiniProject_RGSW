package ch.hevs.managedbeans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.event.ValueChangeEvent;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.logging.Logger;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Order;
import ch.hevs.businessobject.Product;
import ch.hevs.shopservice.Shop;

public class OrderBean {

	private Shop shop;
	private List<Customer> customers;

	private List<Product> products;
	private List<Order> ordersByCustomer;
	private Product product;
	private int productSize;
	
	private String street;
	private String city;
	private String postalCode;


	private int[] selectedProductsId;
	private Long customerId;

	private String orderResult;
	
	@PostConstruct
	public void initialize() throws NamingException {

		// use JNDI to inject reference to shop EJB
		InitialContext ctx = new InitialContext();
		shop = (Shop) ctx.lookup("java:global/JEE_MiniProject_RGSW-0.0.1-SNAPSHOT/ShopBean!ch.hevs.shopservice.Shop");

		customers = shop.getCustomers();
	
		products = shop.getProducts();
		productSize = products.size();

	}
	
	public String performOrder () {
		
		try {

			Address address = shop.createAddress(postalCode, street, city);
			Customer customer = shop.getCustomer(customerId);
			List<Product> selectedProducts = new ArrayList<Product>();
			
			for(int i=0;i<selectedProductsId.length;i++) {
				selectedProducts.add(shop.getProduct(selectedProductsId[i]));
			}
			
			shop.addOrder(customer, address, new Date(), selectedProducts);
			this.setOrderResult("Success");
				
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "showOrderResult";
	}
	
	public String showHistory () {
		
		ordersByCustomer = shop.getOrdersByCustomer(customerId);
		
		return "showHistory";
	}

	
	
	public List<Customer> getCustomers() {
		return customers;
	}

	public List<Product> getProducts() {
		return products;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	public int[] getSelectedProductsId() {
		return selectedProductsId;
	}

	public void setSelectedProductsId(int[] selectedProductsId) {
		this.selectedProductsId = selectedProductsId;
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

	public String getOrderResult() {
		return orderResult;
	}

	public void setOrderResult(String orderResult) {
		this.orderResult = orderResult;
	}

	public List<Order> getOrdersByCustomer() {
		return ordersByCustomer;
	}

	public void setOrdersByCustomer(List<Order> ordersByCustomer) {
		this.ordersByCustomer = ordersByCustomer;
	}
	
}
