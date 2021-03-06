package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.controller.customer.NoticeController;
import notice.controller.joinus.LoginController;
import notice.controller.joinus.LoginProcController;
import notice.controller.joinus.LogoutProcController;

public class MyDispatcher extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("service신호신호");
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		System.out.println("uri : "+uri);
		System.out.println("conPath : "+conPath);
		System.out.println("com : "+com);
		
		Controller controller=null;	
		try {
			if(com.equals("/customer/notice.do")) {
				controller=new NoticeController();
			}else if(com.equals("/login/login.do")) {
				controller=new LoginController();
			}else if(com.equals("/login/loginProc.do")) {
				controller=new LoginProcController();
			}else if(com.equals("/login/logoutProc.do")) {
				controller=new LogoutProcController();
			}
			
			
			controller.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	@Override
	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		service(request, response);		
	}
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) 
			throws ServletException, IOException {
		service(request, response);		
	}
	

}
