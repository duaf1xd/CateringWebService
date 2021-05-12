<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Custom styles for this template-->
<link href="css/restaurant.css" rel="stylesheet">
</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<div style="padding: 50px"></div>
	<h1>Menu</h1>
	<form action="MakeOrder">
		<table id="menu_table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Image</th>
				<th>Unit</th>
				<th>Price per unit</th>
				<th>Order?</th>
			</tr>
			<c:forEach var="item" items="${itemList}">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.description}"/></td>
                    <td><c:out value="${item.image}"/></td>
                    <td><c:out value="${item.unit}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td>
                    	<input type="checkbox" name="item" value="<c:out value='${item.id}'/>">
                        
                    </td>
                </tr>
            </c:forEach>
			
		</table>

		<input type="submit" name="submit" value="Proceed to ordering">
	</form>
</body>
</html>