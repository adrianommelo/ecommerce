
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

public class ClienteViewHelper implements IViewHelper {

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
		
		String nome = request.getParameter("txtNome");
		
		String rdGenero = request.getParameter("rdGenero");
		
		String cpf = request.getParameter("txtCpf");
		String dtNascimento = request.getParameter("txtDtNascimento");
		String telefone = request.getParameter("txtTelefoneContato");
		String cep = request.getParameter("txtCep");
		String logradouro = request.getParameter("txtLogradouro");
		String numero = request.getParameter("txtNumero");
		String complemento = request.getParameter("txtComplemento");
		String bairro = request.getParameter("txtBairro");
		String cidade = request.getParameter("txtCidade");
		String estado = request.getParameter("txtEstado");
		
		//String id = request.getParameter("txtId");
		
		Usuario u = new Usuario();
		u.setEmail(email);
		u.setSenha(senha);
		//confirmarSenha : verificar onde deve ser armarzenado, se deve ser armazenado, etc
		//
		
		ClienteFisico c = new ClienteFisico();
		c.setUsuario(new Usuario());
		c.getUsuario().setEmail(email);
		c.getUsuario().setSenha(senha);
		

		c.setNome(nome);
//		if(id != null && !id.trim().equals("")){
//			c.setId(Integer.parseInt(id));
//		}
		
		c.setGenero(new Genero());
		c.getGenero().setGenero(rdGenero);
		
		if(c.getGenero() != null && !c.getGenero().equals("")){
			if(c.getGenero().getGeneros().containsKey(Integer.parseInt(rdGenero)))
				c.getGenero().setId(Integer.parseInt(rdGenero));
		}
		
		c.setCpf(cpf);
		c.setDataNascimento(ConverteDate.converteStringDate(dtNascimento));
		c.setTelefone(telefone);
		c.setEndereco(new Endereco());
		c.getEndereco().setLogradouro(logradouro);
		c.getEndereco().setNumero(numero);
		c.getEndereco().setCep(cep);
		c.getEndereco().setComplemento(complemento);
		c.getEndereco().setBairro(bairro);
		c.getEndereco().setCidade(new Cidade());
		c.getEndereco().getCidade().setNome(cidade);
		c.getEndereco().getCidade().setEstado(new Estado());
		c.getEndereco().getCidade().getEstado().setNome(estado);
		
		return c;
		
//		String email = request.getParameter("txtEmail");
//		String senha = request.getParameter("txtSenha");
//		
//		//String id = request.getParameter("txtId");
//		
//		Teste t = new Teste();
//		t.setEmail(email);
//		t.setSenha(senha);
		//confirmarSenha : verificar onde deve ser armarzenado, se deve ser armazenado, etc
		//
				
		//return t;
	}

	/**
	 * TODO Descrição do Método
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException 
	 * @throws ServletException 
	 * @see ecommerce.controle.web.vh.IViewHelper#setView(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher d = null;
		
		String operacao = request.getParameter("operacao");
		
		
		if (resultado.getMsg() == null) {
			if (operacao.equals("SALVAR"))
				resultado.setMsg("Cliente Cadastrado com sucesso!");
			
			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormCliente.html");
		}
		
		
		//outras ações do crud..

		if(resultado.getMsg() != null){
			if(operacao.equals("SALVAR")){
				request.getSession().setAttribute("resultado", resultado);
				d = request.getRequestDispatcher("FormCliente.html");
			}
				
		}
		
		d.forward(request, response);
	}

}
