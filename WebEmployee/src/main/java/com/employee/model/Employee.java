package com.employee.model;

import java.util.Date;

public class Employee  {
	private String name;
	private String surname;
	private String document_type;
	private String doc_number;
	private Date date_of_birth;
	private Date date_company_work;
	private String position;
	private Double salary;
	private Date time_company;
	private Date age;
	
	public Employee() {
		
	}
	

	public Employee(String name, String surname, String document_type, String doc_number, Date date_of_birth,
			Date date_company_work, String position, Double salary, Date time_company, Date age) {
		super();
		this.name = name;
		this.surname = surname;
		this.document_type = document_type;
		this.doc_number = doc_number;
		this.date_of_birth = date_of_birth;
		this.date_company_work = date_company_work;
		this.position = position;
		this.salary = salary;
		this.time_company = time_company;
		this.age = age;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDoc_number() {
		return doc_number;
	}

	public void setDoc_number(String doc_number) {
		this.doc_number = doc_number;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public Date getDate_company_work() {
		return date_company_work;
	}

	public void setDate_company_work(Date date_company_work) {
		this.date_company_work = date_company_work;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getTime_company() {
		return time_company;
	}

	public void setTime_company(Date time_company) {
		this.time_company = time_company;
	}

	public Date getAge() {
		return age;
	}

	public void setAge(Date age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Employee [name=" + name + ", surname=" + surname + ", document_type=" + document_type + ", doc_number="
				+ doc_number + ", date_of_birth=" + date_of_birth + ", date_company_work=" + date_company_work
				+ ", position=" + position + ", salary=" + salary + ", time_company=" + time_company + ", age=" + age
				+ "]";
	}
	
	

}
