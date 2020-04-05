package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemoBasedOnPrimary {

	public static void main(String[] args) {
		
		//Create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//get the current session from session factory
		Session currentSession = factory.getCurrentSession();
		
		try {
			//Create the Student Object
			Student theStudent = new Student("Deepak", "Kumar", "Deepak@gmail.com");
			
			//Start session transaction
			currentSession.beginTransaction();
			
			//Save the student object
			int theId = (int) currentSession.save(theStudent);
			
			//write code to fetch the data from db using primary key
			Student myStudent = currentSession.get(Student.class, theId);
			System.out.println(myStudent);
			
			//commit transaction
			currentSession.getTransaction().commit();
			
		} catch (Exception e) {
			System.out.println("Exception Occurs");
		}finally {
			
		}

	}

}
