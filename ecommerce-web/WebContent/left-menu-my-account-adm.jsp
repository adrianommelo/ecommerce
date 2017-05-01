<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- *** LEFT COLUMN ***
			_________________________________________________________ -->

	<div class="col-sm-3">

		<!-- *** MENUS AND FILTERS ***-->
		<div class="panel panel-default sidebar-menu">

			<div class="panel-heading">
				<h3 class="panel-title">Menu</h3>
			</div>

			<div class="panel-body">
				<ul class="nav nav-pills nav-stacked category-menu">
					<li class="active"><ul></ul></li>
					<li><a href="#"> Minha Conta</a>
						<ul>
							<li><a href="user-profile-update.jsp">Atualizar dados</a></li>
							<li><a href="user-account-cancel.jsp">Cancelar conta</a></li>
						</ul></li>
					<li><a href="pages-users.jsp">Gestão de Usuários</a></li>
					<li><a href="pages-fornecedor.jsp">Gestão de Fornecedores</a></li>
					<li><a href="pages-produto.jsp">Gestão de Produtos</a></li>
					<li><a href="pages-estoque.jsp">Gestão de Estoques</a></li>
					<li><a href="pages-analise.jsp">Gestão de Análises</a></li>
					<li><a href="#">Contato</a>
						<ul>
							<li><a href="contact-us.jsp">Atendimento</a></li>
							<li><a href="faq.jsp">FAQ</a></li>
						</ul></li>

				</ul>

			</div>
		</div>
		<!-- *** MENUS AND FILTERS END *** -->
	</div>
</body>
</html>