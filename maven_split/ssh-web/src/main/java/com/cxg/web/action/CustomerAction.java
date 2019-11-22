package com.cxg.web.action;

import com.cxg.domain.Customer;
import com.cxg.service.CustomerService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerAction extends ActionSupport {

	// 注入依赖
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	private String custId;
	
	public void setCustId(String custId) {
		this.custId = custId;
	}

	//查询
	public String findOne() throws Exception{
		Customer customer = customerService.findOne(custId);
		ActionContext.getContext().getValueStack().push(customer);
		return SUCCESS;
	}

}
