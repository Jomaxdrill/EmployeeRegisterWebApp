package com.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.dao.EmployeeDAO;
import com.employee.model.Employee;
import com.google.gson.*;


/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/register")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private EmployeeDAO employee_sql= new EmployeeDAO();   
	String message;
	boolean ready=true;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Employee_form.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
		// TODO Auto-generated method stub
		//doGet(request, response);
		try {
			//Get input fields 
			String name=request.getParameter("name");
			String surname=request.getParameter("surname");
			String document_type=request.getParameter("document_type");
			String doc_number=request.getParameter("doc_number");
			String date_of_birth_string=request.getParameter("date_of_birth");
			String date_company_work_string=request.getParameter("date_company_work");
			String position=request.getParameter("position");
			String salary_double=request.getParameter("salary");
			
		
			// Set data results to class 
			Employee new_person=new Employee();
			new_person.setName(name);
			new_person.setSurname(surname);
			new_person.setDocument_type(document_type);
			new_person.setDoc_number(doc_number);
			Date date_of_birth_formatted= date_format.parse(date_of_birth_string);
			new_person.setDate_of_birth(date_of_birth_formatted);
			Date date_company_work_formatted= date_format.parse(date_company_work_string);
			new_person.setDate_company_work(date_company_work_formatted);
			new_person.setPosition(position);
			new_person.setSalary(Double.parseDouble(salary_double));
			//Get current date
			LocalDate today= LocalDate.now();
			//Calculate time at company based on today date.
			
			Calendar calendar_work=Calendar.getInstance();
			calendar_work.setTime(date_company_work_formatted);
			
			
			LocalDate datetime_company= LocalDate.of(calendar_work.get(Calendar.YEAR),
													 calendar_work.get(Calendar.MONTH)+1 , 
													 calendar_work.get(Calendar.DATE));
			Period period_of_work= Period.between(datetime_company, today);
			Calendar calendar_work1=Calendar.getInstance();
			calendar_work1.set(period_of_work.getYears(),period_of_work.getMonths(),period_of_work.getDays());
			new_person.setTime_company(calendar_work1.getTime());
			
			//Calculate age based on today date.
			Calendar calendar_age=Calendar.getInstance();
			calendar_age.setTime(date_of_birth_formatted);
			
			
			LocalDate datetime_age= LocalDate.of(calendar_age.get(Calendar.YEAR),
													 calendar_age.get(Calendar.MONTH)+1 , 
													 calendar_age.get(Calendar.DATE));
			Period period_of_age= Period.between(datetime_age, today);
			Calendar calendar_age1=Calendar.getInstance();
			calendar_age1.set(period_of_age.getYears(),period_of_age.getMonths(),period_of_age.getDays());
			new_person.setAge(calendar_age1.getTime());
			
			// Execute SQL command via this REST Implementation . 
			//SOAP Web Service Implementation's been problematic because of many deprecated technologies. Update in future releases.
		    //Verify the new employee is an adult according to Colombia's laws for insert at table.  
			int adult_age=18;
			if(calendar_age1.get(Calendar.YEAR)>=adult_age) {
				PrintWriter out_answer_correct = response.getWriter();
				GsonBuilder gsonBuilder = new GsonBuilder();
			    gsonBuilder = gsonBuilder.setPrettyPrinting(); 
				Gson gson = gsonBuilder.setDateFormat("yyyy-MM-dd").create();
				out_answer_correct.println(gson.toJson(new_person));
				employee_sql.insert_employee(new_person);
			}else {
				PrintWriter out_problem = response.getWriter();
				out_problem.println("No se pudo registro al empleado por algun campo mal escrito o ser menor de edad ");
				
			}
		
		}catch(Exception e) {
			e.printStackTrace();
			
			
		}
		
		
		
		
		
		}

}
