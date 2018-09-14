<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<spring:url var="css" value="/resources/css"></spring:url>
<spring:url var="images" value="/resources/images"></spring:url>
<spring:url var="js" value="/resources/js"></spring:url>


<c:set var="contextRoot" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Ecommerce - ${title}</title>

<script type="text/javascript">
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>





<!-- Bootstrap core CSS -->
<link href="${css}/bootstrap.min.css" rel="stylesheet">

<!-- Bootstrap Theme CSS -->
<link href="${css}/bootstrap.readable.css" rel="stylesheet">

<!-- Bootstrap DATATABLE CSS -->
<link href="${css}/dataTables.bootstrap4.css" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="${css}/shop-homepage.css" rel="stylesheet">



</head>

<body>

	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>



		<!-- Page Content Home-->
		<div class="content">
			<!-- load only when user clicks home-->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>


			<!-- load only when user clicks About-->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>

			<!-- load only when user clicks Contact-->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>


			<!-- load only when user clicks category or all-->
			<c:if
				test="${userClickCategoryProducts==true or userClickAllProducts==true}">
				<%@include file="listProduct.jsp"%>
			</c:if>


			<!-- load only when user clicks view product icon-->
			<c:if test="${userClickShowProduct==true}">
				<%@include file="singleProduct.jsp"%>
			</c:if>



		</div>
		<!-- Footer -->
		<%@include file="./shared/footer.jsp"%>


		<!-- Bootstrap core JavaScript -->
		<script src="${js}/jquery.min.js"></script>
		<script src="${js}/bootstrap.bundle.min.js"></script>

		<!-- data table jquery -->
		<script src="${js}/jquery.dataTables.js"></script>


		<!-- data table bootstrap js -->
		<script src="${js}/dataTables.bootstrap4.js"></script>


		<!-- custom jsp by the developer -->
		<script src="${js}/myApp.js"></script>

	</div>
</body>

</html>
