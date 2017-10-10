<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

	<div id="content">
		<div class="container">



			<div class="col-sm-9">
				<h2 class="text-uppercase">Fornecedor(es) encontrado(s)</h2>
				<br>
				<!-- <form action="AlterarFornecedor" method="post"> -->
			</div>




			<div class="col-sm-9">
				<table class="table">
					<tr>
						<th nowrap="nowrap">Id</th>
						<th nowrap="nowrap">Razão Social</th>
						<th nowrap="nowrap">Cnpj</th>
						<th nowrap="nowrap">Data Cadastro</th>
						<th nowrap="nowrap">Email</th>
						<th nowrap="nowrap" colspan="2">Ações</th>
					</tr>
					<c:forEach var="fornecedor" items="${resultado.entidades}">
						<tr id="fornecedor${fornecedor.id}">
							<!-- <input type="hidden" name="txtId" value="${fornecedor.id}"> -->
							<td id="txtId" nowrap="nowrap">${fornecedor.id}</td>
							<td id="txtRzSocial" nowrap="nowrap">${fornecedor.razaoSocial}</td>
							<td id="txtCnpj" nowrap="nowrap">${fornecedor.cnpj}</td>
							<td id="txtDtCadastro" nowrap="nowrap">${fornecedor.dtCadastro}</td>
							<td id="txtForEmail" nowrap="nowrap">${fornecedor.usuario.email}</td>
							<td><a type="submit" class="btn btn-warning"
								href="/ecommerce-web/AlterarFornecedor?txtId=${fornecedor.id}&operacao=CONSULTAR">ALTERAR</a>
							</td>
							<td><a type="submit" class="btn btn-danger"
								href="/ecommerce-web/ExcluirFornecedor?txtId=${fornecedor.id}&operacao=EXCLUIR">EXCLUIR</a>

							</td>
						</tr>
					</c:forEach>
				</table>
				<!-- </form> -->
			</div>



		</div>
		<!-- /.container -->
	</div>
	<!-- /#content -->
</body>
</html>