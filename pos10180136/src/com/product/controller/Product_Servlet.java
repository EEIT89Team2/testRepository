package com.product.controller;

import java.io.IOException;
import java.io.InputStream;
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

import com.product.model.ProdService;
import com.product.model.ProdVO;

/**
 * Servlet implementation class Employee_Servlet
 */
@WebServlet(urlPatterns = { "/Product.do", "/PRODUCT/Product.do" })

@MultipartConfig(maxFileSize = 1024 * 1024 * 500)

public class Product_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Product_Servlet() {
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

		// --------------------------------------------------------------------------------------
		// �d�߳浧�ӫ~���
		if ("get_one".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			String prod_id = request.getParameter("prod_id");

			if (prod_id == null || (prod_id.trim()).length() == 0) {
				errorMsgs.add("�п�J�t�ӽs��");
			}

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;// �{�����_
			}

			ProdService prodSrv = new ProdService();
			ProdVO prodVO = prodSrv.getOne(prod_id);

			if (prodVO == null) {
				errorMsgs.add("�d�L���t��");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;// �{�����_
			}

			List list = new LinkedList<ProdVO>();
			list.add(prodVO);

			request.setAttribute("list", list);
			String url = "/PRODUCT/AllProd.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		}

		// --------------------------------------------------------------------------------------
		// �d�ߥ����ӫ~���
		if ("get_all".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			ProdService prodSrv = new ProdService();
			List list = prodSrv.getAll();

			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/PRODUCT/AllProd.jsp";
			response.sendRedirect(url);

			// byte[] bytePic = empVO.getPicture();
			// Base64.Decoder decoder = Base64.getDecoder();
			// Base64.Encoder encoder = Base64.getEncoder();
			// String picture = encoder.encodeToString(bytePic);

		}

