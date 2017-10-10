<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,500,700,800'
	rel='stylesheet' type='text/css'>

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

<title>Alterar Fornecedor</title>
</head>
<body>

	<%
		Resultado resultado = (Resultado) request.getAttribute("resultado");
	%>

	<div id="content">
		<div class="container">

			<form action="AlterarProduto" method="post">
				<div class="col-sm-9">

					<div class="col-md-6">

						<h2 class="text-uppercase">Alterar Produto</h2>
						<hr>
						<div class="col-md-12">
							<div class="col-md-2"></div>
							<div class="col-md-8">
								<div class="bg-success text-success">
									<c:if test="${resultado.msg != null}">
										<h4 class="text-uppercase">${resultado.msg }
											<i class="fa fa-chevron-right"></i>
										</h4>
									</c:if>
								</div>
							</div>
							<div class="col-md-2"></div>
						</div>
						<hr>
						<hr>
						<p>Altere os dados nos campos que deseja atualizar:</p>
						<div class="form-group">
							<label for="txtId">Id</label> <input type="text"
								readonly="readonly" class="form-control" id="txtId" name="txtId"
								value="${resultado.entidades.get(0).id}">
						</div>
						<label for="txtNomeProd">Nome</label> <input type="text"
							class="form-control" id="txtNomeProd" name="txtNomeProd"
							value="${resultado.entidades.get(0).nome}"> <label
							for="txtDescProd">Descrição</label> <input type="text"
							class="form-control" id="txtDescProd" name="txtDescProd"
							value="${resultado.entidades.get(0).descricao}"> <label
							for="txtPrecoProd">Preço</label> <input type="text"
							class="form-control" id="txtPrecoProd" name="txtPrecoProd"
							value="${resultado.entidades.get(0).preco}"> <label
							for="txtQtdProd">Quantidade</label> <input type="text"
							class="form-control" id="txtQtdProd" name="txtQtdProd"
							value="${resultado.entidades.get(0).quantidade}"> <label
							for="cmbCategoria">Categoria</label> <select class="form-control"
							id="cmbCategoria" name="cmbCategoria">
							<c:forEach var="categoria"
								items="${resultado.entidades.get(0).categorias}">
								<option value="${categoria.id}" selected="selected">${categoria.categoria}</option>
							</c:forEach>

						</select> <label for="cmbFornecedor">Fornecedor</label> <select
							class="form-control" id="cmbFornecedor" name="cmbFornecedor">
							<c:if test="${resultado.entidades.get(0).fornecedores != null}">
								<c:forEach var="fornecedores"
									items="${resultado.entidades.get(0).fornecedores}">
									<option value="${fornecedores.id}" selected="selected">${fornecedores.razaoSocial}</option>
								</c:forEach>
							</c:if>
						</select><input type="text" class="form-control" id="txtFornecedor"
							name="txtFornecedor"
							value="${resultado.entidades.get(0).fornecedor.id}" /> <label
							for="txtPesoProd">Peso</label> <input type="text"
							class="form-control" id="txtPesoProd" name="txtPesoProd"
							value="${resultado.entidades.get(0).peso}"> <label
							for="txtComprimentoProd">Comprimento</label> <input type="text"
							class="form-control" id="txtComprimentoProd"
							name="txtComprimentoProd"
							value="${resultado.entidades.get(0).comprimento}"> <label
							for="txtAlturaProd">Altura</label> <input type="text"
							class="form-control" id="txtAlturaProd" name="txtAlturaProd"
							value="${resultado.entidades.get(0).altura}"> <label
							for="txtLarguraProd">Largura</label> <input type="text"
							class="form-control" id="txtLarguraProd" name="txtLarguraProd"
							value="${resultado.entidades.get(0).largura}"> <label
							for="txtDiametroProd">Diametro</label> <input type="text"
							class="form-control" id="txtDiametroProd" name="txtDiametroProd"
							value="${resultado.entidades.get(0).diametro}"> <label
							for="cmbFormatoProd">Formato</label> <select class="form-control"
							id="cmbFormatoProd" name="cmbFormatoProd"
							value="${resultado.entidades.get(0).formato.id}">
							<option value="1" selected="selected">Caixa</option>
							<option value="2">Envelope</option>
						</select> <br />
						<div class="text-center">
							<button type="submit" class="btn btn-success" id="operacao"
								name="operacao" value="ALTERAR">ALTERAR</button>
							<a type="submit" class="btn  btn-danger"
								href="consult-produto.jsp">VOLTAR</a>
						</div>
					</div>
				</div>
			</form>

		</div>
		<!-- /.container -->
	</div>
	<!-- /#content -->
</body>
</html>