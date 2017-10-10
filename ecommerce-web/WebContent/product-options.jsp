<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="col-sm-9">

		<hr>
		<div class="col-sm-6">
			<div class="box">
				<div class="panel panel-default">
					<div class="painel-body min-area ">
						<form action="MontarProduto" method="post">
							<div class="text-center">
								<p class="lead">Cadastrar novo</p>
								<a href="/ecommerce-web/MontarProduto?operacao=MONTAR"
									class="btn btn-success">Acessar <i
									class="fa fa-chevron-right"></i>
									<!--<a href="new-produto.jsp" class="btn btn-success" > Acessar <i
									class="fa fa-chevron-right">--></i>
								</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<div class="col-sm-6">
			<div class="box">
				<div class="panel panel-default">
					<div class="painel-body min-area ">
						<div class="text-center">
							<p class="lead">Consultar</p>
							<a href="consult-produto.jsp" class="btn btn-success">
								Acessar <i class="fa fa-chevron-right"></i>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		

		<!-- *** RIGHT COLUMN END *** -->

	</div>
	<!-- /.col-md-9 -->
</body>
</html>