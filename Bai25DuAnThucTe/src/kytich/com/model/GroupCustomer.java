package kytich.com.model;

import java.util.Vector;

public class GroupCustomer {
	private String groupCusId;
	private String groupCusName;
	private Vector<Customer> customers;
	
	public GroupCustomer() {
		super();	
		this.customers = new Vector<Customer>();
	}
	public GroupCustomer(String groupCusId, String groupCusName) {
		super();
		this.groupCusId = groupCusId;
		this.groupCusName = groupCusName;
		this.customers = new Vector<Customer>();
	}
	public String getGroupCusId() {
		return groupCusId;
	}
	public void setGroupCusId(String groupCusId) {
		this.groupCusId = groupCusId;
	}
	public String getGroupCusName() {
		return groupCusName;
	}
	public void setGroupCusName(String groupCusName) {
		this.groupCusName = groupCusName;
	}
	public Vector<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(Vector<Customer> customers) {
		this.customers = customers;
	}
	
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
		customer.setGroupCustomer(this);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.groupCusName;
	}
	
}
