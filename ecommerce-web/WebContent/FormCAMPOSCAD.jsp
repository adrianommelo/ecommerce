<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<link href="resources/css/style.default.css" rel="stylesheet"
	id="theme-stylesheet">

<!-- Custom stylesheet - for your changes -->
<link href="resources/css/custom.css" rel="stylesheet">
<title>Novo Fornecedor</title>
</head>
<body>
	<div id="content">
		<div class="container">

			<div class="row">
				<div class="col-md-6">
					<div class="box">
						<h2 class="text-uppercase">Novo Fornecedor</h2>
						<hr>
						<form action="SalvarFornecedor" method="post">
							<div class="form-group">
								<label for="txtRzSocial">Razão Social</label> <input type="text"
									class="form-control" id="txtRzSocial" name="txtRzSocial">
							</div>
							<div class="form-group">
								<label for="txtEmail">Email</label> <input type="text"
									class="form-control" id="txtEmail" name="txtEmail">
							</div>
							<div class="form-group">
								<label for="txtSenha">Senha</label> <input type="password"
									class="form-control" id="txtSenha" name="txtSenha">
							</div>
							<div class="form-group">
								<label for="txtConfirmarSenha">Confirmar Senha</label> <input
									type="password" class="form-control" id="txtConfirmarSenha"
									name="txtConfirmarSenha">
							</div>

							<div class="text-center">
								<input type="radio" name="rdGenero" value="1" checked /> <label
									for="rdGenero"> Feminino </label> <input type="radio"
									name="rdGenero" value="2" /> <label for="rdGenero">
									Masculino </label> <input type="radio" name="rdGenero" value="3" /> <label
									for="rdGenero"> Outro </label>
							</div>

							<div class="form-group">
								<label for="txtCnpj">CNPJ</label> <input type="text"
									class="form-control" id="txtCnpj" name="txtCnpj">
							</div>
							<div class="form-group">
								<label for="txtDtNascimento">Data Nascimento</label> <input
									type="text" class="form-control" id="txtDtNascimento"
									name="txtDtNascimento">
							</div>
							<div class="form-group">
								<label for="txtTelefoneContato">Telefone Contato</label> <input
									type="text" class="form-control" id="txtTelefoneContato"
									name="txtTelefoneContato">
							</div>
							<div class="form-group">
								<label for="txtCep">CEP</label> <input type="text"
									class="form-control" id="txtCep" name="txtCep">
							</div>
							<div class="form-group">
								<label for="txtLogradouro">Logradouro</label> <input type="text"
									class="form-control" id="txtLogradouro" name="txtLogradouro">
							</div>
							<div class="form-group">
								<label for="txtNumero">Número</label> <input type="text"
									class="form-control" id="txtNumero" name="txtNumero">
							</div>
							<div class="form-group">
								<label for="txtComplemento">Complemento</label> <input
									type="text" class="form-control" id="txtComplemento"
									name="txtComplemento">
							</div>
							<div class="form-group">
								<label for="txtBairro">Bairro</label> <input type="text"
									class="form-control" id="txtBairro" name="txtBairro">
							</div>
							<div class="form-group">
								<label for="txtCidade">Cidade</label> <input type="text"
									class="form-control" id="txtCidade" name="txtCidade">
							</div>
							<div class="form-group">
								<label for="txtEstado">Estado</label> <input type="text"
									class="form-control" id="txtEstado" name="txtEstado">
							</div>

							<div class="text-center">
								<button type="submit" class="btn btn-template-main"
									id="operacao" name="operacao" value="SALVAR">
									SALVAR
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