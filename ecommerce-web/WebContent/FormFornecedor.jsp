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

	<div class="col-md-9">
		<h2 class="text-uppercase lead">Novo Fornecedor</h2>
		<hr>
	</div>

	<form class="form-group" action="SalvarFornecedor" method="post">
		<div class="col-sm-9">
			<div class="col-md-6">
				<label for="txtRzSocial">Razão Social</label> <input type="text"
					class="form-control" id="txtRzSocial" name="txtRzSocial"> <label
					for="txtForEmail">Email</label> <input type="text"
					class="form-control" id="txtForEmail" name="txtForEmail"> <label
					for="txtCnpj">CNPJ</label> <input type="text" class="form-control"
					id="txtCnpj" name="txtCnpj"> <label
					for="txtTelefoneContato">Telefone Contato</label> <input
					type="text" class="form-control" id="txtTelefoneContato"
					name="txtTelefoneContato"> <label for="txtCep">CEP</label>
				<input type="text" class="form-control" id="txtCep" value=""
					name="txtCep" onblur="pesquisacep(this.value)" /> <label
					for="txtLogradouro">Logradouro</label> <input type="text"
					class="form-control" id="txtLogradouro" name="txtLogradouro">

				<label for="txtNumero">Número</label> <input type="text"
					class="form-control" id="txtNumero" name="txtNumero"> <label
					for="txtComplemento">Complemento</label> <input type="text"
					class="form-control" id="txtComplemento" name="txtComplemento">

				<label for="txtBairro">Bairro</label> <input type="text"
					class="form-control" id="txtBairro" name="txtBairro"> <label
					for="txtCidade">Cidade</label> <input type="text"
					class="form-control" id="txtCidade" name="txtCidade"> <label
					for="txtEstado">Estado</label> <input type="text"
					class="form-control" id="txtEstado" name="txtEstado">
			</div>

			<div class="col-sm-9">
				<div class="col-md-6">
					<div class="text-center">
						<br />
						<button type="submit" class="btn btn-success" id="operacao"
							name="operacao" value="SALVAR">SALVAR</button>
						<a type="submit" class="btn  btn-danger"
							href="pages-fornecedor.jsp">VOLTAR</a>
					</div>
				</div>
			</div>
		</div>

	</form>
	<!-- form -->
	<hr>

	<!-- #### JAVASCRIPT FILES ### -->

	<c:import url="js-files.jsp"></c:import>
</body>
</html>