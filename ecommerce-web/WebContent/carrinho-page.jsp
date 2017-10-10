<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
    import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>
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

	<div class="row">



		<div class="col-md-12 clearfix" id="basket">



			<form method="post" action="shop-checkout1.html">

				<div class="table-responsive">
					<table class="table">
						<thead>
							<tr>
								<th colspan="2">Produto</th>
								<th>Quantidade</th>
								<th>Data entrega</th>
								<th>Valor Unitário</th>
								<th colspan="2">Total</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><a href="product-detail.jsp"> <img
										src="resources/img/motog4_play_md.png" alt="">
								</a></td>
								<td><a href="product-detail.jsp">Smartphone Moto G4
										Plus</a></td>
								<td><input type="number" value="2" class="form-control">
								</td>
								<td>dd/mm/aaaa</td>
								<td>R$700.00</td>
								<td>R$1400.00</td>
								<td><a href="#"><i class="fa fa-trash-o"></i></a></td>
							</tr>
							<tr>
								<td><a href="product-detail.jsp"> <img
										src="resources/img/motog4_play_md.png" alt="">
								</a></td>
								<td><a href="product-detail.jsp">Smartphone Moto G4
										Plus</a></td>
								<td><input type="number" value="1" class="form-control">
								</td>
								<td>dd/mm/aaaa</td>
								<td>R$700.00</td>
								<td>R$700.00</td>
								<td><a href="#"><i class="fa fa-trash-o"></i></a></td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<th colspan="5">Total</th>
								<th colspan="2">R$2100.00</th>
							</tr>
						</tfoot>
					</table>

				</div>
				<!-- /.table-responsive -->

			</form>


			<!-- /.box -->

		<hr>
		</div>
		<!-- /.col-md-12 -->

		

		<div class="col-md-8">

			<div class="panel ">
				<div class="panel-body">
					<div class="col-md-6">
						<label for="txtCalcFrete">Calcular Frete</label> <input
							type="text" class="form-control" id="txtCalcFrete"
							name="txtCalcFrete">
					</div>
					<div class="col-md-6">
						<div class="panel ">
							<div class="panel-body">
								<a type="submit" class="btn btn-info" href="#"> Calcular</a>
							</div>
						</div>
					</div>


					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-body">
								<p class="lead">
									Opções de frete:<br><br> 
									<input type="radio" name="frete" value="pac" checked> Pac - 6 dias úteis - R$ 10.00<br> 
									<input type="radio"
										name="frete" value="sedex"> Sedex - 4 dias úteis - R$ 14.00<br> 
								</p>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>

		<div class="col-md-4">

			<div class="panel ">
				<div class="panel-body">


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
			<div class="panel ">
				<div class="panel-body">
					<div class="pull-left">
						<a href="index.jsp" class="btn btn-default"><i
							class="fa fa-chevron-left"></i> Continuar comprando</a>
					</div>
					<div class="pull-right">

						<a href="order-review.jsp" class="btn btn-success">
							Finalizar compra <i class="fa fa-chevron-right"></i>
						</a>
					</div>
				</div>
			</div>
		</div>

		<hr>

	</div>
	<!-- row -->
	<div class="row"></div>
	<!-- row -->

</body>
</html>