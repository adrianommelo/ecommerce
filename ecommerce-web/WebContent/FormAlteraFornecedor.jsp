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
			Resultado resultado = (Resultado) session.getAttribute("resultado");
		%>
		
		<div id="content">
			<div class="container">
				<div class="row">
					

					<div class="col-md-6">
						<div class="box">
							<h2 class="text-uppercase">Alterar Fornecedor</h2>
							<hr>
							<p>Altere os dados nos campos que deseja atualizar:</p>
							<hr>
							<form action="AlterarFornecedor" method="post">
								<div class="form-group">
									<label for="txtId">Id</label> <input type="text"
										readonly="readonly" class="form-control" id="txtId"
										name="txtId" value="${resultado.entidades.get(0).id}">
								</div>
								<div class="form-group">
									<label for="txtRzSocial">Razão Social</label> <input
										type="text" class="form-control" id="txtRzSocial"
										name="txtRzSocial"
										value="${resultado.entidades.get(0).razaoSocial}">
								</div>
								<div class="form-group">
									<label for="txtEmail">Email</label> <input type="text"
										class="form-control" id="txtForEmail" name="txtForEmail"
										value="${resultado.entidades.get(0).usuario.email}">
								</div>

								<div class="form-group">
									<label for="txtCnpj">CNPJ</label> <input type="text"
										class="form-control" id="txtCnpj" name="txtCnpj"
										value="${resultado.entidades.get(0).cnpj}">
								</div>

								<div class="form-group">
									<label for="txtTelefoneContato">Telefone Contato</label> <input
										type="text" class="form-control" id="txtTelefoneContato"
										name="txtTelefoneContato"
										value="${resultado.entidades.get(0).telefone}">
								</div>

								<input type="hidden" id="txtEndId" name="txtEndId"
									value="${resultado.entidades.get(0).endereco.id}">
								<div class="form-group">
									<label for="txtCep">CEP</label> <input type="text"
										class="form-control" id="txtCep" name="txtCep"
										value="${resultado.entidades.get(0).endereco.cep}">
								</div>
								<div class="form-group">
									<label for="txtLogradouro">Logradouro</label> <input
										type="text" class="form-control" id="txtLogradouro"
										name="txtLogradouro"
										value="${resultado.entidades.get(0).endereco.logradouro}">
								</div>
								<div class="form-group">
									<label for="txtNumero">Número</label> <input type="text"
										class="form-control" id="txtNumero" name="txtNumero"
										value="${resultado.entidades.get(0).endereco.numero}">
								</div>
								<div class="form-group">
									<label for="txtComplemento">Complemento</label> <input
										type="text" class="form-control" id="txtComplemento"
										name="txtComplemento"
										value="${resultado.entidades.get(0).endereco.complemento}">
								</div>
								<div class="form-group">
									<label for="txtBairro">Bairro</label> <input type="text"
										class="form-control" id="txtBairro" name="txtBairro"
										value="${resultado.entidades.get(0).endereco.bairro}">
								</div>
								<div class="form-group">
									<label for="txtCidade">Cidade</label> <input type="text"
										class="form-control" id="txtCidade" name="txtCidade"
										value="${resultado.entidades.get(0).endereco.cidade.nome}">
								</div>
								<div class="form-group">
									<label for="txtEstado">Estado</label> <input type="text"
										class="form-control" id="txtEstado" name="txtEstado"
										value="${resultado.entidades.get(0).endereco.cidade.estado.nome}">
								</div>

								<div class="text-center">
									<button type="submit" class="btn btn-success" id="operacao"
										name="operacao" value="ALTERAR">ALTERAR</button>
									<a type="submit" class="btn  btn-danger"
										href="consult-fornecedor.jsp">VOLTAR</a>
								</div>
							</form>
						</div>
					</div>

				</div>
				<!-- /.row -->

			</div>
			<!-- /.container -->
		</div>
		<!-- /#content -->

		


	<!-- #### JAVASCRIPT FILES ### -->

	<c:import url="js-files.jsp"></c:import>

</body>
</html>