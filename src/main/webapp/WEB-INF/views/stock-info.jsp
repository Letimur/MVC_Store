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
        <h1>Склад</h1>
        <h3><a href="/MVCStore/add">Добавить продукт</a></h3>
        <h3><a href="/MVCStore/details">Подробная информация о складе</a></h3>
        <table border="1" cellspacing="5">


                <th>Продукт</th>
                <th>Цена</th>
                <th>Кол-во</th>
                <c:forEach var="t" items="${stockInfo}" varStatus="status">
                <tr>


                    <td>${t.product}</td>
                    <td>${t.price}</td>
                    <td>${t.quantity}</td>
                    <td>
                        <a href="/MVCStore/editProduct?id=${t.id}">Изменить</a>
                        <a href="/MVCStore/deleteProduct?id=${t.id}">Удалить</a>
                    </td>
                </tr>
                </c:forEach>
        </table>
    </div>
    <h3><a href="/MVCStore">Главная страница</a></h3>
</body>
</html>
