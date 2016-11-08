package com.company.controller;

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


/**
 * Servlet implementation class Employee_Servlet
 */
@WebServlet(
		urlPatterns= {"/Company.do" , "/COMPANY/Company.do"}
		)

@MultipartConfig(maxFileSize = 1024 * 1024 * 500)

public class Company_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Company_Servlet() {
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
		// 查詢單筆廠商
		if ("get_one".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			String com_id = request.getParameter("com_id");

			if (com_id == null || (com_id.trim()).length() == 0) {
				errorMsgs.add("請輸入廠商編號");
			}
			
			
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//導回首頁顯示錯誤資訊
			}
			
			ComService comSrv = new ComService();
			ComVO comVO = comSrv.getOne(com_id);
			
			if(comVO==null){
				errorMsgs.add("查無此廠商");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//導回首頁顯示錯誤資訊
			}
			
			List list = new LinkedList<ComVO>();
			list.add(comVO);
			
			request.setAttribute("list", list);
			String url = "/COMPANY/AllCom.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		}
		

//--------------------------------------------------------------------------------------
		//查詢全部廠商
		if ("get_all".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			ComService comSrv = new ComService();
			List list = comSrv.getAll();

			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/COMPANY/AllCom.jsp";
			response.sendRedirect(url);

			// byte[] bytePic = empVO.getPicture();
			// Base64.Decoder decoder = Base64.getDecoder();
			// Base64.Encoder encoder = Base64.getEncoder();
			// String picture = encoder.encodeToString(bytePic);

		}

//--------------------------------------------------------------------------------------
		// 新增廠商資料
		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			String com_name = request.getParameter("com_name");
			String com_um = request.getParameter("com_um");
			String com_phone = request.getParameter("com_phone");
			String com_addr = request.getParameter("com_addr");
			String com_mail = request.getParameter("com_mail");

			Part filePart1 = request.getPart("picture");
			InputStream in = filePart1.getInputStream();
			byte[] picture = new byte[in.available()];
			in.read(picture);
			
			String key_id = request.getParameter("key_id");

			long nowD = new java.util.Date().getTime();
			Date key_date = new Date(nowD);

			ComVO comVO = new ComVO();
			
			comVO.setCom_name(com_name);
			comVO.setCom_um(com_um);
			comVO.setCom_phone(com_phone);
			comVO.setCom_addr(com_addr);
			comVO.setCom_mail(com_mail);
			comVO.setPicture(Base64.getEncoder().encodeToString(picture));
			comVO.setKey_id(key_id);
			comVO.setKey_date(key_date);

			ComService comSrv = new ComService();
			
			try{
			comSrv.insertOne(comVO);
			List list = comSrv.getAll();
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/COMPANY/AllCom.jsp";
			response.sendRedirect(url);
			}catch (RuntimeException e) {
				errorMsgs.add("輸入格式錯誤");
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

//--------------------------------------------------------------------------------------		
		// 依廠商名稱搜尋
		if ("selectByName".equals(action)) {


			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			String com_name = request.getParameter("com_name");

			if (com_name == null ||(com_name.trim()).length() == 0) {
				errorMsgs.add("請輸入廠商名稱");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request
						.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;//導回首頁顯示錯誤資訊
			}
			ComService comSrv = new ComService();
			List list=comSrv.getByName(com_name);

			if (list.isEmpty()) {
				errorMsgs.add("查無此廠商");
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
			String url = "/pos/COMPANY/AllCom.jsp";
			response.sendRedirect(url);
			
//			RequestDispatcher successView = request.getRequestDispatcher(url);
//			successView.forward(request, response);

		}

		
//--------------------------------------------------------------------------------------
		if ("update".equals(action)) {
			
			String com_id = request.getParameter("com_id");
			
			ComService comSrv = new ComService();
			ComVO comVO = comSrv.getOne(com_id);
			request.setAttribute("comVO", comVO);
			
			String url = "/COMPANY/UpdateCom.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

			
		}
		

		if ("updateToDB".equals(action)) {
		
			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);
			
			String com_id = request.getParameter("com_id");
			String com_name = request.getParameter("com_name");
			String com_um = request.getParameter("com_um");
			String com_phone = request.getParameter("com_phone");
			String com_addr = request.getParameter("com_addr");
			String com_mail = request.getParameter("com_mail");

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
			
			long nowD = new java.util.Date().getTime();
			Date key_date = new Date(nowD);

			ComVO comVO = new ComVO();
			
			comVO.setCom_id(com_id);
			comVO.setCom_name(com_name);
			comVO.setCom_um(com_um);
			comVO.setCom_phone(com_phone);
			comVO.setCom_addr(com_addr);
			comVO.setCom_mail(com_mail);
			comVO.setKey_id(key_id);
			comVO.setKey_date(key_date);
			comVO.setPicture(picture);
			comVO.setKey_id(key_id);
			comVO.setKey_date(key_date);
			ComService comSrv = new ComService();
			try{
				comSrv.update(comVO);
						
			List list = comSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/COMPANY/AllCom.jsp";
			response.sendRedirect(url);
			}catch (RuntimeException e) {
				errorMsgs.add("輸入格式錯誤");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request
							.getRequestDispatcher("../Index.jsp");
					failureView.forward(request, response);
					return;//導回首頁顯示錯誤資訊
				
				}
			}
			
		}

		
//--------------------------------------------------------------------------------------
		if ("delete".equals(action)) {
			String com_id = request.getParameter("com_id");
			
			ComService comSrv = new ComService();
			comSrv.delete(com_id);
			
	List list = comSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/COMPANY/AllCom.jsp";
			response.sendRedirect(url);
			
		}

	}

}
