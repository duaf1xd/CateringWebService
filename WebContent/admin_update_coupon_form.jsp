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
	
        <form method="post" action="AdminUpdateCouponServlet">
        <div>   
            <div>
            <fieldset>
                <label>ID:</label>
                <input type="hidden" value="<c:out value='${coupon.id}' />" name="id" required> 
                <input type="text" value="<c:out value='${coupon.id}' />" disabled>
            </fieldset>
            <fieldset>
                <label>Code:</label>
                <input type="text" value="<c:out value='${coupon.code}' />" name="code" required>
            </fieldset>
            <fieldset>
                <label>Description:</label>
                <input type="text" value="<c:out value='${coupon.description}' />" name="description" required>
            </fieldset>
            <fieldset>
                <label>Rate:</label>
                <input type="number" value="<c:out value='${coupon.rate}' />" name="rate" required>
            </fieldset>
            <fieldset>
                <label>Min Order Price:</label>
                <input type="number" value="<c:out value='${coupon.minOrderPrice}' />" name="min_order_price" required>
            </fieldset>
            <fieldset>
                <label>Max Reduction Price:</label>
                <input type="number" value="<c:out value='${coupon.maxReductionPrice}' />" name="max_reduction_price" required>
            </fieldset>
            <fieldset>
                <label>Expired Date:</label>
                <input type="date" value="<c:out value='${coupon.expiredDate}' />" name="expired_date" required>
            </fieldset>
            <fieldset>
                <label>Current Usage Count:</label>
                <input type="number" value="<c:out value='${coupon.currentUsageCount}' />" name="current_usage_count" disabled>
            </fieldset>
            <fieldset>
                <label>Max Usage Count:</label>
                <input type="number" value="<c:out value='${coupon.maxUsageCount}' />" name="max_usage_count" required>
            </fieldset>
            </div>

            <button>Save</button>
           
           </div>
        </form>
</body>
</html>