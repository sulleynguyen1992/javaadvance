package kytich.com.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String departmentId;
	private String departmentName;
	Vector<Employee> listEmployee;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
		this.listEmployee = new Vector<Employee>();
	}
	
	
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public Vector<Employee> getListEmployee() {
		return listEmployee;
	}
	public void setListEmployee(Vector<Employee> listEmployee) {
		this.listEmployee = listEmployee;
	}
	
	//insert employee function
	public void addEmployee(Employee emp) {
		this.listEmployee.add(emp);
		emp.setDepartment(this);
	}


	@Override
	public String toString() {
		return this.departmentName;
	}
	 
}
