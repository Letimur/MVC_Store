<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавить/изменить продукт</title>
</head>
<body>
<div align="center">
    <h1>Добавление/изменение продукта</h1>
    <%--@elvariable id="productInfo" type="com.controllers"--%>
    <form:form action="saveProduct" method="post" modelAttribute="productInfo">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Продукт:</td>
                <td><form:input path="product" /></td>
            </tr>
            <tr>
                <td>Цена:</td>
                <td><form:input path="price" /></td>
            </tr>
            <tr>
                <td>Кол-во:</td>
                <td><form:input path="quantity" /></td>
            </tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>