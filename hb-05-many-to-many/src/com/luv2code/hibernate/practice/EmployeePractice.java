package com.luv2code.hibernate.practice;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;
import com.luv2code.hibernate.demo.entity.Student;

public class EmployeePractice {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.employee.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			//create employee object
			Employee employee1 = new Employee("Edgar","Licinskiy","Point");
			Employee employee2 = new Employee("Pavel","Ace","Ofsa");
			Employee employee3 = new Employee("Cligan","Cold","Apple");
			Employee employee4 = new Employee("Rob","Selca","Esas");
			System.out.println("Creating new employee object...");
			
			//start transaction
			session.beginTransaction();
			
			//save the employee object
			session.save(employee1);
			session.save(employee2);
			session.save(employee3);
			session.save(employee4);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Commit DONE!");
			
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// query employees
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
								
			//retrieve employees based on the id: primary key
			System.out.println("\nGetting employee with id: "+ theEmployees.get(1).getId());
			Employee employee = session.get(Employee.class, theEmployees.get(1).getId());
			System.out.println("\n\n\nRetrieved employee is: " + employee);
			
			// Search employee by criteria
			System.out.println("Search employee by criteria");
			theEmployees=session.createQuery("from Employee where company='Esas'").getResultList();

			showEmployees(theEmployees);
			
			// delete employee by id
			System.out.println("Deleting employee id=2");
			session.createQuery("delete from Employee where id>4").executeUpdate();

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void showEmployees(List<Employee> theEmployees) {
		for(Employee tempEmployee : theEmployees) {
			System.out.println("\n\nRetrieved employee is: "+tempEmployee);
		}
	}

}





