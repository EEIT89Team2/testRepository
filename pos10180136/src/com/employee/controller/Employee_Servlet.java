package com.employee.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.employee.model.EmpService;
import com.employee.model.EmpVO;

import test_controller.TestVO;

/**
 * Servlet implementation class Employee_Servlet
 */
@WebServlet(
		urlPatterns= {"/Employee.do" , "/EMPLOYEE/Employee.do"}
		)

@MultipartConfig(maxFileSize = 1024 * 1024 * 500)

public class Employee_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Employee_Servlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");

		if ("get_one".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			String emp_id = request.getParameter("emp_id");

			if (emp_id == null || (emp_id.trim()).length() == 0) {
				errorMsgs.add("請輸入員工編號");
			}
			
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//導回首頁顯示錯誤資訊
			}
			
			EmpService empSrv = new EmpService();
			EmpVO empVO = empSrv.getOne(emp_id);
			
			if(empVO==null){
				errorMsgs.add("查無此員工");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//導回首頁顯示錯誤資訊
			}
			
			List list = new LinkedList<EmpVO>();
			list.add(empVO);
			
			request.setAttribute("list", list);
			String url = "/EMPLOYEE/AllEmp.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

//			request.setAttribute("empVO", empVO);
//			String url = "/EMPLOYEE/OneEmp.jsp";
//			RequestDispatcher successView = request.getRequestDispatcher(url);
//			successView.forward(request, response);

		}

		if ("get_all".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			EmpService empSrv = new EmpService();
			List list = empSrv.getAll();

			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/EMPLOYEE/AllEmp.jsp";
			response.sendRedirect(url);

			// byte[] bytePic = empVO.getPicture();
			// Base64.Decoder decoder = Base64.getDecoder();
			// Base64.Encoder encoder = Base64.getEncoder();
			// String picture = encoder.encodeToString(bytePic);

		}

		
		if ("insert".equals(action)) {
			
			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			// String emp_id = request.getParameter("emp_id");
			String emp_pwd = request.getParameter("emp_pwd");
			String emp_name = request.getParameter("emp_name");
			String emp_sex = request.getParameter("emp_sex");
			String emp_idnum = request.getParameter("emp_idnum");
			String emp_addr = request.getParameter("emp_addr");
			String emp_mail = request.getParameter("emp_mail");
			String emp_phone = request.getParameter("emp_phone");
			Date emp_bday = Date.valueOf(request.getParameter("emp_bday"));
			Date emp_reg = Date.valueOf(request.getParameter("emp_reg"));
			Date emp_due;
			if (request.getParameter("emp_due").length() == 0) {
				emp_due = null;
			} else {
				emp_due = Date.valueOf(request.getParameter("emp_due"));
			}

			Part filePart1 = request.getPart("picture");
			InputStream in = filePart1.getInputStream();
			byte[] picture = new byte[in.available()];
			in.read(picture);

			String key_id = request.getParameter("key_id");
			long nowD = new java.util.Date().getTime();
			Date key_date = new Date(nowD);

			EmpVO empVO = new EmpVO();

			empVO.setEmp_pwd(emp_pwd);
			empVO.setEmp_name(emp_name);
			empVO.setEmp_sex(emp_sex);
			empVO.setEmp_idnum(emp_idnum);
			empVO.setEmp_addr(emp_addr);
			empVO.setEmp_mail(emp_mail);
			empVO.setEmp_phone(emp_phone);
			empVO.setEmp_bday(emp_bday);
			empVO.setEmp_reg(emp_reg);
			empVO.setEmp_due(emp_due);
			empVO.setPicture(Base64.getEncoder().encodeToString(picture));
			empVO.setKey_id(key_id);
			empVO.setKey_date(key_date);

			EmpService empSrv = new EmpService();
			
			try{
			empSrv.insertOne(empVO);
			List list = empSrv.getAll();
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/EMPLOYEE/AllEmp.jsp";
			response.sendRedirect(url);
			}catch (RuntimeException e) {
				errorMsgs.add("格是錯誤");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("/Index.jsp");
					failureView.forward(request, response);
					return;//導回首頁顯示錯誤資訊
				}
			}
			
			
