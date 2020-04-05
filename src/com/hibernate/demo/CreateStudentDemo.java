package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session currentSession = factory.getCurrentSession();
		
		try {
			//Create the student object
			Student theStudent = new Student("Keertan", "Maddali", "Keertan@gmail.com");
			
			//start transaction
			currentSession.beginTransaction();
			
			//save the object
			currentSession.save(theStudent);
			
			//commit transaction
			currentSession.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception Occurs in DB connection");
		}finally {
			factory.close();
		}
	}

}









