package com.shiftreport.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.Base64;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.company.model.ComService;
import com.company.model.ComVO;
import com.employee.model.EmpService;
import com.employee.model.EmpVO;
import com.shiftreport.model.ShiftreService;
import com.shiftreport.model.ShiftreVO;

import test_controller.TestVO;

/**
 * Servlet implementation class Employee_Servlet
 */
@WebServlet(
		urlPatterns= {"/Shiftre.do" , "/SHIFTREPORT/Shiftre.do"}
		)


public class Shiftreport_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Shiftreport_Servlet() {
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

//--------------------------------------------------------------------------------------
		// �d�߳浧�Z�O���O
		if ("get_one".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			Date date = Date.valueOf(request.getParameter("Date"));
			String shift=request.getParameter("shift");
	
			
			if (date == null) {
				errorMsgs.add("�п�J�Z�O������");
			}
			if (shift == null || (shift.trim()).length() == 0) {
				errorMsgs.add("�п�J�Z�O");
			}
			
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//�{�����_
			}
			
			ShiftreService shiftreSrv = new ShiftreService();
			ShiftreVO shiftreVO = shiftreSrv.getOne(date,shift);

			if(shiftreVO==null){
				errorMsgs.add("�d�L���Z�O����");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//�{�����_
			}
			
			List list = new LinkedList<ShiftreVO>();
			list.add(shiftreVO);
			
			
			request.setAttribute("list", list);
			String url = "/SHIFTREPORT/AllShiftre.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		}
		

//--------------------------------------------------------------------------------------
		// �d�ߥ����t�Ӹ��
		if ("get_all".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			ShiftreService shiftreSrv = new ShiftreService();
			List list = shiftreSrv.getAll();

			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/SHIFTREPORT/AllShiftre.jsp";
			response.sendRedirect(url);

			// byte[] bytePic = empVO.getPicture();
			// Base64.Decoder decoder = Base64.getDecoder();
			// Base64.Encoder encoder = Base64.getEncoder();
			// String picture = encoder.encodeToString(bytePic);

		}

//--------------------------------------------------------------------------------------
		// �s�W�Z�O����
		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			Date date = Date.valueOf(request.getParameter("Date"));
			String shift=request.getParameter("shift");
			String emp_id=request.getParameter("emp_id");
			int cash=Integer.parseInt(request.getParameter("cash"));
			int coupon=Integer.parseInt(request.getParameter("coupon"));
			int discount=Integer.parseInt(request.getParameter("discount"));
			int coins=Integer.parseInt(request.getParameter("coins"));
			int deal_sum=Integer.parseInt(request.getParameter("deal_sum"));
			int deal_cost=Integer.parseInt(request.getParameter("deal_cost"));
			int deal_profit=Integer.parseInt(request.getParameter("deal_profit"));
			int deal_num=Integer.parseInt(request.getParameter("deal_num"));
			int shift_sum=Integer.parseInt(request.getParameter("shift_sum"));


			ShiftreVO shiftreVO = new ShiftreVO();
			
			shiftreVO.setDate(date);
			shiftreVO.setShift(shift);
			shiftreVO.setEmp_id(emp_id);
			shiftreVO.setCash(cash);
			shiftreVO.setCoupon(coupon);
			shiftreVO.setDiscount(discount);
			shiftreVO.setCoins(coins);
			shiftreVO.setDeal_sum(deal_sum);
			shiftreVO.setDeal_cost(deal_cost);
			shiftreVO.setDeal_profit(deal_profit);
			shiftreVO.setDeal_num(deal_num);
			shiftreVO.setShift_sum(shift_sum);
						
			ShiftreService shiftreSrv = new ShiftreService();
			
			try{
			shiftreSrv.insertOne(shiftreVO);
			List list = shiftreSrv.getAll();
			request.getSession().setAttribute("list", list);
			String url = "/pos/SHIFTREPORT/AllShiftre.jsp";
			response.sendRedirect(url);
			}catch (RuntimeException e) {
				errorMsgs.add("��J�榡���~");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("/Index.jsp");
					failureView.forward(request, response);
					return;//�{�����_
				}
			}
