package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {

		// create a query
		Query theQuery = entityManager.createQuery("from Employee");

		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();

		// return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {

		// get the employee
		Employee theEmployee = entityManager.find(Employee.class, theId);

		// return the employee
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		// save or update the employee
		Employee dbEmployee = entityManager.merge(theEmployee);

		// update with id from db ... so we can get generated id for save/insert
		dbEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {

		// delete object with primary key
		Query theQuery = entityManager
				.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);

		theQuery.executeUpdate();

	}

}
