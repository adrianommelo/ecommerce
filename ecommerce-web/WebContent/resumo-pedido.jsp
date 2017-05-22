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

		<div class="col-md-6">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="lead">Resumo pedido</div>
						<div id="order-summary">
							<div class="header">
								<h4>Sumário Pedido</h4>
							</div>

							<div class="table-responsive">
								<table class="table">
									<tbody>
										<tr>
											<td>Subtotal</td>
											<th>R$ 2100.00</th>
										</tr>
										<tr>
											<td>Frete</td>
											<th>R$ 10.00</th>
										</tr>
										<tr class="total">
											<td>Total</td>
											<th>R$ 2110.00</th>
										</tr>
									</tbody>
								</table>
							</div>

						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<a type="submit" class="btn btn-warning" href="shop-cart.jsp">
							Alterar pedido</a>
					</div>
				</div>
			</div>
		</div>
		<!-- resumo do pedido -->

		<div class="col-md-6">

			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="lead">Endereço de entrega</div>
						<div class="text-muted">
							Nome Cliente: Adriano Marinho de Melo<br> Rua josé Guilher
							Pagnani, nº 860<br> Vila Figueira - Suzano, SP<br> CEP
							08676200<br> Apt. 202, Bloco 05<br>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-body">
						<a type="submit" class="btn btn-success" href="shop-cart.jsp">
							Alterar endereço</a>
					</div>
				</div>
			</div>

		</div>
		<!-- endereco -->

		<div class="col-md-12">
			<div class="panel ">
				<div class="panel-body">
					<p class="lead">Forma de Pagamento</p>
					<hr>
					<div class="col-md-4">
						<div class="panel panel-list">
							<div class="panel-body">
								<i class="fa fa-credit-card fa-3x fa-lg"></i>
								<input type="radio" name="payment" value="paymentCreditCard">
								Cartão de Credito 
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-list">
							<div class="panel-body">
								<i class="fa fa-credit-card fa-3x fa-lg"></i>
								<input type="radio" name="payment" value="paymentDebitCard">
								Débito 
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="panel panel-list">
							<div class="panel-body">
								<i class="fa fa-file-text fa-3x fa-lg"></i>
								<input type="radio" name="payment" value="paymentPaper">
								Boleto 
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<!-- opcao de pagamento -->
		<hr>
		
		<div class="col-md-12">
			<div class="panel ">
				<div class="panel-body">
					
					<c:import url="formMOPCreditCard.jsp"></c:import>

				</div>
			</div>
		</div>
		<!-- forms meio de pagamento -->
		
		
		<hr>
		
		<div class="col-md-12">
			<div class="panel ">
				<div class="panel-body">
					
					<c:import url="formMOPDebitCard.jsp"></c:import>

				</div>
			</div>
		</div>
		<!-- forms meio de pagamento -->

		<hr>
		
		<div class="col-md-12">
			<div class="panel ">
				<div class="panel-body">
					
					<c:import url="formMOPPaymentPaper.jsp"></c:import>

				</div>
			</div>
		</div>
		<!-- forms meio de pagamento -->
	</div>
	<!-- row -->
	<div class="row"></div>
	<!-- row -->

</body>
</html>