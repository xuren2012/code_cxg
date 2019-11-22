package com.cxg.dao.impl;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.cxg.dao.CustomerDao;
import com.cxg.domain.Customer;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {

	@Override
	public Customer findOne(String custId) {
		
		return this.getHibernateTemplate().get(Customer.class, custId);
	}

}
