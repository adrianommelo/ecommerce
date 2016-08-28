
package ecommerce.controle.web.vh.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.controle.web.vh.IViewHelper;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.ClienteFisico;
import ecommerce.dominio.EntidadeDominio;



public class ClienteViewHelper implements IViewHelper {

	/** 
	 * TODO Descrição do Método
	 * @param request
	 * @param response
	 * @return
	 * @see ecommerce.controle.web.vh.IViewHelper#getEntidade(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String nome = request.getParameter("txtNome");
		String cpf = request.getParameter("txtCpf");
		String id = request.getParameter("txtId");
		
		
		ClienteFisico c = new ClienteFisico();
		c.setNome(nome);
		
		if(id != null && !id.trim().equals("")){
			c.setId(Integer.parseInt(id));
		}
		
		c.setCpf(cpf);
		return c;
	}

	/** 
	 * TODO Descrição do Método
	 * @param request
	 * @param response
	 * @return
	 * @see ecommerce.controle.web.vh.IViewHelper#setView(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

}
