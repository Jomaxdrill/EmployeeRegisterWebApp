package com.employee.dao;

import com.employee.model.Employee;

public class EmployeeImpl implements EmployeeInter {

	@Override
	public int employee_register(Employee person) {
		// TODO Auto-generated method stub
		EmployeeDAO worker= new EmployeeDAO();
		int adding=0;
		try {
			adding = worker.insert_employee(person);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adding;
	}

}
