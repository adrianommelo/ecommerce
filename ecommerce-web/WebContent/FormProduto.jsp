<%@page import="ecommerce.core.util.ConverteDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
    import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>:::: CADASTRO DE PRODUTO::::</title>
</head>
<body>

	<%
		Produto produto = (Produto) request.getAttribute("produto");
	%>

	<form action="SalvarProduto" method="post">
		<label for="txtId">Id:</label> <input type="text" id="txtId"
			name="txtId"
			value=<%if (produto != null)
				out.print("'" + produto.getId() + "' readonly>");
			else
				out.print(">");%></input>


		</br> <label for="txtDescricao">Descrição:</label> <input type="text"
			id="txtDescricao" name="txtDescricao"
			value=<%if (produto != null)
				out.print("'" + produto.getDescricao() + "'>");
			else
				out.print(">");%></input>

		<label for="txtQtd">Quantidade:</label> <input type="text" id="txtQtd"
			name="txtQtd"
			value=<%if (produto != null)
				out.print("'" + produto.getQuantidade() + "'>");
			else
				out.print(">");%></input>



		<%
			if (produto != null) {
				String dtCadastro = ConverteDate.converteDateString(produto.getDtCadastro());
				out.print("<label for='txtDtCadastro'>Data de Cadastro:</label>");
				out.print("<input type='text' id='txtDtCadastro' name='txtDtCadastro' value='" + dtCadastro
						+ "' readonly>");
			}
		%>

		</input>


		<%
			if (produto != null) {
				out.print("<input type='submit' id='operacao' name='operacao' value='ALTERAR'/>");
				out.print("<input type='submit' id='operacao' name='operacao' value='EXCLUIR'/>");
			} else {
				out.print("<input type='submit' id='operacao' name='operacao' value='SALVAR'/>");
			}
		%>


	</form>
</body>
</html>