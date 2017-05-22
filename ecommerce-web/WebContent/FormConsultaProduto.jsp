<%@page import="ecommerce.core.util.ConverteDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page
    import="ecommerce.core.aplicacao.*, ecommerce.dominio.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META http-equiv="Content-Type" content="text/html; charset=utf-8">

<title>:::: CONSULTAR PRODUTO::::</title>
</head>
<body>

	<%
		Resultado resultado = (Resultado) session.getAttribute("resultado");
	%>

	<form action="" method="post">

		<label for="txtId">Id:</label> <input type="text" id="txtId"
			name="txtId" /> </br> 
			<label for="txtDescricao">DESCRIÇÃO:</label> <input
			type="text" id="txtDescricao" name="txtDescricao" /> <input
			type="submit" id="operacao" name="operacao" value="CONSULTAR" />
	</form>

	


	<%
	
	if(resultado !=null && resultado.getMsg() != null){
		out.print(resultado.getMsg());
	}
	
	%>
<BR>

<TABLE BORDER="5"    WIDTH="50%"   CELLPADDING="4" CELLSPACING="3">
   <TR>
      <TH COLSPAN="3"><BR>
      	<H3>PRODUTOS</H3>
      </TH>
   </TR>
   
   <TR>
      <TH>ID:</TH>
      <TH>Descrição</TH>
      <TH>Quantidade:</TH>
   </TR>
   
   
   <%
   
   if (resultado != null) {
		List<EntidadeDominio> entidades = resultado.getEntidades();
		StringBuilder sbRegistro = new StringBuilder();
		StringBuilder sbLink = new StringBuilder();
		
		
		if(entidades != null){
			for (int i = 0; i < entidades.size(); i++) {
				Produto p = (Produto) entidades.get(i);
				sbRegistro.setLength(0);
				sbLink.setLength(0);
				
			//	<a href="nome-do-lugar-a-ser-levado">descrição</a>
				
				sbRegistro.append("<TR ALIGN='CENTER'>");
				
				
				sbLink.append("<a href=SalvarProduto?");
					sbLink.append("txtId=");
					sbLink.append(p.getId());						
					sbLink.append("&");
					sbLink.append("operacao=");
					sbLink.append("VISUALIZAR");
					
				sbLink.append(">");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());	
				sbRegistro.append(p.getId());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(p.getDescricao());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("<TD>");
				sbRegistro.append(sbLink.toString());				
				sbRegistro.append(p.getQuantidade());
				sbRegistro.append("</a>");				
				sbRegistro.append("</TD>");
				
				sbRegistro.append("</TR>");
				
				
				out.print(sbRegistro.toString());
				
			}
		}
		

	}
   
   %>
   
   
      
  
</TABLE>


</body>
</html>