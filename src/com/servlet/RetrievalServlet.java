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



@WebServlet("/userretrieval")
public class RetrievalServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
		
		try {
			 UserDAO dao = new UserDAO();
			 List<UserDTO> lstOfUserDto = dao.retrieveRecords();
			 req.setAttribute("retrieve",lstOfUserDto);
			RequestDispatcher rd =  req.getRequestDispatcher("retrieve.jsp");
			rd.forward(req, resp);                                               
			 
		 }catch (Exception e) {
			 e.printStackTrace();
	}

}
}