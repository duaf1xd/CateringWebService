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

</head>
<body>
	<jsp:include page="nav-bar.jsp"></jsp:include>
	<div style="padding: 50px"></div>
	<h1>Confirm your order</h1>
	<form action="PersistOrder">
	
		<input type="hidden" name="per_req" value="${content}">
		<input type="hidden" name="per_total" value="${total}">
		<input type="hidden" name="per_coupon" value="${coupon}">
		<input type="hidden" name="per_add" value="${addr}">
		<table id="menu_table">
			<tr>
				<th>Order Content</th>
				<th>Total Price</th>
				<th>Applied Coupon</th>
				<th>Deliver to:</th>
				
			</tr>
			
                <tr>
                    <td id="req_content"><c:out value="${content}"/></td>
                    <td><c:out value="${total}"/></td>
                    <td id="app_coupon"><c:out value="${coupon}"/></td>
                    <td id="address"><c:out value="${addr}"/></td>
                </tr>
			
		</table>
		
		<br>
		<br>
		<br>
		
		<div id="recycle_info">
			Would you like to allow us to recycle your throwaway utensils and containers and distribute your leftover food after sterilization as part of the #GoGreen program?
			<br>
			<br>
			We will collect the items after your meal for free, plus, get a 10% discount coupon for your next order!
			<br>
			<br>
			<input type="checkbox" name="per_recycle" value="YES">
			<label for="recycle">Yes, please collect my leftovers!</label>
		
		</div>

		<input type="submit" name="submit" value="Confirm order">
	</form>
</body>
</html>