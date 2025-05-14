<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 60px 20px;
        }

        .wrapper {
            max-width: 600px;
            margin: 0 auto;
            background-color: #fff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }

        h2 {
            text-align: center;
            margin-bottom: 30px;
            color: #007bff;
            font-size: 28px;
        }

        .form-group {
            margin-bottom: 20px;
        }

        input[type="text"] {
            width: 100%;
            padding: 12px 14px;
            border-radius: 6px;
            border: 1px solid #ccc;
            font-size: 16px;
            transition: border-color 0.3s ease;
        }

        input[type="text"]:focus {
            border-color: #007bff;
            outline: none;
        }

        button {
            width: 120px;
            margin: 20px auto 0;
            display: block;
            padding: 10px;
            font-size: 16px;
            color: white;
            background-color: #007bff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <div class="wrapper">
        <h2>Update Employee</h2>
        <form action="/TeachersWebApp/EmployeeUpdateController" method="POST">
            <div class="form-group">
                <input type="text" name="id" placeholder="Employee ID" required>
            </div>
            <div class="form-group">
                <input type="text" name="firstName" placeholder="First Name" required>
            </div>
            <div class="form-group">
                <input type="text" name="lastName" placeholder="Last Name" required>
            </div>
            <div class="form-group">
                <input type="text" name="position" placeholder="Position" required>
            </div>
            <div class="form-group">
                <input type="text" name="department" placeholder="Department" required>
            </div>
            <button type="submit">Update</button>
        </form>
    </div>

</body>
</html>