//			RequestDispatcher successView = request.getRequestDispatcher(url);
//			successView.forward(request, response);
		}

//--------------------------------------------------------------------------------------		
		// ����d�߳���
		if ("selectByDate".equals(action)) {


			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			Date date = Date.valueOf(request.getParameter("Date"));

			if (date == null ) {
				errorMsgs.add("�п�J���");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//�{�����_
			}
			ShiftreService shiftreSrv = new ShiftreService();
			List list=shiftreSrv.getByDate(date);

			if (list.isEmpty()) {
				errorMsgs.add("�d�L����");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//�{�����_
			}
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/SHIFTREPORT/AllShiftre.jsp";
			response.sendRedirect(url);
			
//			RequestDispatcher successView = request.getRequestDispatcher(url);
//			successView.forward(request, response);

		}

		
//--------------------------------------------------------------------------------------
		if ("update".equals(action)) {
			
			Date date = Date.valueOf(request.getParameter("Date"));
			String shift=request.getParameter("shift");
			
			ShiftreService shiftreSrv = new ShiftreService();
			ShiftreVO shiftreVO = shiftreSrv.getOne(date,shift);
			request.setAttribute("shiftreVO", shiftreVO);
			
			String url = "/SHIFTREPORT/UpdateShiftre.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

			
		}
		

		if ("updateToDB".equals(action)) {
		
			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			Date date = Date.valueOf(request.getParameter("Date"));
			String shift=request.getParameter("shift");
			String emp_id=request.getParameter("emp_id");
			int cash=Integer.parseInt(request.getParameter("cash"));
			int coupon=Integer.parseInt(request.getParameter("coupon"));
			int discount=Integer.parseInt(request.getParameter("discount"));
			int coins=Integer.parseInt(request.getParameter("coins"));
			int deal_sum=Integer.parseInt(request.getParameter("deal_sum"));
			int deal_cost=Integer.parseInt(request.getParameter("deal_cost"));
			int deal_profit=Integer.parseInt(request.getParameter("deal_profit"));
			int deal_num=Integer.parseInt(request.getParameter("deal_num"));
			int shift_sum=Integer.parseInt(request.getParameter("shift_sum"));

			ShiftreVO shiftreVO = new ShiftreVO();
			
			shiftreVO.setDate(date);
			shiftreVO.setShift(shift);
			shiftreVO.setEmp_id(emp_id);
			shiftreVO.setCash(cash);
			shiftreVO.setCoupon(coupon);
			shiftreVO.setDiscount(discount);
			shiftreVO.setCoins(coins);
			shiftreVO.setDeal_sum(deal_sum);
			shiftreVO.setDeal_cost(deal_cost);
			shiftreVO.setDeal_profit(deal_profit);
			shiftreVO.setDeal_num(deal_num);
			shiftreVO.setShift_sum(shift_sum);
						
			ShiftreService shiftreSrv = new ShiftreService();
			try{
				shiftreSrv.update(shiftreVO);
						
			List list = shiftreSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/SHIFTREPORT/AllShiftre.jsp";
			response.sendRedirect(url);
			}catch (RuntimeException e) {
				errorMsgs.add("��J�榡���~");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("../Index.jsp");
					failureView.forward(request, response);
					return;//�{�����_
				
				}
			}
			
		}

		
//--------------------------------------------------------------------------------------
		if ("delete".equals(action)) {
			Date date = Date.valueOf(request.getParameter("Date"));
			String shift=request.getParameter("shift");
			
			ShiftreService shiftreSrv = new ShiftreService();
			shiftreSrv.delete(date,shift);
			
			List list = shiftreSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/SHIFTREPORT/AllShiftre.jsp";
			response.sendRedirect(url);
			
		}

	}

}
