<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Event</title>
    
    <!-- Include Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt1">
        <h1 class=" text-center pt-3">Create Event</h1>
        
        <form action="AddEventServlet" method="post">
            <div class="form-group">
                <label for="event_name">Event Name:</label>
                <input type="text" class="form-control" id="event_name" name="event_name" required>
            </div>

            <div class="form-group">
                <label for="event_description">Event Description:</label>
                <input type="text" class="form-control" id="event_description" name="event_description" required>
            </div>

            <div class="form-group">
                <label for="event_address">Event Address:</label>
                <textarea class="form-control" id="event_address" name="event_address" rows="3" required></textarea>
            </div>

          
            <div class="form-group">
                <label for="img_url">Image URL:</label>
                <input type="text" class="form-control" id="img_url" name="img_url" required>
            </div>

            <div class="form-group">
                <label for="date">Date:</label>
                <input type="date" class="form-control" id="date" name="date" required>
            </div>

            <div class="form-group">
                <label for="time">Time:</label>
                <input type="time" class="form-control" id="time" name="time" required>
            </div>

            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" class="form-control" id="price" name="price" step="0.01" required>
            </div>

            <div class="form-group">
                <label for="HostEmail">Host email:</label>
                <input type="email" class="form-control" id="HostEmail" name="HostEmail" required>
            </div>

            <div class="form-group text-center pt-3">
            <button type="submit" class="btn btn-primary">Create Event</button>
            </div>
        </form>
    </div>
    
    <!-- Include Bootstrap JS (optional) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
