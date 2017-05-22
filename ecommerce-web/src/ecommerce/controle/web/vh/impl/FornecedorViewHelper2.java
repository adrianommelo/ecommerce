
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
import ecommerce.dominio.Fornecedor;



public class FornecedorViewHelper2 implements IViewHelper {

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
		
		Fornecedor f = new Fornecedor();
		f.setUsuario(new Usuario());
		f.getUsuario().setEmail(email);
		f.getUsuario().setSenha(senha);
		

		f.setNome(nome);
//		if(id != null && !id.trim().equals("")){
//			c.setId(Integer.parseInt(id));
//		}
		
		f.setGenero(new Genero());
		f.getGenero().setGenero(new String());
		
		if(f.getGenero() != null && !f.getGenero().getGenero().equals("")){
			if(f.getGenero().getGeneros().containsKey(Integer.parseInt(rdGenero)))
				f.getGenero().setId(Integer.parseInt(rdGenero));
		}
		
		f.setCnpj(cnpj);
		f.setDataNascimento(ConverteDate.converteStringDate(dtNascimento));
		f.setTelefone(telefone);
		f.setEndereco(new Endereco());
		f.getEndereco().setLogradouro(logradouro);
		f.getEndereco().setNumero(numero);
		f.getEndereco().setCep(cep);
		f.getEndereco().setComplemento(complemento);
		f.getEndereco().setBairro(bairro);
		f.getEndereco().setCidade(new Cidade());
		f.getEndereco().getCidade().setNome(cidade);
		f.getEndereco().getCidade().setEstado(new Estado());
		f.getEndereco().getCidade().getEstado().setNome(estado);
		
		return f;
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
			resultado.setMsg("Novo Fornecedor cadastrado com sucesso!");
			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormConsultarFornecedor.jsp");
		}
		
		if(resultado.getMsg() == null && operacao.equals("CONSULTAR")) {
			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("ListaFornecedor.jsp");
		}
		if(resultado.getMsg() == null && operacao.equals("ALTERAR")) {
			request.getSession().setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("FormAlteraFornecedor.jsp");
		}
		
	
		d.forward(request, response);
	}

}
