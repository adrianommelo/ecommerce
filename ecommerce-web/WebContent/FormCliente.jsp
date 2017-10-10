<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
<!-- Javascript -->
<script type="text/javascript" src="resources/js/wsViaCep.js">
	
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<h2 class="text-uppercase">Novo Cliente</h2>
				<hr>
			</div>
		</div>
		<!-- row -->
		<div class="row">
			<form class="form-group" action="SalvarCliente" method="post">
				<div class="col-md-9">
					<div class="col-md-6">
						<label for="txtNomeComp">Nome Completo</label> <input type="text"
							class="form-control" id="txtNomeComp" name="txtNomeComp">

						<label for="txtForEmail">Email</label> <input type="text"
							class="form-control" id="txtForEmail" name="txtForEmail">

						<label for="txtSenha">Senha</label> <input type="password"
							class="form-control" id="txtSenha" name="txtSenha"> <label
							for="txtConfSenha">Confirmar Senha</label> <input type="password"
							class="form-control" id="txtConfSenha" name="txtConfSenha">
						<br>

						<div class="form-group">
							<label for="txtGenero">Gênero</label> <br> <input
								type="radio" name="rdGenero" value="1" checked /> <label
								for="rdGenero"> Masculino </label> <br> <input type="radio"
								name="rdGenero" value="2" /> <label for="rdGenero">
								Feminino </label> <br> <input type="radio" name="rdGenero"
								value="3" /> <label for="rdGenero"> Não quero informar
							</label>
						</div>

						<label for="txtCPF">CPF</label> <input type="text"
							class="form-control" id="txtForEmail" name="txtCPF"> <label
							for="txtDtNascimento">Data de Nascimento</label> <input
							type="date" class="form-control" id="txtDtNascimento"
							name="txtDtNascimento"> <label for="txtTelefone">Telefone</label>
						<input type="text" class="form-control" id="txtTelefone"
							name="txtTelefone"> <br> <label for="txtEndereco">Endereço</label>
						<br> <label for="txtCEP">CEP</label> <input type="text"
							class="form-control" id="txtCEP" name="txtCEP"> <label
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
				</div>

				<div class="col-md-9">
					<div class="col-md-6">
						<div class="panel panel-default">
							<div class="panel-body" style="min-height: 100px;">
								<div class="text-center">
									<br />
									<button type="submit" class="btn btn-success" id="operacao"
										name="operacao" value="SALVAR">SALVAR</button>
									<a type="submit" class="btn  btn-danger"
										href="index.jsp">VOLTAR</a>
								</div>
							</div>
						</div>
					</div>
					
					
				</div>

			</form>
			<!-- form -->
		</div>
		<!-- row -->
	</div>
	<!-- /.container -->
</body>
</html>