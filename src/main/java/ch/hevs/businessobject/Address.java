package ch.hevs.businessobject;

import javax.persistence.Embeddable;

@Embeddable
public class Address{

	private String postalCode;
	private String street;
	private String city;
	
}