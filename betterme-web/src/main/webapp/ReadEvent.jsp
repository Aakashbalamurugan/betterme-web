<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.fssa.betterme.model.Event" %>
<%@page import="com.fssa.betterme.service.EventService" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <title>Event List</title>
</head>
<body>
<h1>Event List</h1>

<c:set var="eventList" value="${requestScope.eventList}" />


<c:choose>
    <c:when test="${not empty eventList}">
              
         <table>
        <thead>
            <tr>
                <th>Event Name</th>
                <th>Event Description</th>
                <th>Event Address</th>
                <th>Date and Time</th>
                <th>Price</th>
                <th>Event Image</th>
                
                <th>Update</th>
            </tr>
        </thead>
        <tbody>
       <c:forEach items="${eventList}" var="event">
                <tr>
                    <td>${event.eventName}</td>
                    <td>${event.eventDescription}</td>
    				<td>${event.eventAddress}</td> 
    				<td>   ${event.getEventDate()}<br> ${event.getEventTime()}</td>       
    				<td>${event.getPrice() }</td>        
    				<td>  <img alt="${event.getEventName()}" src="${event.getImageURL()}" width="100" height="100"></td>
  	            <td>
                        <a href=./EditServlet?id=${event.id}>Update</a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
              </c:when>
 
    <c:otherwise>
        <p>No active events found.</p>
    </c:otherwise>
</c:choose>


</body>
</html>
