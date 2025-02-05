package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {		
			// start a transaction
			session.beginTransaction();
			
			//get the Instructor from DB
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);

			System.out.println("luv2code: Instructor: " + tempInstructor);
			
			//option 1: call getter method while session is open
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			
			//close the session
			session.close();
			
			System.out.println("\nluv2code: The session is closed now\n");
			
			//get courses for the instructor
			System.out.println("luv2code: Courses: "+tempInstructor.getCourses());
			
			System.out.println("luv2code: Done!");
		}
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
	}

}
