<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Customer Management</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
<link rel="stylesheet" href="resources/table.css">
    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
   <jsp:include page = "sidebar.jsp"></jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
	<jsp:include page = "topbar.jsp"></jsp:include>
                <!-- Topbar -->
            
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
          <div class="title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Manage <b>Customer</b></h2>
					</div>
				<!-- 	<div class="col-sm-6">
						<a href="#addEmployeeModal" class="btn btn-outline-primary btn-sm m-0 waves-effect"  data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>New Contract</span></a>						
					</div>
					 -->
				</div>
			</div> 
			</div>

			<c:if test="${error != null}">
<div class="alert alert-danger alert-dismissible fade show">
        <strong>Error!</strong><c:out value="${error}" />
         <c:remove var="error" scope="session"/>
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
    </c:if> 
     <c:if test="${success != null}">
    <div class="alert alert-success alert-dismissible fade show">
        <strong>Success!</strong><c:out value="${success}" />
         <c:remove var="message" scope="session"/>
        <button type="button" class="close" data-dismiss="alert">&times;</button>
    </div>
    </c:if> 
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                           <!-- <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6> --> 
                            <a href="ExportToFileServlet" class="btn btn-outline-primary btn-sm m-0 waves-effect"><i class = "material-icons">&#xE147;</i> 
                       <span>Export To Excel</span></a>				
                    
                        </div>
                        
                       
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Name</th>
                                            <th>Username</th>
                                            <th>Email</th>
                                            <th>Address</th>
                                            <th>Phone Number</th>
                                            <th>Date Of Birth</th>
                                         <th>Action</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Name</th>
                                            <th>Username</th>
                                            <th>Email</th>
                                            <th>Address</th>               
                                            <th>Phone Number</th>
                                            <th>Date Of Birth</th>
                                            <th>Action</th>
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <c:forEach var = "customer" items = "${customers}">
                                        <tr>
                                            <td><c:out value = "${customer.name}"/></td>
                                            <td><c:out value = "${customer.username }"/></td>
                                            <td><c:out value = "${customer.email }"/></td>
                                      		<td><c:out value = "${customer.address }"/></td>
                                            <td><c:out value = "${customer.phoneNumber }"/></td>
                                            <td><c:out value = "${customer.dob }"/></td>
                                           <td>
        									<a href="UpdateCustomerFormServlet?id=<c:out value='${customer.id}' />" > <i class="fas fa-pencil-alt mt-0"></i></a>                   	                   	
                     						<a href="RemoveCustomerServlet?id=<c:out value='${customer.id}' />" >  <i class="fas fa-trash-alt mt-0"></i></a>
                     
                 	
                                           </td>
                                        </tr>
                                       </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->

            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    


    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>

</html>