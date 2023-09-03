package com.fssa.betterme.servlet;


import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ActionServlet
 */
@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String deleteButton = request.getParameter("deleteButton");
	        String updateButton = request.getParameter("updateButton");
	        PrintWriter out = response.getWriter();
	        
	        
	        if (deleteButton != null) {
	            int  eventId = Integer.parseInt(request.getParameter("event_id"));
	            
	            out.print("delete");
	            out.print(eventId);
	            
	            // Forward to DeleteEventServlet
	            request.getRequestDispatcher("/DeleteEventServlet").forward(request, response);
//	          
	        } else if (updateButton != null) {
	            // Forward to UpdateEventServlet
	            request.getRequestDispatcher("/UpdateEventServlet").forward(request, response);
	            out.print("update");
	        }
	        
	        // Other code...
	    }
}
