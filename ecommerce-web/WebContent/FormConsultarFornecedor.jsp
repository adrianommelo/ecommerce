<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet" href="resources/css/font-awesome.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">

<!-- Css animations  
<link href="css/animate.css" rel="stylesheet">-->

<!-- Theme stylesheet, if possible do not edit this stylesheet 
<link href="css/style.default.css" rel="stylesheet"
	id="theme-stylesheet">-->

<!-- Custom stylesheet - for your changes
<link href="css/custom.css" rel="stylesheet">-->
<title>Fornecedor</title>
</head>
<body>
	<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
	%>

	<div class="container">

		<div class="form-group">
			<form action="ConsultarFornecedor" method="post">

				<div class="col-md-9">
					<h2 class="text-uppercase">Consultar Fornecedor</h2>
					<hr>
					<p>Consulte o Fornecedor através de um dos campos abaixo:</p>
				</div>



				<div class="col-md-9">
					<div class="col-md-2">

						<label for="txtId">Id</label> <input type="text"
							class="form-control" id="txtId" name="txtId" />

					</div>
					<div class="col-md-4">

						<label for="txtRzSocial">Razão Social</label> <input type="text"
							class="form-control" id="txtRzSocial" name="txtRzSocial" />

					</div>
					<div class="col-md-4">
						<label for="txtCnpj">CNPJ</label> <input type="text"
							class="form-control" id="txtCnpj" name="txtCnpj" />
					</div>


					<div class="col-md-2">
						<sub>
							<button type="submit" class="btn btn-info" id="operacao"
								name="operacao" value="CONSULTAR">CONSULTAR</button>
						</sub>
					</div>
				</div>
			</form>
		</div>


		<div class="col-sm-9">
			<c:if test="${resultado.entidades != null }">
				<c:import url="ListaFornecedor.jsp" />
			</c:if>
		</div>
	</div>
	<!-- /.container -->



</body>
</html>