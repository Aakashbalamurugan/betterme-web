package com.fssa.betterme.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.betterme.exception.ServiceException;
import com.fssa.betterme.model.Event;
import com.fssa.betterme.service.EventService;

/**
 * Servlet implementation class ReadEventBetweenDate
 */
@WebServlet("/ReadEventBetweenDate")
public class ReadEventBetweenDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadEventBetweenDate() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String fromdateStr = request.getParameter("from"); 
		 String enddateStr = request.getParameter("to"); 
		 
		  DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      LocalDate start = LocalDate.parse(fromdateStr, dateFormatter);
	      LocalDate end = LocalDate.parse(enddateStr, dateFormatter);
	      
			PrintWriter out = response.getWriter();
			
			try {
			    List<Event> eventList =EventService.getAllEventByRange(start, end);
			    request.setAttribute("eventList", eventList);  
			    RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ReadEvent.jsp");
			    dispatcher.forward(request, response);
			} catch ( ServiceException e) {
				out.append(e.getMessage());
			  
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
