
package ecommerce.controle.web.vh.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ecommerce.controle.web.vh.IViewHelper;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.core.util.ConverteDate;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Produto;



public class ProdutoViewHelper implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		String operacao = request.getParameter("operacao");
		Produto produto = null; 
		
		if(!operacao.equals("VISUALIZAR")){
			String descricao = request.getParameter("txtDescricao");
			String qtd = request.getParameter("txtQtd");
			String id = request.getParameter("txtId");
			String dtCadastro = request.getParameter("txtDtCadastro");
			
			
			produto = new Produto();
			
			
			if(descricao != null && !descricao.trim().equals("")){
				produto.setDescricao(descricao);
			}
			
			if(id != null && !id.trim().equals("")){
				produto.setId(Integer.parseInt(id));
			}
			
			if(qtd != null && !qtd.trim().equals("")){
				produto.setQuantidade(Integer.parseInt(qtd));
			}
			
			if(dtCadastro != null && !dtCadastro.trim().equals("")){
				produto.setDtCadastro(ConverteDate.converteStringDate(dtCadastro));
			}
		}else{
			HttpSession session = request.getSession();
			Resultado resultado = (Resultado) session.getAttribute("resultado");
			String txtId = request.getParameter("txtId");
			int id=0;
			
			if(txtId != null && !txtId.trim().equals("")){
				id = Integer.parseInt(txtId);
			}
			
			for(EntidadeDominio e: resultado.getEntidades()){
				if(e.getId() == id){
					produto = (Produto)e;
				}
			}
		}
		
		return produto;
	}

	
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response)  throws IOException, ServletException {
		RequestDispatcher d=null;
		
		String operacao = request.getParameter("operacao");
		
		if(resultado.getMsg() == null){
			if(operacao.equals("SALVAR")){
				resultado.setMsg("Produto cadastrado com sucesso!");
			}
			
			request.getSession().setAttribute("resultado", resultado);
			d= request.getRequestDispatcher("FormConsultaProduto.jsp");  			
		}
		
		if(resultado.getMsg() == null && operacao.equals("ALTERAR")){
			
			d= request.getRequestDispatcher("FormConsultaProduto.jsp");  
		}
		
		if(resultado.getMsg() == null && operacao.equals("VISUALIZAR")){
			
			request.setAttribute("produto", resultado.getEntidades().get(0));
			d= request.getRequestDispatcher("FormProduto.jsp");  			
		}
		
		if(resultado.getMsg() == null && operacao.equals("EXCLUIR")){
			
			request.getSession().setAttribute("resultado", null);
			d= request.getRequestDispatcher("FormConsultaProduto.jsp");  
		}
		
		if(resultado.getMsg() != null){
			if(operacao.equals("SALVAR") || operacao.equals("ALTERAR")){
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("FormConsultaProduto.jsp");  	
			}
		}
		
		d.forward(request,response); 
		
	}

}
