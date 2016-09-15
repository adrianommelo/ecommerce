
package ecommerce.controle.web.vh.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.controle.web.vh.IViewHelper;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.Cidade;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Estado;
import ecommerce.dominio.ClienteJuridico;



public class FornecedorViewHelper implements IViewHelper {

	/** 
	 * TODO Descrição do Método
	 * @param request
	 * @param response
	 * @return
	 * @see ecommerce.controle.web.vh.IViewHelper#getEntidade(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		String id = request.getParameter("txtId");
		String nome = request.getParameter("txtRzSocial");
		String cnpj = request.getParameter("txtCnpj");
		String logradouro = request.getParameter("txtLogradouro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		String cep = request.getParameter("txtCep");		
		String numero = request.getParameter("txtNumero");
		
		ClienteJuridico f = new ClienteJuridico();
		
		if(id !=null && !id.trim().equals(""))
			f.setId(Integer.parseInt(id));
		
		f.setNome(nome);
		f.setEndereco(new Endereco());
		f.getEndereco().setCidade(new Cidade());
		f.getEndereco().setLogradouro(logradouro);
		f.getEndereco().getCidade().setNome(cidade);
		f.getEndereco().getCidade().setEstado(new Estado());
		f.getEndereco().getCidade().getEstado().setNome(estado);
		
		f.getEndereco().setNumero(numero);
		f.getEndereco().setCep(cep);
		f.setCnpj(cnpj);
		return f;
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
		
	}

}
