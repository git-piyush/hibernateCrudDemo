package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//Create Session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//get current session from factory
		Session currentSession = factory.getCurrentSession();
		
		try {
			//create 3 student object
			Student theStudent1 = new Student("Kripal", "Jha", "Kripal@gmail.com");
			Student theStudent2 = new Student("Ashok", "Tudu", "Ashok@gmail.com");
			Student theStudent3 = new Student("Mukesh", "Mandal", "Mukesh@gmail.com");
			
			//start the transaction
			currentSession.beginTransaction();
			
			//save the object
			currentSession.save(theStudent1);
			currentSession.save(theStudent2);
			currentSession.save(theStudent3);
			
			//commit the transaction
			currentSession.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Some Exception generated during saving");
		}finally {
			currentSession.close();
		}
		
	}

}
