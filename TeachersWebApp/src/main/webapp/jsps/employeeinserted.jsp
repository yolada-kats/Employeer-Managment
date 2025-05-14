<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee Inserted</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            padding: 40px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 32px;
        }

        .table-container {
            width: 80%;
            margin: 0 auto;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            background-color: #ffffff;
        }

        th {
            background-color: #0084ff;
            color: white;
            font-weight: bold;
            padding: 15px;
            text-align: center;
        }

        td {
            padding: 14px;
            text-align: center;
            border-bottom: 1px solid #ddd;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a.button {
            display: block;
            width: fit-content;
            margin: 30px auto 0;
            padding: 10px 25px;
            background-color: #0084ff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
        }

        a.button:hover {
            background-color: #006edc;
        }
    </style>
</head>
<body>

    <h2>Employee Inserted Successfully</h2>

    <div class="table-container">
        <table>
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Position</th>
                <th>Department</th>
            </tr>
            <tr>
                <td>${insertedEmployee.employeeId}</td>
                <td>${insertedEmployee.firstName}</td>
                <td>${insertedEmployee.lastName}</td>
                <td>${insertedEmployee.position}</td>
                <td>${insertedEmployee.department}</td>
            </tr>
        </table>
    </div>

    <a class="button" href="/TeachersWebApp/index.html">Back to Menu</a>

</body>
</html>
