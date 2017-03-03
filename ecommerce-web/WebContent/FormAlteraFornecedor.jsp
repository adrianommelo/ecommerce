<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page
	import="ecommerce.core.aplicacao.Resultado, ecommerce.dominio.*, java.util.*"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<title>Alterar Fornecedor</title>
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
						<h3 class="text-uppercase">Altere os dados nos campos que deseja atualizar: </h3>
						<hr>
						<form action="AlterarFornecedor" method="post" >
							<div class="form-group">
								<label for="txtRzSocial">Id</label> <input type="text" disabled="disabled"
									class="form-control" id="txtRzSocial" name="txtRzSocial" value="${resultado.entidades.get(0).id}">
							</div>
							<div class="form-group">
								<label for="txtRzSocial">Razão Social</label> <input type="text"
									class="form-control" id="txtRzSocial" name="txtRzSocial" value="${resultado.entidades.get(0).razaoSocial}">
							</div>
							<div class="form-group">
								<label for="txtEmail">Email</label> <input type="text"
									class="form-control" id="txtEmail" name="txtEmail" value="${resultado.entidades.get(0).usuario.email}">
							</div>
						
							<div class="form-group">
								<label for="txtCnpj">CNPJ</label> <input type="text"
									class="form-control" id="txtCnpj" name="txtCnpj" value="${resultado.entidades.get(0).cnpj}">
							</div>
							
							<div class="form-group">
								<label for="txtTelefoneContato">Telefone Contato</label> <input
									type="text" class="form-control" id="txtTelefoneContato"
									name="txtTelefoneContato" value="${resultado.entidades.get(0).telefone}">
							</div>
							<div class="form-group">
								<label for="txtCep">CEP</label> <input type="text"
									class="form-control" id="txtCep" name="txtCep" value="${resultado.entidades.get(0).endereco.cep}">
							</div>
							<div class="form-group">
								<label for="txtLogradouro">Logradouro</label> <input type="text"
									class="form-control" id="txtLogradouro" name="txtLogradouro" value="${resultado.entidades.get(0).endereco.logradouro}">
							</div>
							<div class="form-group">
								<label for="txtNumero">Número</label> <input type="text"
									class="form-control" id="txtNumero" name="txtNumero" value="${resultado.entidades.get(0).endereco.numero}">
							</div>
							<div class="form-group">
								<label for="txtComplemento">Complemento</label> <input
									type="text" class="form-control" id="txtComplemento"
									name="txtComplemento" value="${resultado.entidades.get(0).endereco.complemento}">
							</div>
							<div class="form-group">
								<label for="txtBairro">Bairro</label> <input type="text"
									class="form-control" id="txtBairro" name="txtBairro">
							</div>
							<div class="form-group">
								<label for="txtCidade">Cidade</label> <input type="text"
									class="form-control" id="txtCidade" name="txtCidade" value="${resultado.entidades.get(0).endereco.cidade.nome}">
							</div>
							<div class="form-group">
								<label for="txtEstado">Estado</label> <input type="text"
									class="form-control" id="txtEstado" name="txtEstado" value="${resultado.entidades.get(0).endereco.cidade.estado.nome}">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-template-main"
									id="operacao" name="operacao" value="ALTERAR">
									ALTERAR
								</button>
								<button type="submit" class="btn btn-template-main">
									<a href="ListaClientes.jsp" >VOLTAR</a>
								</button>
								
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
</body>
</html>