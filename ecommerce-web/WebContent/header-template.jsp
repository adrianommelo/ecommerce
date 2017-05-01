<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header> <!-- *** TOP ***
_________________________________________________________ -->
	<div id="top">
		<div class="container">
			<div class="row">
				<div class="col-xs-9 contact">
					<div class="col-xs-3 ">
						<a type="submit" href="index.jsp"><i class="fa fa-home"></i><span
							class="hidden-xs text-uppercase">Home</span></a>
					</div>
					<div class="col-xs-4 "></div>
					<div class="col-xs-5 ">
						<div class="col-md-1"></div>
						<div class="col-md-1"></div>
						<div class="col-md-1"></div>
						<div class="col-md-1"></div>
						<div class="col-md-1 pull-right">
							<div class="text-center">
								<a href="shop-cart.jsp"><i
									class="fa fa-shopping-cart fa-2x fa-lg"></i></a>
							</div>
						</div>
					</div>
				</div>
				<div class="col-xs-3">
					<div class="login">
						<a href="#" data-toggle="modal" data-target="#login-modal"><i
							class="fa fa-sign-in"></i><span class="hidden-xs text-uppercase">Login</span></a>
						<a href="customer-register.jsp"><i class="fa fa-user"></i><span
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
</body>
</html>