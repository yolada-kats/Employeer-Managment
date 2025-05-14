<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee Updated</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 50px;
            padding: 20px;
        }
        h2 {
            color: #2c3e50;
        }
        p {
            font-size: 16px;
            margin: 8px 0;
        }
        a {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 15px;
            background-color: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background-color: #2980b9;
        }
    </style>
</head>
<body>
    <h2>Employee Updated Successfully</h2>

    <p><strong>ID:</strong> ${updatedEmployee.employeeId}</p>
    <p><strong>First Name:</strong> ${updatedEmployee.firstName}</p>
    <p><strong>Last Name:</strong> ${updatedEmployee.lastName}</p>
    <p><strong>Position:</strong> ${updatedEmployee.position}</p>
    <p><strong>Department:</strong> ${updatedEmployee.department}</p>

    <br>
	<a href="${pageContext.request.contextPath}/index.html">Return to Menu</a>
</body>
</html>


