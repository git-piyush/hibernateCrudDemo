package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create a session
		Session currentSession = factory.getCurrentSession();
		
		try {
			int theId = 4;
			//start transaction
			currentSession.beginTransaction();
			
			//get the object which need to be deleted
			//Student theStudent = currentSession.get(Student.class, theId);
			
			//delate the Object
			//currentSession.delete(theStudent);
			
			//commit transaction
			//currentSession.getTransaction().commit();
			
			///////////////////////////////////////////////////////////////////////
			//another way of deleting
			currentSession.createQuery("delete from Student s where s.id = 2").executeUpdate();
		
			//commit transaction
			currentSession.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception Occurs in DB connection");
		}finally {
			factory.close();
		}
	}

}









