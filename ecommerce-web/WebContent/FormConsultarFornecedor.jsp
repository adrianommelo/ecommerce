<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- Css animations  -->
<link href="css/animate.css" rel="stylesheet">

<!-- Theme stylesheet, if possible do not edit this stylesheet -->
<link href="css/style.default.css" rel="stylesheet"
	id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="css/custom.css" rel="stylesheet">
<title>Fornecedor</title>
</head>
<body>
	<div id="content">
		<div class="container">

			<div class="row">
				<div class="col-md-6">
					<div class="box">
						<h2 class="text-uppercase">Consultar Fornecedor</h2>
						<hr>
						<form action="ConsultarFornecedor" method="post">
							<p>Consulte o Fornecedor através de um dos campos abaixo: </p>
							
							<div class="form-group">
								<label for="txtId">Id</label> <input type="text"
									class="form-control" id="txtId" name="txtId" />
							</div>							
							<div class="form-group">
								<label for="txtRzSocial">Razão Social</label> <input type="text"
									class="form-control" id="txtRzSocial" name="txtRzSocial" />
							</div>							
							<div class="form-group">
								<label for="txtCnpj">CNPJ</label> <input type="text"
									class="form-control" id="txtCnpj" name="txtCnpj" />
							</div>
							
							<div class="text-center">
								<button type="submit" class="btn btn-template-main"
									id="operacao" name="operacao" value="CONSULTAR">
									CONSULTAR
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- /.row -->
			
		</div>
		<c:import url="ListaFornecedor.jsp" />
		<!-- /.container -->
	</div>
	<!-- /#content -->
</body>
</html>