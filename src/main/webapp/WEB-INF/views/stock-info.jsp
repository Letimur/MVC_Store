<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>Spring MVC Zero XML Example</title>
</head>

<body>
        <h3>Stock</h3>
        <table cellspacing="5">

                <th>ID</th>
                <th>Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <c:forEach var="t" items="${stockInfo}">
                <tr>

                    <td>${t.id}</td>
                    <td>${t.product}</td>
                    <td>${t.price}</td>
                    <td>${t.quantity}</td>
                </tr>
                </c:forEach>
        </table>
</body>
</html>
