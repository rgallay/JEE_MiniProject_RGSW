package ch.hevs.shopservice;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Order;
import ch.hevs.businessobject.OrderDetails;
import ch.hevs.businessobject.Product;

@Stateful
public class ShopBean implements Shop {

	@PersistenceContext(name = "ShopPU", type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	@Override
	public List<Order> getOrders() {

		return em.createQuery("FROM Order").getResultList();
	}

	@Override
	public List<Order> getOrdersByCustomer(long idCustomer) {

		return em.createQuery("FROM Order o WHERE o.id = :id").setParameter("id", idCustomer).getResultList();
	}

	@Override
	@TransactionAttribute(value = TransactionAttributeType.REQUIRED)
	public Order addOrder(Customer customer, Address address, Date date, List<Product> products) {

		Order order = new Order();

		order.setCustomer(customer);
		order.setAddress(address);
		order.setDate(date);

		em.persist(order);
		
		for(int i=0;i<products.size();i++) {
			addOrderDetails(order,products.get(i),1);
		}
		return order;
	}

	@Override
	public OrderDetails addOrderDetails(Order order, Product product, int quantity) {
		
		OrderDetails orderDetails = new OrderDetails();

		orderDetails.setOrder(order);
		orderDetails.setProduct(product);
		orderDetails.setQuantity(quantity);
		
		em.persist(orderDetails);
		
		
		return orderDetails;
	}

	@Override
	public List<Customer> getCustomers() {

		return em.createQuery("FROM Customer").getResultList();
	}

	@Override
	public List<Product> getProducts() {

		return em.createQuery("FROM Product").getResultList();
	}

	@Override
	public Customer getCustomer(long idCustomer) {

		return (Customer) em.createQuery("FROM Customer c where c.id=:id").setParameter("id", idCustomer)
				.getSingleResult();

	}
	
	@Override
	public Product getProduct(long idProduct) {

		return (Product) em.createQuery("FROM Product p where p.id=:id").setParameter("id", idProduct)
				.getSingleResult();

	}

	@Override
	public Address createAddress(String postalCode, String street, String city) {

		Address address = new Address();
		address.setCodePostal(postalCode);
		address.setStreet(street);
		address.setCity(city);

		return address;

	}

}
