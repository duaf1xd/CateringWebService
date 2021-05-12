<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
        <form method="post" action="AdminCreateCouponServlet">
           <div>
            <h3>Create Coupon</h3>
              <div>
            <fieldset>
                <label>Code:</label>
                <input type="text" name="code" required>
            </fieldset>
            <fieldset>
                <label>Description:</label>
                <input type="text" name="description" required>
            </fieldset>
            <fieldset>
                <label>Rate:</label>
                <input type="number" name="rate" required>
            </fieldset>
            <fieldset>
                <label>Min Order Price:</label>
                <input type="number" name="min_order_price" required>
            </fieldset>
            <fieldset>
                <label>Max Reduction Price:</label>
                <input type="number" name="max_reduction_price" required>
            </fieldset>
            <fieldset>
                <label>Expired Date:</label>
                <input type="date" name="expired_date" required>
            </fieldset>
            <fieldset>
                <label>Max Usage Count:</label>
                <input type="number" name="max_usage_count" required>
            </fieldset>
            
            </div>
          	  <button>Create</button>
        </div>
        </form>
</body>
</html>