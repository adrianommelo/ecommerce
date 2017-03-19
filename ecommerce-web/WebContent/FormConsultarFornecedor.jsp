<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
<title>Fornecedor</title>
</head>
<body>
	<div id="content">
		<div class="container">

			<form action="ConsultarFornecedor" method="post">
				<div class="form-group">
					<div class="row">
						<div class="box">
							<div class="col-md-10">
								<h2 class="text-uppercase">Consultar Fornecedor</h2>
								<hr>
								<p>Consulte o Fornecedor através de um dos campos abaixo:</p>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="box">
							<div class="col-md-1">
								<label for="txtId">Id</label>
							</div>
							<div class="col-md-4">
								<label for="txtRzSocial">Razão Social</label>
							</div>
							<div class="col-md-3">
								<label for="txtCnpj">CNPJ</label>
							</div>
						</div>
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="box">
							<div class="col-md-1">
								<input type="text" class="form-control" id="txtId" name="txtId" />
							</div>
							<div class="col-md-4">
								<input type="text" class="form-control" id="txtRzSocial"
									name="txtRzSocial" />
							</div>
							<div class="col-md-3">
								<input type="text" class="form-control" id="txtCnpj"
									name="txtCnpj" />
							</div>

							<div class="col-md-1">
								<button type="submit" class="btn btn-template-main"
									id="operacao" name="operacao" value="CONSULTAR">CONSULTAR</button>
							</div>

						</div>
					</div>
					<!-- /.row -->




					<!-- /.row -->
				</div>
			</form>
			<div class="form-group">
				<div class="row">
					<div class="box">
						<div class="col-md-10">
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div><!-- /.container -->
		
	</div><!-- /#content -->

	<c:import url="ListaFornecedor.jsp" />


</body>
</html>