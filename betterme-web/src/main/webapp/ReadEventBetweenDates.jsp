<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Event Search</title>
    <!-- Include Bootstrap CSS for inspiration -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f5f5f5;
            font-family: Arial, sans-serif;
        }
        .container {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.2);
            margin-top: 20px;
            text-align: center; /* Center-align the contents */
        }
        h2 {
            color: #333;
        }
        .form-group {
            margin-bottom: 20px;
            text-align: left; /* Left-align the form labels */
        }
        label {
            font-weight: bold;
            color: #555;
        }
        .form-control {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            width: 70%; 
            font-size: 16px;
            display: inline-block; 
            margin-right: 10px; 
        }
        button.btn-primary {
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button.btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Event Search</h2>
        <form action="./ReadEventBetweenDate" method="post">
            <div class="form-group">
                <label for="from">From :</label>
                <input type="date" id="searchDate" name="from" class="form-control">
            </div>
            
               <div class="form-group">
                <label for="to">To   :</label>
                <input type="date" id="searchDate" name="to" class="form-control">
            </div>
            <button type="submit" class="btn btn-primary">Search</button>
        </form>
    </div>
</body>
</html>
