<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<%@ page
    import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Ecommerce Produtos Eletrônicos</title>
</head>
<body>
	<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
	%>
	<form action="login" method="post">
		Email: <input type="text" name="txtEmail" /> Senha: <input
			type="password" name="txtSenha" /> <input type="submit"
			id="operacao" name="operacao" value="LOGIN" /> <label>${resultado.msg}</label>
	</form>

	<p>
		<a href="FormCliente.html">Novo Usuário</a>
	</p>
	<p>
		<a href="FormConsultarFornecedor.jsp">Consulta Fornecedor</a>


</body>
</html>