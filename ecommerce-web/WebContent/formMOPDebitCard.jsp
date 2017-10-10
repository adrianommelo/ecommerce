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

	<div class="row">



		<div class="col-md-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<p class="lead">Formulário Cartão de Débito</p>
					<div class="col-md-6">
						<label class="lead" for="txtNomeTitular">Nome</label> <input
							type="text" class="form-control" id="txtNomeTitular"
							name="txtNomeTitular">

					</div>
					<div class="col-md-6">
						<label class="lead" for="txtSobrenomeTitular">Sobrenome</label> <input
							type="text" class="form-control" id="txtSobrenomeTitular"
							name="txtSobrenomeTitular">
					</div>


					<div class="col-md-6">
						<label class="lead" for="txtNumCartao">Número Cartão</label> <input
							type="text" class="form-control" id="txtNumCartao"
							name="txtNumCartao">
					</div>


					<div class="col-md-6">
						<div class="col-md-6">
							<label class="lead" for="slDtValCartaoMes">Data de
								validade (Mês)</label> <select name="slDtValCartaoMes"
								class="form-control" id="slDtValCartaoMes">
								<option value="1">Jan (1)</option>
								<option value="2">Fev (2)</option>
								<option value="3">Mar (3)</option>
								<option value="4">Abr (4)</option>
								<option value="5">Mai (5)</option>
								<option value="6">Jun (6)</option>
								<option value="7">Jul (7)</option>
								<option value="8">Ago (8)</option>
								<option value="9">Set (9)</option>
								<option value="10">Out (10)</option>
								<option value="11">Nov (11)</option>
								<option value="12">Dez (12)</option>

							</select>
						</div>
						<div class="col-md-6">
							<label class="lead" for="slDtValCartaoAno">Data de
								validade (Ano)</label> <select name="slDtValCartaoAno"
								class="form-control" id="slDtValCartaoAno">
								<option value="2017">2017</option>
								<option value="2016">2016</option>
								<option value="2015">2015</option>
								<option value="2014">2014</option>
								<option value="2013">2013</option>
								<option value="2012">2012</option>
								<option value="2011">2011</option>
								<option value="2010">2010</option>
								<option value="2009">2009</option>
								<option value="2008">2008</option>
								<option value="2007">2007</option>
								<option value="2006">2006</option>

							</select>
						</div>

					</div>

					<div class="col-md-6">
						<label class="lead" for="txtCodCartao">Cód. Cartão</label> <input
							type="text" class="form-control" id="txtCodCartao"
							name="txtCodCartao">
					</div>

					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="text-center pull-right">
									<a href="order-conclusion.jsp" class="btn btn-success"> Finalizar
										compra <i class="fa fa-chevron-right"></i>
									</a>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>



	</div>
	<!-- row -->
	<div class="row"></div>
	<!-- row -->

</body>
</html>