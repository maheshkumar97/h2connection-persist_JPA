package com.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
	
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("OnetoMany");

		EntityManager manager = factory.createEntityManager();
		
		List<Employee> emp = new ArrayList();
		
		Employee employee = new Employee();
		employee.setFirstName("Mahesh");
		employee.setLastName("Gone");
		
		Employee employee1 = new Employee();
		employee1.setFirstName("Anirud");
		employee1.setLastName("Venkata");
		
		Department dept = new Department();
		dept.setTitle("Healthcare");
		
		employee.setDept(dept);
		employee1.setDept(dept);
		
		emp.add(employee);
		emp.add(employee1);
		
		dept.setEmployee(emp);
		
		try {
			
			
			/*
			 * Department dept1 = manager.find(Department.class, 1L);
			 * System.out.println(dept1);
			 */
			  
			  Employee empp = manager.find(Employee.class, 2L);
			  System.out.println(empp);
			  System.out.println(empp.getDept().getEmployee());
			  //System.out.println(empp.toString());
			 
			
			
			
			/*
			 * manager.getTransaction().begin();
			 * 
			 * manager.persist(dept);
			 * 
			 * manager.getTransaction().commit();
			 */
			 
			 
		}
		catch (Exception e){
			
			e.printStackTrace();
			
		}

	}

}
