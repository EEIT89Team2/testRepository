package test_controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.employee.model.EmpService;
import com.employee.model.EmpVO;


@WebServlet("/test/AEmployee.do")
@MultipartConfig(maxFileSize=1024*1024*500)
public class test_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public test_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("action");
		byte[] picture=null;
		HttpSession session = request.getSession();
		
		if ("test".equals(action)) {
//			EmpVO empVO = new EmpService().getOne("E00006");
//			String img = empVO.getPicture();
			Part filePart1 = request.getPart("picture");
			InputStream in = filePart1.getInputStream();
			picture = new byte[in.available()];
			in.read(picture);
			
			session.setAttribute("picture", picture);
//			testVO.setImg(picture);
			
			String url = "test.jsp";
			RequestDispatcher successView = request.getRequestDispatcher(url);
			successView.forward(request, response);

		}

		if ("photo".equals(action)) {
//			TestVO testVO=new TestVO();
//
//		File f = new File("C:\\Users\\Public\\Pictures\\Sample Pictures\\1001.png");
//		FileInputStream fis = new FileInputStream(f);
//		byte[] data = new byte[fis.available()];
//		fis.read(data);
//		testVO.setImg(data);
//		System.out.println(testVO.getImg());
			picture=(byte[]) session.getAttribute("picture");
		ServletOutputStream sos = response.getOutputStream();
		response.setContentType("image/gif");
		sos.write(picture);
		}
	}

	
	

}
