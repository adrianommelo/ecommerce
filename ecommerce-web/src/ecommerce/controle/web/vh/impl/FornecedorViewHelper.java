
package ecommerce.controle.web.vh.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.controle.web.vh.IViewHelper;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.core.util.ConverteDate;
import ecommerce.dominio.Cidade;
import ecommerce.dominio.ClienteFisico;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Estado;
import ecommerce.dominio.Genero;
import ecommerce.dominio.Usuario;
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
		String email = request.getParameter("txtEmail");
		
		String senha = request.getParameter("txtSenha");
		
		String confirmaSenha = request.getParameter("txtConfirmarSenha");

		
		String nome = request.getParameter("txtRzSocial");
		String rdGenero = request.getParameter("rdGenero");
		String cnpj = request.getParameter("txtCnpj");
		
		String dtNascimento = request.getParameter("txtDtNascimento");
		String telefone = request.getParameter("txtTelefoneContato");
		String cep = request.getParameter("txtCep");
		String logradouro = request.getParameter("txtLogradouro");
		String numero = request.getParameter("txtNumero");
		String complemento = request.getParameter("txtComplemento");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		
		

		Usuario u = new Usuario();
		u.setEmail(email);
		u.setSenha(senha);
		//confirmarSenha : verificar onde deve ser armarzenado, se deve ser armazenado, etc
		//
		
		ClienteJuridico cj = new ClienteJuridico();
		cj.setUsuario(new Usuario());
		cj.getUsuario().setEmail(email);
		cj.getUsuario().setSenha(senha);
		

		cj.setNome(nome);
//		if(id != null && !id.trim().equals("")){
//			c.setId(Integer.parseInt(id));
//		}
		
		cj.setGenero(new Genero());
		cj.getGenero().setGenero(new String());
		
		if(cj.getGenero() != null && !cj.getGenero().getGenero().equals("")){
			if(cj.getGenero().getGeneros().containsKey(Integer.parseInt(rdGenero)))
				cj.getGenero().setId(Integer.parseInt(rdGenero));
		}
		
		cj.setCnpj(cnpj);
		cj.setDataNascimento(ConverteDate.converteStringDate(dtNascimento));
		cj.setTelefone(telefone);
		cj.setEndereco(new Endereco());
		cj.getEndereco().setLogradouro(logradouro);
		cj.getEndereco().setNumero(numero);
		cj.getEndereco().setCep(cep);
		cj.getEndereco().setComplemento(complemento);
		cj.getEndereco().setBairro(bairro);
		cj.getEndereco().setCidade(new Cidade());
		cj.getEndereco().getCidade().setNome(cidade);
		cj.getEndereco().getCidade().setEstado(new Estado());
		cj.getEndereco().getCidade().getEstado().setNome(estado);
		
		return cj;
	}

	/** 
	 * TODO Descrição do Método
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 * @see ecommerce.controle.web.vh.IViewHelper#setView(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public void setView(Resultado resultado, HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = null;
		String operacao = request.getParameter("operacao");
		
		if(resultado.getMsg() == null 
				&& operacao.equals("SALVAR")){
			resultado.setMsg("Novo Cliente Juridico cadastrado com sucesso!");
			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormClienteJuri.html");
		}
		
		if(resultado.getMsg() == null && operacao.equals("CONSULTAR")) {
			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("ListaClienteJuridico.jsp");
		}
		
	
		d.forward(request, response);
	}

}
