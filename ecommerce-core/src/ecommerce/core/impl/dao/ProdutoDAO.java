
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

			sql.append("UPDATE tb_produto ");
			if (produto != null && produto.getNome() != null && !produto.getNome().equals("")) {
				sql.append("SET NOME = ? ");
			}
			if (produto != null && produto.getDescricao() != null && !produto.getDescricao().equals("")) {
				sql.append(", DESCRICAO = ? ");
			}
			if (produto != null && produto.getPreco() != null) {
				sql.append(", PRECO = ? ");
			}
			if (produto != null && produto.getQuantidade() != null ) {
				sql.append(", QTDE = ? ");
			}
			if (cat != null && cat.getId() != null ) {
				sql.append(", ID_CATEGORIA = ? ");
			}
			if (fornecedor != null && fornecedor.getId() != null ) {
				sql.append(", ID_FORNECEDOR = ? ");
			}
			if (produto != null && produto.getPeso() != null ) {
				sql.append(", PESO = ? ");
			}
			if (produto != null && produto.getComprimento() != null ) {
				sql.append(", COMPRIMENTO = ? ");
			}
			if (produto != null && produto.getAltura() != null ) {
				sql.append(", ALTURA = ? ");
			}
			if (produto != null && produto.getLargura() != null ) {
				sql.append(", LARGURA = ? ");
			}
			if (produto != null && produto.getDiametro() != null ) {
				sql.append(", DIAMETRO = ? ");
			}
			if (formato != null && formato.getId() != null ) {
				sql.append(", ID_FORMATO = ? ");
			}
			if (produto != null && produto.getAtivo() != null ) {
				sql.append(", ATIVO = ? ");
			}
			if (produto != null && produto.getDtCadastro() != null ) {
				sql.append(", DT_CADASTRO = ? ");
			}
			if (produto != null && produto.getId() != null) {
				sql.append("WHERE id_prod = ?");
			}

			pst = connection.prepareStatement(sql.toString());

			int i =1;
			if (produto != null && produto.getNome() != null && !produto.getNome().equals("")) {
				pst.setString(i++, produto.getNome());
			}
			if (produto != null && produto.getDescricao() != null && !produto.getDescricao().equals("")) {
				pst.setString(i++, produto.getDescricao());
			}
			if (produto != null && produto.getPreco() != null) {
				pst.setDouble(i++, produto.getPreco());
			}
			if (produto != null && produto.getQuantidade() != null ) {
				pst.setInt(i++, produto.getQuantidade());
			}
			if (cat != null && cat.getId() != null ) {
				pst.setInt(i++, produto.getCategoria().getId());
			}
			if (fornecedor != null && fornecedor.getId() != null ) {
				pst.setInt(i++, produto.getFornecedor().getId());
			}
			if (produto != null && produto.getPeso() != null ) {
				pst.setDouble(i++, produto.getPeso());
			}
			if (produto != null && produto.getComprimento() != null ) {
				pst.setDouble(i++, produto.getComprimento());
			}
			if (produto != null && produto.getAltura() != null ) {
				pst.setDouble(i++, produto.getAltura());
			}
			if (produto != null && produto.getLargura() != null ) {
				pst.setDouble(i++, produto.getLargura());
			}
			if (produto != null && produto.getDiametro() != null ) {
				pst.setDouble(i++, produto.getDiametro());
			}
			if (formato != null && formato.getId() != null ) {
				pst.setInt(i++, produto.getFormato().getId());
			}
			if (produto != null && produto.getAtivo() != null ) {
				pst.setInt(i++, produto.getAtivo());
			}
			if (produto != null && produto.getDtCadastro() != null ) {
				pst.setDate(i++, new java.sql.Date(produto.getDtCadastro().getTime()));
			}

			if (produto != null && produto.getId() != null) {
				pst.setInt(i++, produto.getId());
			}
			
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

		} finally {
			try {
				pst.close();
				if (ctrlTransaction)
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
		Categoria cat = produto.getCategoria();
		Fornecedor fornecedor = produto.getFornecedor();
		Formato formato = produto.getFormato();
		
		
		StringBuilder sql = new StringBuilder();

		if (produto != null && produto.getId() == null && (produto.getNome() == null || produto.getNome().equals(""))) {
			sql.append("SELECT * FROM tb_produto WHERE ATIVO = 1");
		} else {
			sql.append("SELECT * FROM tb_produto ");
			sql.append("WHERE ATIVO = 1 ");
			if (produto != null && produto.getId() != null) {
				sql.append("AND ID_PROD = ? ");
			}
			if (produto != null && (produto.getNome() != null && !produto.getNome().equals(""))) {
				sql.append("AND NOME like ? ");
			}
		}

		try {
			openConnection();
			
			CategoriaDAO catDAO = new CategoriaDAO();
			catDAO.connection = connection;
			catDAO.ctrlTransaction = false;
			List<EntidadeDominio> categorias = catDAO.consultar(new Categoria());
			List<Categoria> cats = new ArrayList<Categoria>();
			for(EntidadeDominio ent : categorias) {
				Categoria c = (Categoria)ent;
				cats.add(c);
			}
			
			FornecedorDAO fornecedorDAO = new FornecedorDAO();
			fornecedorDAO.connection = connection;
			fornecedorDAO.ctrlTransaction = false;
			List<EntidadeDominio> fornecedores = fornecedorDAO.consultar(fornecedor);
			List<Fornecedor> forns = new ArrayList<Fornecedor>();
			for(EntidadeDominio ent : fornecedores) {
				Fornecedor f = (Fornecedor)ent;
				forns.add(f);
			}
			
			pst = connection.prepareStatement(sql.toString());

			if (produto != null && produto.getId() != null) {
				pst.setInt(1, produto.getId());
			}
			if (produto != null && (produto.getNome() != null && !produto.getNome().equals(""))) {
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
				p.setCategorias(cats); //para o combo
				
				p.setFornecedor(new Fornecedor());
				p.getFornecedor().setId(rs.getInt("ID_FORNECEDOR"));
				p.setFornecedores(forns);
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

	@Override
	public EntidadeDominio montar(EntidadeDominio entidade) throws SQLException {
		
		PreparedStatement pst = null;

		Produto produto = (Produto) entidade;
		Categoria cat = produto.getCategoria();
		Fornecedor fornecedor = produto.getFornecedor();
		Formato formato = produto.getFormato();

		StringBuilder sql = new StringBuilder();

		try {
			openConnection();

			connection.setAutoCommit(false);
			
			if(produto.getId() != null) {
				
				if (produto != null && produto.getId() != null && !(produto.getId() == 0)) {
					sql.append("Select * tb_produto ");
					sql.append("WHERE id_prod = ? ");
				}
				
				
				pst = connection.prepareStatement(sql.toString());
				
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
				if (ctrlTransaction)
					connection.commit();
			}else {
				
				
				CategoriaDAO catDAO = new CategoriaDAO();
				catDAO.connection = connection;
				catDAO.ctrlTransaction = false;
				List<EntidadeDominio> categorias = catDAO.consultar(new Categoria());
				List<Categoria> cats = new ArrayList<Categoria>();
				for(EntidadeDominio ent : categorias) {
					Categoria c = (Categoria)ent;
					cats.add(c);
				}
				produto.setCategorias(cats);
				
				FornecedorDAO fornecedorDAO = new FornecedorDAO();
				fornecedorDAO.connection = connection;
				fornecedorDAO.ctrlTransaction = false;
				List<EntidadeDominio> fornecedores = fornecedorDAO.consultar(fornecedor);
				List<Fornecedor> forns = new ArrayList<Fornecedor>();
				for(EntidadeDominio ent : fornecedores) {
					Fornecedor f = (Fornecedor)ent;
					forns.add(f);
				}
				produto.setFornecedores(forns);
			}



		} catch (SQLException e) {

			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();

		} finally {
			try {
				if(pst != null)
					pst.close();
				if (ctrlTransaction)
					connection.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
		
		return produto;

	}

}
