<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Employee</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 40px;
            background-color: #f5f5f5;
        }

        .wrapper {
            width: 50%;
            margin: auto;
            background-color: #fff;
            padding: 30px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
            border-radius: 10px;
        }

        h2 {
            text-align: center;
            color: #007bff;
            margin-bottom: 20px;
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
    <h2>Insert New Employee</h2>
    <form method="POST" action="/TeachersWebApp/EmployeeInsertController">
        <div class="form-group">
            <input name="id" type="text" placeholder="Employee ID" required />
        </div>
        <div class="form-group">
            <input name="lastName" type="text" placeholder="Last Name" required />
        </div>
        <div class="form-group">
            <input name="firstName" type="text" placeholder="First Name" required />
        </div>
        <div class="form-group">
            <input name="position" type="text" placeholder="Position" required />
        </div>
        <div class="form-group">
            <input name="department" type="text" placeholder="Department" required />
        </div>
        <button type="submit">Insert</button>
    </form>
</div>

</body>
</html>
