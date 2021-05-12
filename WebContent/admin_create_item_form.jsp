<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" enctype="multipart/form-data" action="AdminCreateItemServlet">
      	<div>
            <h3>Create Item</h3>
           	<div>
            	<fieldset>
                	<label>Name:</label>
                	<input type="text" name="name" required>
            	</fieldset>
            	<fieldset>
                	<label>Description:</label>
                	<input type="text" name="description" required>
            	</fieldset>
            	<fieldset>
                	<label>Image:</label>
                	<input type="file" name="image" required>
            	</fieldset>
            	<fieldset>
                	<label>Price:</label>
                	<input type="number" name="price" required>
            	</fieldset>
            	<fieldset>
                	<label>In Stock:</label>
                	<input type="number" name="in_stock" required>
            	</fieldset>
            	<fieldset>
                	<label>Unit:</label>
                	<input type="text" name="unit" required>
            	</fieldset>
            </div>
         	<button>Create</button>
        </div>
   	</form>
</body>
</html>