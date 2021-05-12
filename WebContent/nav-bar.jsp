<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
      	<li id="courseman"><a href="<%=request.getContextPath()%>/">CWS</a></li>
  		<li><a href="<%=request.getContextPath()%>/customer_menu">Menu</a></li>
        <li><a href="<%=request.getContextPath()%>/customer_order_status">My orders</a></li>
        
        <c:if test="${sessionScope.username != null}">
		    <li><a href="<%=request.getContextPath()%>/LogoutServlet">Logout</a></li>
		</c:if>
		
		<c:if test="${sessionScope.username == null}">
		    <li><a href="<%=request.getContextPath()%>/login_customer.jsp">Login</a></li>
		</c:if>
        
	</ul>
	
</body>
</html>