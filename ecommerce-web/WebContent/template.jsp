<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page
	import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta name="robots" content="all,follow">
<meta name="googlebot" content="index,follow,snippet,archive">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Ecomm</title>

<meta name="keywords" content="">

<!-- css files, bootstrap, links -->
<c:import url="css-files.jsp"></c:import>

</head>

<body>
	<div id="all">
		<!-- header -->
		<c:import url="header-template.jsp"></c:import>


		<!-- search-bar -->
		<c:import url="search-bar.jsp"></c:import>

		<div id="content">
			<div class="container">
				<div class="row">
					<!-- coluna esquerda -->
					<c:import url="left-menu-products.jsp"></c:import>
					<!-- coluna direita -->
					<c:import url="products.jsp"></c:import>
				</div>
				<!-- row -->
			</div>
			<!-- /.container -->
		</div>
		<!-- /#content -->

		<c:import url="footer-template.jsp"></c:import>
		<!-- footer -->

		<c:import url="copyright.jsp"></c:import>
		<!-- copyright -->

	</div>
	<!-- /#all -->


	<!-- #### JAVASCRIPT FILES ### -->

	<c:import url="js-files.jsp"></c:import>
</body>
</html>