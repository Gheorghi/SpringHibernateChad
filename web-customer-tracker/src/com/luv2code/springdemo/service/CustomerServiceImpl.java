package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//need to inject customerDAO
	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return null;
	}


}
