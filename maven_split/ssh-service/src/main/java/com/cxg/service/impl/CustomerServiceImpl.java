package com.cxg.service.impl;

import com.cxg.dao.CustomerDao;
import com.cxg.domain.Customer;
import com.cxg.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao customerDao;

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public Customer findOne(String custId) {
		
		return customerDao.findOne(custId);
	}
	

}
