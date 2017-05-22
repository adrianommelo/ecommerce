<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<p class="lead">Formulário pagamento via Boleto</p>
					<p class="lead">
						Clique em <strong>Gerar boleto</strong> para conseguir imprimir o
						boleto referente a esta compra. <strong>Somente após ter
							seu boleto gerado</strong> você deve proceguir pra a <strong>finalização
							da compra</strong>.
					</p>
					<p>
						Caso tenha alguma dificuldade em gerar seu boleto, ou encontre
						algum problema durante a geração do mesmo, por favor <a href="#">entre
							em contato conosco</a>! <br>Agradecemos a preferencia e boas
						compras!
					</p>

					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="text-center text-upper ">
									<a href="order-review.jsp" class="btn btn-success"> Gerar
										Boleto <i class="fa fa-file-text"></i>
									</a>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<div class="text-center pull-right">
									<a href="order-conclusion.jsp" class="btn btn-success">
										Finalizar compra <i class="fa fa-chevron-right"></i>
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