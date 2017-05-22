<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ page
	import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

</head>

<body>
	<div class="row">
		<form class="form-group" action="AlterarCliente" method="post">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<h2 class="text-">Alterar meus dados de acess</h2>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="col-md-6">
						<label class="lead" for="txtForEmail">Email</label> <input type="text"
							class="form-control" id="txtForEmail" name="txtForEmail">
						<label class="lead" for="txtForEmail">Confirmar Email</label> 
						<input type="text"
							class="form-control" id="txtForEmail" name="txtForEmail" />

						<label class="lead" for="txtSenha">Senha</label> <input type="password"
							class="form-control" id="txtSenha" name="txtSenha" /> <label class="lead" 
							for="txtConfSenha">Confirmar Senha</label> <input type="password"
							class="form-control" id="txtConfSenha" name="txtConfSenha" />
						<br>
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
								<a type="submit" class="btn  btn-danger" href="user-profile-update.jsp">VOLTAR</a>
							</div>
						</div>
					</div>
				</div>
			</div>

		</form>
		<!-- form -->
	</div>
	<!-- row -->
</body>
</html>