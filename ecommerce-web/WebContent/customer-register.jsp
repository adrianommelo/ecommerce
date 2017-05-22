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

<!-- Favicon and apple touch icons-->
<link rel="shortcut icon"
	href="resources/img/512px-Gift_font_awesome.png" type="image/x-icon">
<link rel="apple-touch-icon" href="resources/img/apple-touch-icon.png">
<link rel="apple-touch-icon" sizes="57x57"
	href="resources/img/apple-touch-icon-57x57.png">
<link rel="apple-touch-icon" sizes="72x72"
	href="resources/img/apple-touch-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76"
	href="resources/img/apple-touch-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114"
	href="resources/img/apple-touch-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120"
	href="resources/img/apple-touch-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144"
	href="resources/img/apple-touch-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152"
	href="resources/img/apple-touch-icon-152x152.png">
</head>

<body>
	<div id="all">

		<header> <!-- *** TOP ***
_________________________________________________________ -->
		<div id="top">
			<div class="container">
				<div class="row">
					<div class="col-xs-9 contact">
						<div class="col-xs-4 contact">
							<a type="submit" href="index.jsp"><i class="fa fa-home"></i><span
								class="hidden-xs text-uppercase">Home</span></a>
						</div>

					</div>
					<div class="col-xs-3">
						<div class="login">
							<a href="#" data-toggle="modal" data-target="#login-modal"><i
								class="fa fa-sign-in"></i><span class="hidden-xs text-uppercase">Login</span></a>
							<a href="customer-register.html"><i class="fa fa-user"></i><span
								class="hidden-xs text-uppercase">Registrar</span></a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- *** TOP END *** --> <!-- *** NAVBAR ***
    _________________________________________________________ -->

		<div class="navbar-affixed-top affix-top" data-spy="affix"
			data-offset-top="200">


			<!-- /#navbar -->

		</div>

		<!-- *** NAVBAR END *** --> </header>

		<!-- *** LOGIN MODAL ***
_________________________________________________________ -->

		<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
			aria-labelledby="Login" aria-hidden="true">
			<div class="modal-dialog modal-sm">

				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title" id="Login">Login Usuário</h4>
					</div>
					<div class="modal-body">
						<form action="customer-orders.html" method="post">
							<div class="form-group">
								<input type="text" class="form-control" id="email_modal"
									placeholder="email">
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="password_modal"
									placeholder="password">
							</div>

							<p class="text-center">
								<button class="btn btn-template-main">
									<i class="fa fa-sign-in"></i>Acessar
								</button>
							</p>

						</form>

					</div>
				</div>
			</div>
		</div>

		<!-- *** LOGIN MODAL END *** -->


		<!-- **CONTENT AND CONTAINER**
_________________________________________________________ -->

		<div id="content">
			<div class="container">

				<div class="row">
					<div class="col-md-6">
						<div class="box">
							<div class="panel panel-default">
								<div class="panel-body min-area">
									<h2 class="text-uppercase">Já tenho cadastro</h2>
									<hr>

									<form action="customer-orders.html" method="post">
										<div class="form-group">
											<label for="email">Email</label> <input type="text"
												class="form-control" id="email">
										</div>
										<div class="form-group">
											<label for="password">Password</label> <input type="password"
												class="form-control" id="password">
										</div>
										<div class="text-center">
											<a type="submit" class="btn btn-template-main"
												href="index-cliente-logado.jsp"><i class="fa fa-sign-in"></i>
												Acessar</a>
										</div>
									</form>

								</div>
							</div>
						</div>
					</div>

					<div class="col-md-6">
						
							<div class="panel panel-default">
								<div class="panel-body ">
									<h2 class="text-uppercase">Nova conta</h2>
									<hr>
									<p class="text-muted">
										Se houve alguma dúvida, sinta-se a vontade em <a
											href="contact.html">nos contatar</a>, nossos serviços ocorrem
										em escala 24/7.
									</p>

									<hr>


									<div class="text-center">
										<a type="submit" class="btn btn-template-main"
											href="novoCliente1.jsp"><i class="fa fa-user-md"></i>
											Registrar-se</a>

									</div>
								</div>
							</div>
						
					</div>
				</div>
				<!-- /.row -->

			</div>
			<!-- /.container -->
		</div>
		<!-- /#content -->
		<!-- END **CONTENT AND CONTAINER
_________________________________________________________ -->

		<!-- *** FOOTER ***
_________________________________________________________ -->
		<div id="footer">
			<div class="container">
				<div class="col-md-12">
					<p class="pull-left">© 2015. Ecomm AAAA Ltda / Adriano Melo</p>
					<p class="pull-right">
						Template by <a href="https://bootstrapious.com">Bootstrapious</a>
						&amp; <a href="https://remoteplease.com">Remote Please</a>
						<!-- Not removing these links is part of the license conditions of the template. Thanks for understanding :) If you want to use the template without the attribution links, you can do so after supporting further themes development at https://bootstrapious.com/donate  -->
					</p>
				</div>
			</div>
		</div>
		<!-- /#footer -->

		<!-- *** FOOTER END *** -->

	</div>
	<!-- /#all -->


	<!-- #### JAVASCRIPT FILES ### -->

	<script src="resources/js/jquery-1.11.0.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="resources/js/jquery-1.11.0.min.js"><\/script>')
	</script>
	<script src="resources/js/bootstrap.min.js"></script>

	<script src="resources/js/jquery.cookie.js"></script>
	<script src="resources/js/waypoints.min.js"></script>
	<script src="resources/js/jquery.counterup.min.js"></script>
	<script src="resources/js/jquery.parallax-1.1.3.js"></script>
	<script src="resources/js/front.js"></script>
</body>
</html>