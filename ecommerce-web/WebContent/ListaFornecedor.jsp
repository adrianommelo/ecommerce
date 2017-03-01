<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ page
	import="ecommerce.core.aplicacao.Resultado, ecommerce.dominio.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
	rel='stylesheet' type='text/css'>

<!-- Bootstrap and Font Awesome css -->
<link rel="stylesheet"
	href="resources/css/font-awesome.min.css">
<link rel="stylesheet"
	href="resources/css/bootstrap.min.css">

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
				<div class="col-md-6">
					<div class="box">
						<h2 class="text-uppercase">Cliente(s) encontrados</h2>
						
						<table class="table">
							<tr>
								<th>Razão Social</th>
								<th>Cnpj</th>
								<th>Data Cadastro</th>
								<th>Email</th>
								<th colspan="2" >Ações</th>
							</tr>
							<c:forEach var="cj" items="${resultado.entidades}">
								<tr id="cli_juri${cj.id}">
									<td>${cj.razaoSocial}</td>
									<td>${cj.cnpj}</td>
									<td>${cj.dtCadastro}</td>
									<td>${cj.usuario.email}</td>
									<td>
										<button type="submit" class="btn btn-template-main "
										id="operacao" name="operacao" value="ALTERAR">
										ALTERAR
										</button>
									</td>
									<td>
										<button type="submit" class="btn btn-template-main"
										id="operacao" name="operacao" value="EXCLUIR">
										EXCLUIR
										</button>
									</td>
								</tr>
							</c:forEach>
						</table>
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