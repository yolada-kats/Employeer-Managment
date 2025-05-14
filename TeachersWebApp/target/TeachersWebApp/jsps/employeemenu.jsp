<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f5f5f5;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 40px;
        }

        .wrapper {
            width: 50%;
            margin: auto;
            background-color: #fff;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }

        .section {
            margin-bottom: 40px;
        }

        .section h2 {
            color: #007bff;
            margin-bottom: 20px;
            text-align: center;
        }

        .form-group {
            margin-bottom: 15px;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        button {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            display: block;
            margin: auto;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>


    <div class="wrapper">

        <!-- Αναζήτηση -->
        <div class="section">
            <h2>Search Employee by Last Name</h2>
            <form method="GET" action="/TeachersWebApp/EmployeeSearchController">
                <div class="form-group">
                    <input type="text" name="lastName" placeholder="Enter employee's last name">
                </div>
                <button type="submit">Search</button>
            </form>
        </div>
</body>
</html>

