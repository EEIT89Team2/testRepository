package com.shipments.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.product.model.ProdVO;
import com.shipments.model.ShipService;
import com.shipments.model.ShipVO;
import com.shipments_detail.model.ShipdetailService;
import com.shipments_detail.model.ShipdetailVO;

@WebServlet("/SHIPMENTS/Shipments.do")
public class Shipments_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Shipments_Servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		
		if("insert".equals(action)){
			
			String ord_id=request.getParameter("ord_id");
			Date ship_date=Date.valueOf(request.getParameter("ship_date"));
			String rec_addr=request.getParameter("rec_addr");
			String rec_name=request.getParameter("rec_name");
			String key_id=request.getParameter("key_id");
			String remark=request.getParameter("remark");
			
			
			long nowD = new java.util.Date().getTime();
			Date key_date = new Date(nowD);
			
			System.out.println(ship_date);
			
			ShipVO shipVO=new ShipVO();
			shipVO.setOrd_id(ord_id);
			shipVO.setShip_date(ship_date);
			shipVO.setRec_addr(rec_addr);
			shipVO.setRec_name(rec_name);
			shipVO.setKey_id(key_id);
			shipVO.setKey_date(key_date);
			shipVO.setRemark(remark);
			
			List<ShipdetailVO> list = new LinkedList<ShipdetailVO>();
			Set<ShipdetailVO> set = new LinkedHashSet<ShipdetailVO>();

			Integer i = 1;
			while (true) {

				String x = i.toString();
				try {
					
					ProdVO prodVO = new ProdVO();
					ShipdetailVO shipdetailVO = new ShipdetailVO();
//					shipdetailVO.setShip_id(request.getParameter("ship_id" + x));
//					shipVO1.setShip_id("S2016101800001");
					shipdetailVO.setShipVO(shipVO);
					prodVO.setProd_id(request.getParameter("prod_id" + x));
					shipdetailVO.setProdVO(prodVO);
					shipdetailVO.setProd_name(request.getParameter("prod_name" + x));
					shipdetailVO.setProd_quantity(Integer.parseInt(request.getParameter("prod_quantity" + x)));
					shipdetailVO.setShipVO(shipVO);
//					list.add(shipdetailVO);
					set.add(shipdetailVO);
					i++;
				} catch (Exception e) {
					break;
				}
			}
			
			shipVO.setShipdetails(set);
			ShipService shipSrv =new ShipService();
			shipSrv.insertOne(shipVO, list);
			List<ShipVO> listAll = shipSrv.getAll();
			
			request.getSession().setAttribute("list", listAll);
			request.setAttribute("list", list);
			String url = "AllShip.jsp";
			response.sendRedirect(url);
		}
		
		if("SelectByDate".equals(action)){
			Date dateBegin=Date.valueOf(request.getParameter("dateBegin"));
			Date dateEnd=Date.valueOf(request.getParameter("dateEnd"));
			
			ShipService shipSrv =new ShipService();
		List<ShipVO> list=shipSrv.getByDate(dateBegin, dateEnd);
		request.setAttribute("list", list);
		
		String url="AllShip.jsp";
		RequestDispatcher red = request.getRequestDispatcher(url);
		red.forward(request, response);
		}
		
		if("Detail".equals(action)){
			String ship_id=request.getParameter("ship_id");
			
			ShipdetailService shipdetailSrv=new ShipdetailService();
			List<ShipdetailVO> detailList = shipdetailSrv.getByShipId(ship_id);
			request.setAttribute("detailList", detailList);
			
			ShipService shipSrv =new ShipService();
			ShipVO shipVO = shipSrv.getByShipId(ship_id);
			LinkedList<ShipVO> list = new LinkedList<ShipVO>();
			list.add(shipVO);
			request.setAttribute("list", list);
			
			String url="AllShipdetail.jsp";
			RequestDispatcher red = request.getRequestDispatcher(url);
			red.forward(request, response);
		}
		
		if("getAll".equals(action)){
			ShipService shipSrv =new ShipService();
			List<ShipVO> list = shipSrv.getAll();
			
			request.setAttribute("list", list);
			
			String url="AllShip.jsp";
			RequestDispatcher red = request.getRequestDispatcher(url);
			red.forward(request, response);
			
		}
		
		if("Delete".equals(action)){
			String ship_id=request.getParameter("ship_id");
			ShipService shipSrv =new ShipService();
			shipSrv.delete(ship_id);
			
			List<ShipVO> list = shipSrv.getAll();
			
			request.getSession().setAttribute("list", list);
			String url = "AllShip.jsp";
			response.sendRedirect(url);
		}
		
		if("DeleteDetail".equals(action)){
			String ship_id=request.getParameter("ship_id");
			String prod_id=request.getParameter("prod_id");
			
			ShipdetailService shipdetailSrv=new ShipdetailService();
			shipdetailSrv.delete(ship_id, prod_id);
			List<ShipdetailVO> detailList = shipdetailSrv.getByShipId(ship_id);
			
			ShipService shipSrv =new ShipService();
			ShipVO shipVO = shipSrv.getByShipId(ship_id);
			List<ShipVO> list = new LinkedList<ShipVO>();
			list.add(shipVO);
			
			HttpSession session = request.getSession();
			session.setAttribute("detailList", detailList);
			session.setAttribute("list", list);
			String url = "AllShipdetail.jsp";
			response.sendRedirect(url);
			
		}
		
		if("getByShip_id".equals(action)){
			String ship_id=request.getParameter("ship_id");

			ShipService shipSrv =new ShipService();
			ShipVO shipVO = shipSrv.getByShipId(ship_id);
			List<ShipVO> list = new LinkedList<ShipVO>();
			list.add(shipVO);
			request.setAttribute("list", list);
			
			String url="AllShip.jsp";
			RequestDispatcher red = request.getRequestDispatcher(url);
			red.forward(request, response);
		}
		
		if("getByOrd_id".equals(action)){
			String ord_id=request.getParameter("ord_id");

			ShipService shipSrv =new ShipService();
			List<ShipVO> list= shipSrv.getByOrderId(ord_id);
			request.setAttribute("list", list);
			
			String url="AllShip.jsp";
			RequestDispatcher red = request.getRequestDispatcher(url);
			red.forward(request, response);
		}
		
	}

}