//			RequestDispatcher successView = request.getRequestDispatcher(url);
//			successView.forward(request, response);

		}
		
		if ("selectByName".equals(action)) {


			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			String emp_name = request.getParameter("emp_name");

			if (emp_name == null ||(emp_name.trim()).length() == 0) {
				errorMsgs.add("請輸入姓名");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//導回首頁顯示錯誤資訊
			}
			EmpService empSrv = new EmpService();
			List list=empSrv.getByName(emp_name);

			if (list.isEmpty()) {
				errorMsgs.add("查無此員工");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//導回首頁顯示錯誤資訊
			}
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/EMPLOYEE/AllEmp.jsp";
			response.sendRedirect(url);
			
//			RequestDispatcher successView = request.getRequestDispatcher(url);
//			successView.forward(request, response);

		}

		if ("update".equals(action)) {
			
			String emp_id = request.getParameter("emp_id");
			
			EmpService empSrv = new EmpService();
			EmpVO empVO = empSrv.getOne(emp_id);
			request.setAttribute("empVO", empVO);
			
			String url = "/EMPLOYEE/UpdateEmp.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

			
		}
		

		if ("updateToDB".equals(action)) {
		
			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			String emp_id = request.getParameter("emp_id");
			String emp_pwd = request.getParameter("emp_pwd");
			String emp_name = request.getParameter("emp_name");
			String emp_sex = request.getParameter("emp_sex");
			String emp_idnum = request.getParameter("emp_idnum");
			String emp_addr = request.getParameter("emp_addr");
			String emp_mail = request.getParameter("emp_mail");
			String emp_phone = request.getParameter("emp_phone");
			Date emp_bday = Date.valueOf(request.getParameter("emp_bday"));
			Date emp_reg = Date.valueOf(request.getParameter("emp_reg"));
			
			Date emp_due;
			if (request.getParameter("emp_due").length() == 0) {
				emp_due = null;
			} else {
				emp_due = Date.valueOf(request.getParameter("emp_due"));
			}

			
			Part filePart1 = request.getPart("newPicture");
			
			String picture;
			if(filePart1.getSize()!=0){
			InputStream in = filePart1.getInputStream();
			byte[] BytePicture = new byte[in.available()];
			in.read(BytePicture);
			picture=Base64.getEncoder().encodeToString(BytePicture);
			
			}else{
			picture=request.getParameter("picture");
			}
			
			String key_id = request.getParameter("key_id");
			String pass_code=request.getParameter("pass_code");
			
			long nowD = new java.util.Date().getTime();
			Date key_date = new Date(nowD);

			EmpVO empVO = new EmpVO();
			
			empVO.setEmp_id(emp_id);
			empVO.setEmp_pwd(emp_pwd);
			empVO.setEmp_name(emp_name);
			empVO.setEmp_sex(emp_sex);
			empVO.setEmp_idnum(emp_idnum);
			empVO.setEmp_addr(emp_addr);
			empVO.setEmp_mail(emp_mail);
			empVO.setEmp_phone(emp_phone);
			empVO.setEmp_bday(emp_bday);
			empVO.setEmp_reg(emp_reg);
			empVO.setEmp_due(emp_due);
			empVO.setPicture(picture);
			empVO.setKey_id(key_id);
			empVO.setKey_date(key_date);
			empVO.setPass_code(pass_code);
			EmpService empSrv = new EmpService();
			try{
			empSrv.update(empVO);
						
			List list = empSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/EMPLOYEE/AllEmp.jsp";
			response.sendRedirect(url);
			}catch (RuntimeException e) {
				errorMsgs.add("格是錯誤");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("../Index.jsp");
					failureView.forward(request, response);
					return;//導回首頁顯示錯誤資訊
				
				}
			}
			
		}
		
		if ("delete".equals(action)) {
			String emp_id = request.getParameter("emp_id");
			
			EmpService empSrv = new EmpService();
			empSrv.delete(emp_id);
			
	List list = empSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/EMPLOYEE/AllEmp.jsp";
			response.sendRedirect(url);
			

			
		}
		if ("setPassCode".equals(action)) {
			String emp_id = request.getParameter("emp_id");
			String pass_code = request.getParameter("pass_code");
			
			EmpService empSrv = new EmpService();
			empSrv.setPassCode(pass_code, emp_id);
			
			List list = empSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/EMPLOYEE/AllEmp.jsp";
			response.sendRedirect(url);
	
		}
		

	}

}
