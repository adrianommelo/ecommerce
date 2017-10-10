
package ecommerce.controle.web.vh.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.controle.web.vh.IViewHelper;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.Categoria;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Formato;
import ecommerce.dominio.Fornecedor;
import ecommerce.dominio.Produto;

public class ProdutoViewHelper implements IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request) {

		// Parametros da tela
		String id = request.getParameter("txtId");
		String nome = request.getParameter("txtNomeProd");
		String descricao = request.getParameter("txtDescProd");
		String preco = request.getParameter("txtPrecoProd");
		String quantidade = request.getParameter("txtQtdProd");
		String categoria = request.getParameter("cmbCategoria");
		String fornecedor = request.getParameter("txtFornecedor");
		String peso = request.getParameter("txtPesoProd");
		String comprimento = request.getParameter("txtComprimentoProd");
		String altura = request.getParameter("txtAlturaProd");
		String largura = request.getParameter("txtLarguraProd");
		String diametro = request.getParameter("txtDiametroProd");
		String formato = request.getParameter("cmbFormatoProd");

		Produto produto = new Produto();

		if (id != null && !id.equals(""))
			produto.setId(Integer.parseInt(id));

		if (nome != null && !nome.equals(""))
			produto.setNome(nome);

		if (descricao != null && !descricao.equals(""))
			produto.setDescricao(descricao);

		if (preco != null && !preco.equals(""))
			produto.setPreco(Double.parseDouble(preco));

		if (quantidade != null && !quantidade.equals(""))
			produto.setQuantidade(Integer.parseInt(quantidade));

		produto.setCategoria(new ArrayList<Categoria>());
		if (categoria != null && !categoria.equals("")) {
			Categoria cat = new Categoria();
			cat.setId(Integer.parseInt(categoria));
			produto.getCategoria().add(cat);
		}
		
		Fornecedor f = new Fornecedor();
		if (fornecedor != null && !fornecedor.equals("")) {
			f.setId(Integer.parseInt(fornecedor));
			// f.setNome(fornecedor);
			produto.setFornecedor(f);
		}

		if (peso != null && !peso.equals(""))
			produto.setPeso(Double.parseDouble(peso));

		if (comprimento != null && !comprimento.equals(""))
			produto.setComprimento(Long.parseLong(comprimento));

		if (altura != null && !altura.equals(""))
			produto.setAltura(Long.parseLong(altura));

		if (largura != null && !largura.equals(""))
			produto.setLargura(Long.parseLong(largura));

		if (diametro != null && !diametro.equals(""))
			produto.setDiametro(Long.parseLong(diametro));

		produto.setFormato(new Formato());
		if (formato != null && !formato.equals(""))
			produto.getFormato().setId(Integer.parseInt(formato));

		return produto;
	}

	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		RequestDispatcher d = null;

		String operacao = request.getParameter("operacao");

		if (resultado.getMsg() == null && operacao.equals("SALVAR")) {
			resultado.setMsg("Produto cadastrado com sucesso!");
			request.setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("new-produto.jsp");
		}

		if (resultado.getMsg() == null && operacao.equals("CONSULTAR")
				&& request.getRequestURI().equals("/ecommerce-web/AlterarProduto")) {
			request.setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("update-produto.jsp");
		}

		if (resultado.getMsg() == null && operacao.equals("CONSULTAR")
				&& request.getRequestURI().equals("/ecommerce-web/ConsultarProduto")) {
			request.setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("consult-produto.jsp");
		}
		if(resultado.getMsg() == null && operacao.equals("ALTERAR")) {
			resultado.setMsg("Produto alterado com sucesso!");
			request.setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("/update-produto.jsp");
		}

		if (resultado.getMsg() == null && operacao.equals("EXCLUIR")) {
			resultado.setMsg("Produto excluído com sucesso!");
			request.getSession().setAttribute("resultado", null);
			d = request.getRequestDispatcher("consult-produto.jsp");
		}

		
		if (resultado.getMsg() == null && operacao.equals("MONTAR")
				&& request.getRequestURI().equals("/ecommerce-web/MontarProduto")) {
			request.setAttribute("resultado", resultado);
			d = request.getRequestDispatcher("new-produto.jsp");
		}
		
		d.forward(request, response);

	}

}
