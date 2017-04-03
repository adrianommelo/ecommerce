<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<div class="container">
		<div class="row">
			<div class="col-md-9">
				<h2 class="text-uppercase">Novo Produto</h2>
				<hr>
			</div>
		</div>
		<!-- row -->
		<div class="row">
			<form class="form-group" action="SalvarProduto" method="post">
				<div class="col-md-9">
					<div class="col-md-6">
						<label for="txtNomeComp">Nome</label> <input type="text"
							class="form-control" id="txtNomeComp" name="txtNomeComp">
						
						<label for="txtDescricao">Descrição</label> <input type="text"
							class="form-control" id="txtDescricao" name="txtDescricao">
						
						<label for="txtFornecedor">Fornecedor</label> 
						<select name="slFornecedor" class="form-control" id="slFornecedor">
							<option value="Fornecedor 1">Fornecedor 1</option>
							<option value="Fornecedor 2">Fornecedor 2</option>
							<option value="Fornecedor 3">Fornecedor 3</option>
						</select>
						
						<label for="txtQuantidade">Quantidade</label> <input type="text"
							class="form-control" id="txtQuantidade" name="txtQuantidade">
						
						<label for="txtPreco">Preço</label> <input type="text"
							class="form-control" id="txtPreco" name="txtPreco"><br>
						
						
						<label for="txtImagem">Imagem</label><br>
						<input type="file" name="flImagem" accept=image/*"><br>
						
						<label for="txtCaracteristicas">Características</label><br>
						<label for="txtPeso">Peso</label> <input type="text"
							class="form-control" id="txtPeso" name="txtPeso">
							
						<label for="txtComprimento">Comprimento</label> <input type="text"
							class="form-control" id="txtComprimento" name="txtComprimento">
						
						<label for="txtAltura">Altura</label> <input type="text"
							class="form-control" id="txtAltura" name="txtAltura">
						
						<label for="txtLargura">Largura</label> <input type="text"
							class="form-control" id="txtLargura" name="txtLargura">
						
						<label for="txtDiametro">Diâmetro</label> <input type="text"
							class="form-control" id=""txtDiametro"" name=""txtDiametro"">											 						
					</div>
				</div>

				<div class="col-md-9">
					<div class="col-md-6">
						<div class="text-center">
							<br />
							<button type="submit" class="btn btn-success" id="operacao"
								name="operacao" value="SALVAR">SALVAR</button>
							<a type="submit" class="btn  btn-danger"
								href="FormConsultarCliente.jsp">VOLTAR</a>
						</div>
					</div>
				</div>

			</form>
			<!-- form -->
		</div>
		<!-- row -->
	</div>
	<!-- /.container -->
</body>
</html>