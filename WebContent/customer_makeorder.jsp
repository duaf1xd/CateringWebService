<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, entity.Item"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Custom styles for this template-->
<link href="css/restaurant.css" rel="stylesheet">

<%
	/* broken code :)
	//List<Item> li= (List<Item>) request.getAttribute("itemList");
	request.setAttribute("itList", li);
	RequestDispatcher rd = request.getRequestDispatcher("/FinalizeOrder");
	rd.forward(request, response);
	
	*/
%>  


</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<div style="padding: 50px"></div>
	<h1>Menu</h1>
	<form action="FinalizeOrder" id="menu_form">
		<table id="menu_table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Unit</th>
				<th>Price per unit</th>
				<th>Quantity (multiple of 0.25)</th>
			</tr>
			<c:forEach var="item" items="${itemList}">
                <tr>
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.name}"/></td>
                    <td><c:out value="${item.unit}"/></td>
                    <td><c:out value="${item.price}"/></td>
                    <td>
                    	<input type="number"  name="amount" step="0.25" value="1.00" min="0.25">
                        
                    </td>
                </tr>
            </c:forEach>
			
		</table>
		
		Coupon code (if any) (max 1):
		<input type="text" name="coupon_code">
		
		<br>
		
		Deliver to:
		<textarea name="address" id="address"></textarea>
		
		<br>
		<input type="submit" name="submit" value="Calculate cost">
	</form>
</body>
</html>