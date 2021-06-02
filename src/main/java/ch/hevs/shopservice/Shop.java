package ch.hevs.shopservice;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import ch.hevs.businessobject.Address;
import ch.hevs.businessobject.Customer;
import ch.hevs.businessobject.Order;
import ch.hevs.businessobject.OrderDetails;
import ch.hevs.businessobject.Product;

@Local
public interface Shop {

	List<Order> getOrders();

	List<Order> getOrdersByCustomer(long idCustomer);

	Order addOrder(Customer customer, Address address, Date date);

	OrderDetails addOrderDetails(Order order, Product product, int quantity);

	Address addAddress(String postalCode, String street, String city);

	List<Customer> getCustomers();

	List<Product> getProducts();

	Customer getCustomer(long idCustomer);

}
