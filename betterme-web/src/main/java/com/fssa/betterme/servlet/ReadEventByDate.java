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
 * Servlet implementation class ReadEventByDate
 */
@WebServlet("/ReadEventByDate")
public class ReadEventByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadEventByDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		 String dateStr = request.getParameter("date"); 
		 
		  DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	      LocalDate date = LocalDate.parse(dateStr, dateFormatter);
	      
			PrintWriter out = response.getWriter();
			
			try {
			    List<Event> eventList =EventService.getAllEventByDate(date);
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
