<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <!-- Custom fonts for this template -->
     <jsp:include page = "admin_resources.jsp"></jsp:include>
</head>
<body>
<div class="container col-md-5">
    <div class="card">
     <c:if test="${error != null}">
<div class="alert alert-danger alert-dismissible fade show">
        <strong>Error!</strong><c:out value="${error}" />
         <c:remove var="error" scope="session"/>
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
    </c:if>
        <div class="card-body">
	<form action="UpdateCustomerServlet" method="POST">
								
					 <input type="hidden" name="id" value="<c:out value='${customer.id}' />" /> 			
					<div class="form-group">
						<label>Name</label>			
   						<input type="text" name="name" value="<c:out value='${customer.name}' />" class="form-control" required> 
 	  	     
					</div>
					<div class="form-group">
						<label>Name</label>			
   						<input type="text" name="username" value="<c:out value='${customer.username}' />" class="form-control" required> 
 	  	     
					</div>
					
					<div class="form-group">
						<label>Email</label>
						 <input type="text" name="email" value="<c:out value='${customer.email}' />" class="form-control" required> 
					</div>	
					<div class="form-group">
						<label>Address</label>						
   					 <input class="form-control" type="text" value="<c:out value='${customer.address}' />" name = "address" required/>
   				 
				</div> 
								
					<div class="form-group">
						<label>Phone Number</label>
						  <input type="number" class="form-control" name="phoneNumber"  value="<c:out value='${customer.phoneNumber}' />" required>
					</div>	
					 <div class="form-group">
						<label>Date Of Birth</label>
   					 <input class="form-control" type="date" name = "dob" value="<c:out value='${customer.dob}' />" required/>
   				 
				</div> 
							
				<div class="form-group">
                           <div class="col-xs-12">
                                <br>
                              	<button type="submit" class="btn btn-outline-primary btn-sm m-0 waves-effect">Save</button>
                              	 <button class="btn btn-outline-danger btn-sm m-0 waves-effect" onclick="window.location.href='request.getContextPath()/CustomerServlet'">Cancel</button>
                            </div>
                      </div>
				
			</form>
			</div>		
			</div>
			</div>
		
</body>
</html>