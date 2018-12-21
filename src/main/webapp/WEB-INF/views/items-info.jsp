<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Склад</title>
</head>
<body>
<div align="center">
    <h1>Склад информация о всех продуктах</h1>
    <table border="1" cellspacing="5">

        <th>Продукт</th>
        <th>Продан</th>
        <th>Дата поступления</th>
        <c:forEach var="t" items="${items}" varStatus="status">
            <tr>

                <td>${t.product}</td>
                <td>${t.sold}</td>
                <td>${t.date}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<h3><a href="/MVCStore/stock">Вернуться к общей информации</a></h3>
</body>
</html>
