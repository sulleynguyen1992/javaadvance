package kytich.com.model;

public class Customer {
	private String customerId;
	private String name;
	private String phone;
	private String email;
	private GroupCustomer groupCustomer;

	public Customer() {
		super();
	}

	public Customer(String customerId, String name, String phone, String email) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GroupCustomer getGroupCustomer() {
		return groupCustomer;
	}

	public void setGroupCustomer(GroupCustomer groupCustomer) {
		this.groupCustomer = groupCustomer;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}

}
