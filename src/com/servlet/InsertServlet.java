package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dto.UserDTO;
import com.userdao.UserDAO;


@WebServlet("/insert")
public class InsertServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String gender = req.getParameter("r");
		String dept = req.getParameter("dept");
		String exp = req.getParameter("exp");
		
		UserDTO dto = new UserDTO();
		dto.setName(name);
		dto.setEmail(email);
		dto.setGender(gender);
		dto.setDept(dept);
		dto.setExp(Double.parseDouble(exp));
		
		UserDAO dao = new UserDAO();
		boolean status = false;
		String response = null;
		try {
		status = dao.saveDetails(dto);
		if(status) {
			response = "User details saved";
		}
		else {
			response = "User details not saved";
		}
	  
	}catch (Exception e) {
		e.printStackTrace();
	}
   PrintWriter writer = resp.getWriter();
   writer.append(response);
   resp.setContentType("text/html");
   RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
   rd.include(req, resp);
}
}
