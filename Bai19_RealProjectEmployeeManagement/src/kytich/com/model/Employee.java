package kytich.com.model;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private String employeeId;
	private String employeeName;
	private Date  startDay;
	private Date yearBorn;
	private Department department;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeId, String employeeName, Date startDay, Date yearBorn) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.startDay = startDay;
		this.yearBorn = yearBorn;
		
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Date getStartDay() {
		return startDay;
	}
	public void setStartDay(Date startDay) {
		this.startDay = startDay;
	}
	public Date getYearBorn() {
		return yearBorn;
	}
	public void setYearBorn(Date yearBorn) {
		this.yearBorn = yearBorn;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.employeeName;
	}
	
}
