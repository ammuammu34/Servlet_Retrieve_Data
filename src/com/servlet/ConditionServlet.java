package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;
import com.userdao.UserDAO;

@WebServlet("/condition")
public class ConditionServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		         try {
		                    String gender = req.getParameter("r");
		                    String dept = req.getParameter("dept");
		                    String exp = req.getParameter("exp");
		   
		                    UserDTO dto = new UserDTO();
		                    dto.setGender(gender);
		                    dto.setDept(dept);
		                    if(exp != null) {
		                    dto.setExp(Double.parseDouble(exp));
		                    }
		                 
		           
			               UserDAO dao = new UserDAO();
			               List<UserDTO> lstOfUserDto1 = dao.condtionRecords(dto);
			               req.setAttribute("retrieve",lstOfUserDto1);
		                	RequestDispatcher rd =  req.getRequestDispatcher("retrieve.jsp");
			              rd.forward(req, resp);                                               
			 
		 }catch (Exception e) {
			 e.printStackTrace();
	}
	}

}