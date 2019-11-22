package com.cxg.dao;

import com.cxg.domain.Customer;

public interface CustomerDao {

	Customer findOne(String custId);

}
