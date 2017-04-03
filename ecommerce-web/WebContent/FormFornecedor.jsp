<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
				<h2 class="text-uppercase">Novo Fornecedor</h2>
				<hr>
			</div>
		</div>
		<!-- row -->
		<div class="row">
			<form class="form-group" action="SalvarFornecedor" method="post">
				<div class="col-md-9">
					<div class="col-md-6">
						<label for="txtRzSocial">Razão Social</label> <input type="text"
							class="form-control" id="txtRzSocial" name="txtRzSocial">

						<label for="txtForEmail">Email</label> <input type="text"
							class="form-control" id="txtForEmail" name="txtForEmail">

						<label for="txtCnpj">CNPJ</label> <input type="text"
							class="form-control" id="txtCnpj" name="txtCnpj"> <label
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
				</div>

				<div class="col-md-9">
					<div class="col-md-6">
						<div class="text-center">
							<br />
							<button type="submit" class="btn btn-success" id="operacao"
								name="operacao" value="SALVAR">SALVAR</button>
							<a type="submit" class="btn  btn-danger"
								href="FormConsultarFornecedor.jsp">VOLTAR</a>
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