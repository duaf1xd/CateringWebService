<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="AdminUpdateItemServlet" enctype="multipart/form-data">
        <div>   
            <div>
            <fieldset>
                <label>ID:</label>
                <input type="hidden" value="<c:out value='${item.id}' />" name="id" required> 
                <input type="text" value="<c:out value='${item.id}' />" disabled>
            </fieldset>
            <fieldset>
                <label>Name:</label>
                <input type="text" value="<c:out value='${item.name}' />" name="name" required>
            </fieldset>
            <fieldset>
                <label>Description:</label>
                <input type="text" value="<c:out value='${item.description}' />" name="description" required>
            </fieldset>
            <fieldset>
                <label>Image:</label>
                <input type="text" value="<c:out value='${item.image}' />" name="image" disabled>
                <input type="file" name="image">
            </fieldset>
            <fieldset>
                <label>Price:</label>
                <input type="number" value="<c:out value='${item.price}' />" name="price" required>
            </fieldset>
            <fieldset>
                <label>In Stock:</label>
                <input type="number" value="<c:out value='${item.inStock}' />" name="in_stock" required>
            </fieldset>
            <fieldset>
                <label>Image Base:</label>
                <input type="text" value="<c:out value='${item.imageBase}' />" name="imagebase" disabled>
            </fieldset>
            <fieldset>
                <label>Unit:</label>
                <input type="text" value="<c:out value='${item.unit}' />" name="unit" required>
            </fieldset>
            </div>

            <button>Save</button>
           
           </div>
        </form>
</body>
</html>