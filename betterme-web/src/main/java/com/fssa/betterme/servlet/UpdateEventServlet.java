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
import com.fssa.betterme.model.Event;
import com.fssa.betterme.service.EventService;

/**
 * Servlet implementation class UpdateEventServlet
 */
@WebServlet("/UpdateEventServlet")
public class UpdateEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 PrintWriter out = response.getWriter();
	        int eventId = Integer.parseInt(request.getParameter("event_id"));
	        String eventName = request.getParameter("event_name");
	        String eventDescription = request.getParameter("event_description");
	        String eventAddress = request.getParameter("event_address");
	        String imageUrl = request.getParameter("img_url");
	        String dateStr = request.getParameter("date"); 
	        String timeStr = request.getParameter("time");
	        double price = Double.parseDouble(request.getParameter("price"));
	        boolean isActive = request.getParameter("status") == "true";

	        
	        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	        LocalDate date = LocalDate.parse(dateStr, dateFormatter);
	        
	        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
	        LocalTime time = LocalTime.parse(timeStr, timeFormatter);
	        // Here you would perform the logic to update the event in your data store
	        // For demonstration purposes, let's assume you have an EventService to handle this

	        Event updatedEvent = new Event(eventId, eventName, eventDescription, eventAddress, imageUrl, date, time, price,isActive);
	        try {
				if(EventService.updateEvent(updatedEvent))
					out.print("<h1>Sucess</h1>");
				response.sendRedirect("./ReadEvent");
			} catch ( EventValidationException | ServiceException e) {
				out.print(e.getMessage());
			
			}

	        
	    }

}
