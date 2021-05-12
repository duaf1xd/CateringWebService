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
	<h1>Your created orders</h1>
	
		<table id="menu_table">
			<tr>
				<th>Detail</th>
				<th>Status</th>
				<th>Time created</th>
				<th>Recycle leftovers</th>
				<th>Total price</th>
				<th>Deliver to</th>
			</tr>
			<c:forEach var="order" items="${orderList}">
				
                <tr>
                    <td id="req_content"><c:out value="${order.detail}"/></td>
                   
                    <c:if test = "${order.status == 1}"><td>Pending</td> </c:if>
                    <c:if test = "${order.status == 0}"><td>Completed</td> </c:if>
                    <c:if test = "${order.status == -1}"><td>Cancelled</td> </c:if>
                    <td><c:out value="${order.requestTime}"/></td>
                    <c:if test = "${order.recycle == 1}"><td>Yes</td> </c:if>
                    <c:if test = "${order.recycle == 0}"><td>No</td> </c:if>
                    <td><c:out value="${order.totalPrice}"/></td>
                    <td><c:out value="${order.deliverAd}"/></td>
                    
                </tr>
            </c:forEach>
			
		</table>

		
	
</body>
</html>