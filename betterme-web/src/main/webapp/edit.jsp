<%@ page import = "com.fssa.betterme.model.Event" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Event</title>
    
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Update Event</h1>
        
        <%
        Event event = (Event) request.getAttribute("event");
        %>

        <form action="ActionServlet" method="post">
            <input type="text" name="event_id" value="<%=event.getId()%>"
                    hidden>
            <div class="form-group">
                <label for="event_name">Event Name:</label>
                <h5><%=event.getEventName()%> </h5>
                <input type="text" class="form-control" id="event_name" name="event_name"
                       value="<%=event.getEventName()%>" hidden required>
            </div>

            <div class="form-group">
                <label for="event_description">Event Description:</label>
                <input type="text" class="form-control" id="event_description" name="event_description"
                       value="<%=event.getEventDescription()%>" required>
            </div>

            <div class="form-group">
                <label for="event_address">Event Address:</label>
                <input type="text" class="form-control" id="event_address" name="event_address"
                       value="<%=event.getEventAddress()%>" required>
            </div>

            <div class="form-group">
                <label for="img_url">Image URL:</label>
                <input type="url" class="form-control" id="img_url" name="img_url"
                       value="<%=event.getImageURL()%>" required>
            </div>

            <div class="form-group">
                <label for="date">Date:</label>
                <input type="date" class="form-control" id="date" name="date"
                       value="<%=event.getEventDate()%>" required>
            </div>

            <div class="form-group">
                <label for="time">Time:</label>
                <input type="time" class="form-control" id="time" name="time"
                       value="<%=event.getEventTime()%>" required>
            </div>

            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" step="0.01"
                       value="<%=event.getPrice()%>" required>
            </div>

            <div class="form-group">
                <label for="isActive">isActive:</label>
                <input type="text" class="form-control" id="isActive" name="isActive" step="0.01"
                       value="<%=event.getIsActive() %>" disabled required>
            </div>
              <div class="form-group text-center pt-3">
                <button type="submit" class="btn btn-danger" name="deleteButton">Delete Event</button>
                <button type="submit" class="btn btn-primary" name="updateButton">Update Event</button>
            </div>

           
        </form>

      
    </div>
    
 
    
    <!-- Include Bootstrap JS (optional) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
