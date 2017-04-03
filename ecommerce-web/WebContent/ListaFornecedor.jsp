<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
    import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet" href="resources/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.css">

<!-- Css animations  -->
<link href="resources/css/animate.css" rel="stylesheet">

<!-- Theme stylesheet, if possible do not edit this stylesheet -->
<link href="resources/css/owl.theme.css" rel="stylesheet"
	id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="resources/css/custom.css" rel="stylesheet">

<title>Fornecedor</title>
</head>
<body>
	<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
	%>

	<div id="content">
		<div class="container">

			<div class="row">
				<div class="box">
					<div class="col-md-10">
						<h2 class="text-uppercase">Fornecedor(es) encontrado(s)</h2>
						<br>
						<!-- <form action="AlterarFornecedor" method="post"> -->
					</div>
				</div>
			</div>
			<div class="row">
				<div class="box">
					<div class="col-md-10">
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
			</div>
			<!-- /.row -->

		</div>
		<!-- /.container -->
	</div>
	<!-- /#content -->
</body>
</html>