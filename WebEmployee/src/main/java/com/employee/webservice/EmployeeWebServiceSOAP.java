package com.employee.webservice;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;

public class EmployeeWebServiceSOAP {
	public int Employee_register(Employee employee) {
		int process=0;
		EmployeeDAO employee_new=new EmployeeDAO();
		try {
			process=employee_new.insert_employee(employee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
			process=0;
		}
		
		return process;
	}

}
