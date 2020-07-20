package com.demo.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.demo.entity.Course;
import com.demo.entity.Student;

public class DemoMain {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("ManyToMany");
		EntityManager em = emf.createEntityManager();
		
		Student student = new Student();
		student.setFirstName("Mahesh");
		student.setEmail("mahesh@gmail.com");
		
		Student student1 = new Student();
		student1.setFirstName("Anirudh");
		student1.setEmail("anirudh@gmail.com");
		
		List<Student> list = new ArrayList();

		list.add(student1);
		
		Course course = new Course();
		course.setCourseName("Spring");
		course.setInstructor("James");
		
		Course course1 = new Course();
		course1.setCourseName("JPA");
		course1.setInstructor("Marry");
		
		List<Course> list1 = new ArrayList();
		list1.add(course1);
		
		course.setStudents(list);

		
		try {
			
			em.getTransaction().begin();
//			
			System.out.println("Saving the Course 1 ");
			em.persist(student1);
			em.persist(course);
			
			System.out.println("Saving the Student 1 ");
			student.setCourses(list1);
			em.persist(course1);
			em.persist(student);
			
			
			// Getting the course object 
//			course = em.find(Course.class, 3);
//			System.out.println(course);
//			list = course.getStudents();
//			for(Student s: list)
//				System.out.println(s);
			
			// Getting the Student object
//			student = em.find(Student.class, 101);
//			list1 = student.getCourses();
//			for(Course c: list1)
//				System.out.println(c);
			
			em.getTransaction().commit();
		}
		catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
			emf.close();
		}

	}

}
