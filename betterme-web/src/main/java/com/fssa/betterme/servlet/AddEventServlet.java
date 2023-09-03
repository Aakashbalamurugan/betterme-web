package com.fssa.betterme.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fssa.betterme.exception.ServiceException;
import com.fssa.betterme.exception.EventValidationException;
import com.fssa.betterme.model.EventHost;
import com.fssa.betterme.model.Event;
import com.fssa.betterme.service.EventHostService;
import com.fssa.betterme.service.EventService;


@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
//		out.append("Served at: ").append(request.getContextPath());
		
		 String eventName = request.getParameter("event_name");
	        String eventDescription = request.getParameter("event_description");
	        String eventAddress = request.getParameter("event_address");
	        String imgUrl = request.getParameter("img_url");
	        String dateStr = request.getParameter("date"); 
	        String timeStr = request.getParameter("time");
	        double price = Double.parseDouble(request.getParameter("price"));
	       
	        String email = request.getParameter("HostEmail");
	        
	        
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
	        
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	        LocalTime time = LocalTime.parse(timeStr, timeFormatter);
	      
	       
		try {
			EventHost host = EventHostService.readHostByEmail(email);
			Event validEvent = new Event(eventName,eventDescription,eventAddress,imgUrl,date,time,price,host);
			if (EventService.addEvent(validEvent)) {
			response.sendRedirect("./ReadEvent");
			}
		} catch (  EventValidationException | ServiceException e) {
			out.append(e.getMessage());
		}
//		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/event.jsp");
//		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
