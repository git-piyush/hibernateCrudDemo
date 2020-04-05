package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//get current session from factory
		Session currentSession = factory.getCurrentSession();
		
		try {
			int theId = 2;
			
			//start transaction
			currentSession.beginTransaction();
			
			//get the object which need modification
			//Student theStudent = currentSession.get(Student.class, theId);
			
			//set the new value using setter
//			theStudent.setFirstName("Piyush");
//			theStudent.setLastName("Kumar");
//			theStudent.setEmail("Piyush@gmail.com");
//			
//			//commit transaction
//			currentSession.getTransaction().commit();
//			System.out.println("Object Updated sucessfully");
			
			//Update email address as Chitra@gmail.com for all students
			currentSession.createQuery("update Student set email='Chitra@gmail.com'").executeUpdate();
			
			//commit transaction
			currentSession.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Exception occurs");
		}finally {
			currentSession.close();
		}

	}

}
