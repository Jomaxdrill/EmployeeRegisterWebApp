package com.employee.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.employee.model.Employee;

public class EmployeeDAO {
	
public EmployeeDAO() {
		
	}
	public int insert_employee(Employee employee) throws ClassNotFoundException {
		String INSERT_SQL_LINE="INSERT INTO employeedb.employee"+
				" (fname,surname,doc_type,doc_number,date_of_birth,date_company_work,position,salary,time_company,age) VALUES"+
				"(?,?,?,?,?,?,?,?,?,?)" ;
		Class.forName("com.mysql.jdbc.Driver");
		   int result=0;
		try (Connection connection = 
				   DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "mysql2021");
		            

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL_LINE)) {
			            preparedStatement.setString(1, employee.getName());
			            preparedStatement.setString(2, employee.getSurname());
			            preparedStatement.setString(3, employee.getDocument_type());
			            preparedStatement.setString(4, employee.getDoc_number());
			            java.sql.Date DoB= new java.sql.Date(employee.getDate_of_birth().getTime());
			            preparedStatement.setDate(5, DoB);
			            java.sql.Date Dcw= new java.sql.Date(employee.getDate_company_work().getTime());
			            preparedStatement.setDate(6, Dcw);
			            preparedStatement.setString(7, employee.getPosition());
			            preparedStatement.setDouble(8, employee.getSalary());
			            java.sql.Date TC= new java.sql.Date(employee.getTime_company().getTime());
			            preparedStatement.setDate(9, TC);
			            java.sql.Date age_person= new java.sql.Date(employee.getAge().getTime());
			            preparedStatement.setDate(10,age_person );
			        System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            System.out.println(e);
	            
	        }
	        return result;
			   
		   }

}
