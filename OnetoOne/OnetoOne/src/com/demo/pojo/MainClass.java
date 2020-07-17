package com.demo.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnetoOne");

		EntityManager manager = factory.createEntityManager();

		// List<Address> addressList = new ArrayList();

		Address address = new Address();
		address.setCity("Hyderabad");
		address.setZipcode(500001);
		address.setPhone(134567890);

		Employee emp = new Employee();
		emp.setFirstName("Mahesh");
		emp.setLastName("Gone");
		emp.setAddress(address);

		address.setEmp(emp);

		try {

			
			
			  Employee em = manager.find(Employee.class, 51);
			  System.out.println(em.toString());
			 
			
			
			
			/*
			 * manager.getTransaction().begin();
			 * 
			 * manager.persist(emp);
			 * 
			 * manager.getTransaction().commit();
			 */
			  
			 
		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

}
