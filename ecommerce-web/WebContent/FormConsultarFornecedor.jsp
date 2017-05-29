<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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

<link
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800"
	rel="stylesheet" type="text/css">

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet" href="resources/css/font-awesome.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">

<!-- Css animations  -->
<link href="resources/css/animate.css" rel="stylesheet">

<!-- Theme stylesheet, if possible do not edit this stylesheet -->
<link href="resources/css/style.default.css" rel="stylesheet"
	id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="resources/css/custom.css" rel="stylesheet">

<!-- Responsivity for older IE -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
<![endif]-->

<!-- Favicon and apple touch icons-->
<link rel="shortcut icon"
	href="resources/img/512px-Gift_font_awesome.png" type="image/x-icon">
<link rel="apple-touch-icon" href="resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="57x57"
	href="resources/img/apple-touch-icon-57x57.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="resources/img/apple-touch-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="resources/img/apple-touch-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="resources/img/apple-touch-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="resources/img/apple-touch-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="resources/img/apple-touch-icon-152x152.png">
</head>
<body>
	<%
		Resultado resultado = (Resultado) request.getAttribute("resultado");
	%>

	<div class="container">

		<c:if test="${resultado.msg != null}">
			<div class="bg-success text-success">
				${resultado.msg }
			</div>
		</c:if>
		<div class="form-group">
			<form action="ConsultarFornecedor" method="post">

				<div class="col-sm-9">
					<h2 class="text-uppercase">Consultar Fornecedor</h2>
					<hr>
					<p>Consulte o Fornecedor através de um dos campos abaixo:</p>
				</div>



				<div class="col-sm-9">
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
			<c:if test="${resultado.entidades != null && resultado.msg == null }">
				<c:import url="ListaFornecedor.jsp" />
			</c:if>
		</div>
	</div>
	<!-- /.container -->



</body>
</html>