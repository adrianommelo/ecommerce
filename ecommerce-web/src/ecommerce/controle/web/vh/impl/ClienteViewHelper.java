
package ecommerce.controle.web.vh.impl;

import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.controle.web.vh.IViewHelper;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.Cidade;
import ecommerce.dominio.ClienteFisico;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Estado;
import ecommerce.dominio.Teste;
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
//		String email = request.getParameter("txtEmail");
//		String senha = request.getParameter("txtSenha");
//		String confirmaSenha = request.getParameter("txtConfirmarSenha");
//		
//		String rdGenero = request.getParameter("rdGenero");
//		
//		String nome = request.getParameter("txtNome");
//		String cpf = request.getParameter("txtCpf");
//		String dtNascimento = request.getParameter("txtDtNascimento");
//		String telefone = request.getParameter("txtTelefoneContato");
//		String logradouro = request.getParameter("txtLogradouro");
//		String numero = request.getParameter("txtNumero");
//		String complemento = request.getParameter("txtComplemento");
//		String bairro = request.getParameter("txtBairro");
//		String cidade = request.getParameter("txtBairro");
//		String estado = request.getParameter("txtEstado");
//		
//		//String id = request.getParameter("txtId");
//		
//		Usuario u = new Usuario();
//		u.setEmail(email);
//		u.setSenha(senha);
//		//confirmarSenha : verificar onde deve ser armarzenado, se deve ser armazenado, etc
//		//
//		
//		ClienteFisico c = new ClienteFisico();
//		c.setUsuario(new Usuario());
//		c.getUsuario().setEmail(email);
//		
//		
//		//criar um validador para senha
//		if (senha != null && ! senha.equals("") ) {
//			if (confirmaSenha != null && ! confirmaSenha.equals("")
//					&& senha.equals(confirmaSenha)) {
//				
//			}else{
//				
//			}
//		}
//		
//		c.getUsuario().setSenha(senha);
//		
//
//		c.setNome(nome);
////		if(id != null && !id.trim().equals("")){
////			c.setId(Integer.parseInt(id));
////		}
//		c.setCpf(cpf);
////		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////		c.setDataNascimento(sdf.parse(dtNascimento));
//		
//		c.setTelefone(telefone);
//		c.setEndereco(new Endereco());
//		c.getEndereco().setLogradouro(logradouro);
//		c.getEndereco().setNumero(numero);
//		c.getEndereco().setComplemento(complemento);
//		c.getEndereco().setBairro(bairro);
//		c.getEndereco().setCidade(new Cidade());
//		c.getEndereco().getCidade().setNome(cidade);
//		c.getEndereco().getCidade().setEstado(new Estado());
//		c.getEndereco().getCidade().getEstado().setNome(estado);
//		
//		return c;
		
		String email = request.getParameter("txtEmail");
		String senha = request.getParameter("txtSenha");
		
		//String id = request.getParameter("txtId");
		
		Teste t = new Teste();
		t.setEmail(email);
		t.setSenha(senha);
		//confirmarSenha : verificar onde deve ser armarzenado, se deve ser armazenado, etc
		//
				
		return t;
	}

	/**
	 * TODO Descrição do Método
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @see ecommerce.controle.web.vh.IViewHelper#setView(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