		// --------------------------------------------------------------------------------------
		// �s�W�ӫ~���
		if ("insert".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			String prod_name = request.getParameter("prod_name");
			String com_id = request.getParameter("com_id");
			String prod_group = request.getParameter("prod_group");
			String prod_mkprice = request.getParameter("prod_mkprice");
			String prod_cost = request.getParameter("prod_cost");
			String prod_stock = request.getParameter("prod_stock");
			String prod_q_safty = request.getParameter("prod_q_safty");
			String prod_spec = request.getParameter("prod_spec");

			Part filePart1 = request.getPart("picture");
			InputStream in = filePart1.getInputStream();
			byte[] picture = new byte[in.available()];
			in.read(picture);

			String remark = request.getParameter("remark");
			String status = request.getParameter("status");

			ProdVO prodVO = new ProdVO();

			prodVO.setProd_name(prod_name);
			prodVO.setCom_id(com_id);
			prodVO.setProd_group(prod_group);
			prodVO.setProd_mkprice(Integer.parseInt(prod_mkprice));
			prodVO.setProd_cost(Integer.parseInt(prod_cost));
			prodVO.setProd_stock(Integer.parseInt(prod_stock));
			prodVO.setProd_q_safty(Integer.parseInt(prod_q_safty));
			prodVO.setProd_spec(prod_spec);
			prodVO.setPicture(Base64.getEncoder().encodeToString(picture));
			prodVO.setRemark(remark);
			prodVO.setStatus(status);

			ProdService prodSrv = new ProdService();

			try {
				prodSrv.insertOne(prodVO);
				List list = prodSrv.getAll();
				request.getSession().setAttribute("list", list);
				request.setAttribute("list", list);
				String url = "/pos/PRODUCT/AllProd.jsp";
				response.sendRedirect(url);
			} catch (RuntimeException e) {
				errorMsgs.add("��J�榡���~");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request.getRequestDispatcher("/Index.jsp");
					failureView.forward(request, response);
					return;// �{�����_
				}
			}
			// RequestDispatcher successView =
			// request.getRequestDispatcher(url);
			// successView.forward(request, response);
		}

		// --------------------------------------------------------------------------------------
		// ���u�ӫ~����r�d��
		if ("selectByName".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			String prod_name = request.getParameter("prod_name");

			if (prod_name == null || (prod_name.trim()).length() == 0) {
				errorMsgs.add("�п�J����r");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;// �{�����_
			}
			ProdService prodSrv = new ProdService();
			List list = prodSrv.getByName(prod_name);

			if (list.isEmpty()) {
				errorMsgs.add("�d�L���ӫ~");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;// �{�����_
			}

			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/PRODUCT/AllProd.jsp";
			response.sendRedirect(url);

			// RequestDispatcher successView =
			// request.getRequestDispatcher(url);
			// successView.forward(request, response);

		}

		// --------------------------------------------------------------------------------------
		if ("update".equals(action)) {

			String prod_id = request.getParameter("prod_id");

			ProdService prodSrv = new ProdService();
			ProdVO prodVO = prodSrv.getOne(prod_id);
			request.setAttribute("prodVO", prodVO);

			String url = "/PRODUCT/UpdateProd.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		}

		if ("updateToDB".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			String prod_id = request.getParameter("prod_id");
			String prod_name = request.getParameter("prod_name");
			String com_id = request.getParameter("com_id");
			String prod_group = request.getParameter("prod_group");
			String prod_mkprice = request.getParameter("prod_mkprice");
			String prod_cost = request.getParameter("prod_cost");
			String prod_stock = request.getParameter("prod_stock");
			String prod_q_safty = request.getParameter("prod_q_safty");
			String prod_spec = request.getParameter("prod_spec");

			Part filePart1 = request.getPart("newPicture");
			String picture;
			if (filePart1.getSize() != 0) {
				InputStream in = filePart1.getInputStream();
				byte[] BytePicture = new byte[in.available()];
				in.read(BytePicture);
				picture = Base64.getEncoder().encodeToString(BytePicture);
			} else {
				picture = request.getParameter("picture");
			}

			String remark = request.getParameter("remark");
			String status = request.getParameter("status");

			ProdVO prodVO = new ProdVO();

			prodVO.setProd_id(prod_id);
			;
			prodVO.setProd_name(prod_name);
			prodVO.setCom_id(com_id);
			prodVO.setProd_group(prod_group);
			prodVO.setProd_mkprice(Integer.parseInt(prod_mkprice));
			prodVO.setProd_cost(Integer.parseInt(prod_cost));
			prodVO.setProd_stock(Integer.parseInt(prod_stock));
			prodVO.setProd_q_safty(Integer.parseInt(prod_q_safty));
			prodVO.setProd_spec(prod_spec);
			prodVO.setPicture(picture);
			prodVO.setRemark(remark);
			prodVO.setStatus(status);

			ProdService prodSrv = new ProdService();
			try {
				prodSrv.update(prodVO);

				List list = prodSrv.getAll();

				request.getSession().setAttribute("list", list);
				request.setAttribute("list", list);
				String url = "/pos/PRODUCT/AllProd.jsp";
				response.sendRedirect(url);
			} catch (RuntimeException e) {
				errorMsgs.add("��J�榡���~");
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = request.getRequestDispatcher("../Index.jsp");
					failureView.forward(request, response);
					return;// �{�����_

				}
			}

		}

		// --------------------------------------------------------------------------------------
		//�R��
		
		if ("delete".equals(action)) {
			String prod_id = request.getParameter("prod_id");

			ProdService prodSrv = new ProdService();
			prodSrv.delete(prod_id);

			List list = prodSrv.getAll();

			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/PRODUCT/AllProd.jsp";
			response.sendRedirect(url);

		}

		// --------------------------------------------------------------------------------------
		// �ӫ~��������r�d��
		if ("selectByGroup".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			request.setAttribute("errorMsgs", errorMsgs);

			String prod_group = request.getParameter("prod_group");

			if (prod_group == null || (prod_group.trim()).length() == 0) {
				errorMsgs.add("�п�J����r");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;// �{�����_
			}
			ProdService prodSrv = new ProdService();
			List list = prodSrv.getByGroup(prod_group);

			if (list.isEmpty()) {
				errorMsgs.add("�d�L������");
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = request.getRequestDispatcher("/Index.jsp");
				failureView.forward(request, response);
				return;// �{�����_
			}

			request.getSession().setAttribute("list", list);
			request.setAttribute("list", list);
			String url = "/pos/PRODUCT/AllProd.jsp";
			response.sendRedirect(url);

			// RequestDispatcher successView =
			// request.getRequestDispatcher(url);
			// successView.forward(request, response);

		}

	}

}
