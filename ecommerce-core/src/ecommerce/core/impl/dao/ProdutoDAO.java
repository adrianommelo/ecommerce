
package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ecommerce.dominio.Categoria;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Formato;
import ecommerce.dominio.Fornecedor;
import ecommerce.dominio.Produto;
import ecommerce.dominio.Usuario;

public class ProdutoDAO extends AbstractJdbcDAO {

	public ProdutoDAO() {
		super("tb_produto", "id_prod");
	}

	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst = null;

		Produto produto = (Produto) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_produto VALUES (seqid_prod.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

			pst = connection.prepareStatement(sql.toString(), new String[] { "id_prod" });

			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setDouble(3, produto.getPreco());
			pst.setInt(4, produto.getQuantidade());
			pst.setInt(5, produto.getCategoria().getId());
			pst.setInt(6, produto.getFornecedor().getId());
			pst.setDouble(7, produto.getPeso());
			pst.setDouble(8, produto.getComprimento());
			pst.setDouble(9, produto.getAltura());
			pst.setDouble(10, produto.getLargura());
			pst.setDouble(11, produto.getDiametro());
			pst.setInt(12, produto.getFormato().getId());
			produto.setAtivo(1);
			pst.setInt(13, produto.getAtivo());
			pst.setDate(14, new java.sql.Date(produto.getDtCadastro().getTime()));

			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idProd = 0;
			if (rs.next()) {
				idProd = rs.getInt(1);
			}

			produto.setId(idProd);

			connection.commit();

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * TODO Descrição do Método
	 * 
	 * @param entidade
	 * @see fai.dao.IDAO#alterar(fai.domain.EntidadeDominio)
	 */
	@Override
	public void alterar(EntidadeDominio entidade) {
PreparedStatement pst = null;
		
		Produto produto = (Produto) entidade;
		Categoria cat = produto.getCategoria();
		Fornecedor fornecedor = produto.getFornecedor();
		Formato formato = produto.getFormato();
		
		StringBuilder sql = new StringBuilder();
		
		try {
			openConnection();
		
			connection.setAutoCommit(false);			
			CategoriaDAO catDAO = new CategoriaDAO();
			catDAO.connection = connection;
			catDAO.ctrlTransaction = false;
			catDAO.alterar(cat);			
			
			if(fornecedor != null && fornecedor.getRazaoSocial() != null 
					&& !fornecedor.getRazaoSocial().equals("")) {
				sql.append("UPDATE tb_fornecedor ");
				sql.append("SET RZSOCIAL = ? ");
			}
			if(fornecedor != null && fornecedor.getCnpj() != null 
					&& !fornecedor.getCnpj().equals("")) {
				sql.append(", CNPJ = ? ");
			}	
			if(fornecedor != null && fornecedor.getUsuario() != null 
					&& (fornecedor.getUsuario().getEmail() != null && !fornecedor.getUsuario().getEmail().equals(""))) {
				sql.append(", EMAIL = ? ");
			}	
			if(fornecedor != null && fornecedor.getTelefone() != null 
					&& !fornecedor.getTelefone().equals("")) {
				sql.append(", TELEFONE = ? ");
			}	
			if(fornecedor != null && fornecedor.getId() != null) {
				sql.append("WHERE id_fornecedor = ?");			
			}
			
			
			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, fornecedor.getRazaoSocial());
			pst.setString(2, fornecedor.getCnpj());
			pst.setString(3, fornecedor.getUsuario().getEmail());
			pst.setString(4, fornecedor.getTelefone());
			pst.setInt(5, fornecedor.getId());

			pst.executeUpdate();
			
			
			if (ctrlTransaction)
				connection.commit();
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			e.printStackTrace();
			
		}finally{
			try {
				pst.close();
				if(ctrlTransaction)
					connection.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}

	/**
	 * TODO Descrição do Método
	 * 
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		PreparedStatement pst = null;

		Produto produto = (Produto) entidade;

		StringBuilder sql = new StringBuilder();

		if (produto != null && produto.getId() == null
				&& (produto.getNome() == null || produto.getNome().equals(""))) {
			sql.append("SELECT * FROM tb_produto WHERE ATIVO = 1");
		} else {
			sql.append("SELECT * FROM tb_produto ");
			sql.append("WHERE ATIVO = 1 ");
			if (produto != null && produto.getId() != null) {
				sql.append("AND ID_PROD = ? ");
			}
			if (produto != null
					&& (produto.getNome() != null && !produto.getNome().equals(""))) {
				sql.append("AND NOME like ? ");
			}
		}

		try {
			openConnection();
			pst = connection.prepareStatement(sql.toString());

			if (produto != null && produto.getId() != null) {
				pst.setInt(1, produto.getId());
			}
			if (produto != null
					&& (produto.getNome() != null && !produto.getNome().equals(""))) {
				pst.setString(1, "%" + produto.getNome() + "%");
			}
			

			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> produtos = new ArrayList<EntidadeDominio>();

			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("ID_PROD"));
				p.setNome(rs.getString("NOME"));
				p.setDescricao(rs.getString("DESCRICAO"));

				p.setPreco(rs.getDouble("PRECO"));
				p.setQuantidade(rs.getInt("QTDE"));
				p.setCategoria(new Categoria());
				p.getCategoria().setId(rs.getInt("ID_CATEGORIA"));
				p.setFornecedor(new Fornecedor());
				p.getFornecedor().setId(rs.getInt("ID_FORNECEDOR"));
				p.setPeso(rs.getDouble("PESO"));
				p.setComprimento(rs.getLong("COMPRIMENTO"));
				p.setAltura(rs.getLong("ALTURA"));
				p.setLargura(rs.getLong("LARGURA"));
				p.setDiametro(rs.getLong("DIAMETRO"));
				p.setFormato(new Formato());
				p.getFormato().setId(rs.getInt("ID_FORMATO"));
				p.setAtivo(rs.getInt("ATIVO"));
				p.setDtCadastro(rs.getDate("DT_CADASTRO"));
				

				produtos.add(p);

			}

			rs.close();
			pst.close();
			return produtos;

		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}

}
