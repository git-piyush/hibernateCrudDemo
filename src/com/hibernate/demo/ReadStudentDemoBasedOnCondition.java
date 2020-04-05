package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Student;

public class ReadStudentDemoBasedOnCondition {

	public static void main(String[] args) {
		//Create a sessionfactory
		SessionFactory factory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
		
		//get the Current session
		Session currentSession = factory.getCurrentSession();
		
		try {
			//Begin transaction
			currentSession.beginTransaction();
			
			//query to retrive all student from database
			List<Student> Students = currentSession.createQuery("from Student").list();
			
			//display student
			System.out.println("Below is the list of all student in Student table");
			displayStudent(Students);	
			
			//query student where lastname is "Tudu"
			Students = currentSession.createQuery("from Student s where s.lastName='Tudu'").list();
			
			//display students
			displayStudent(Students);
			
			
			//query student where lastName is "Tudu" or firstName is "Alok"
			Students = currentSession.createQuery("from Student s where s.firstName='Alok' or s.lastName='Tudu'").getResultList();
			
			//display students list
			displayStudent(Students);
			
			//query students where firstName ends with "sh"
			Students = currentSession.createQuery("from Student s where s.firstName Like '%sh'").getResultList();
			displayStudent(Students);
			
		} catch (Exception e) {
			System.out.println("Exception");
		}finally {
			currentSession.close();
		}

	}

	private static void displayStudent(List<Student> Students) {
		for(Student theStudent : Students) {
			System.out.println(theStudent);
		}
	}

}
