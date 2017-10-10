package ecommerce.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ecommerce.dominio.Categoria;
import ecommerce.dominio.EntidadeDominio;

public class CategoriaDAO extends AbstractJdbcDAO {

	protected CategoriaDAO(String table, String idTable) {
		super("tb_categoria", "id_categoria");
	}

	public CategoriaDAO(Connection cx) {
		super(cx, "tb_categoria", "id_categoria");
	}

	public CategoriaDAO() {
		super("tb_categoria", "id_categoria");
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst = null;

		Categoria cat = (Categoria) entidade;

		try {
			connection.setAutoCommit(false);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTP tb_categoria VALUES (seqid_categoria.NEXTVAL, ?, ?, ?) ");

			pst = connection.prepareStatement(sql.toString(), new String[] { "id_categoria" });

			pst.setString(1, cat.getCategoria());
			pst.setInt(2, cat.getAtivo());
			pst.setDate(3, new java.sql.Date(cat.getDtCadastro().getTime()));
			pst.executeUpdate();

			ResultSet rs = pst.getGeneratedKeys();
			int idCat = 0;
			if (rs.next()) {
				idCat = rs.getInt(1);
			}
			cat.setId(idCat);

			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				connection.close();
			} catch (SQLException e3) {
				e3.printStackTrace();
			}
		}

	}

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst = null;

		Categoria cat = (Categoria) entidade;

		try {
			connection.setAutoCommit(false);
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_categoria ");
			
			int i = 1;
			if (cat != null && cat.getCategoria() != null && !cat.getCategoria().equals("")) {
				sql.append("SET CATEGORIA = ? ");
			}
			if (cat != null && cat.getAtivo() != null) {
				sql.append(", ATIVO = ? ");
			}
			if (cat != null && cat.getId() != null) {
				sql.append("WHERE id_categoria = ?");
			}

			pst = connection.prepareStatement(sql.toString());

			if (cat != null && cat.getCategoria() != null && !cat.getCategoria().equals(""))
				pst.setString(i++, cat.getCategoria());
			
			if (cat != null && cat.getAtivo() != null) {
				cat.setAtivo(1);
				pst.setInt(i++, cat.getAtivo());
			}
			if (cat != null && cat.getId() != null)
				pst.setInt(i++, cat.getId());

			
			pst.executeUpdate();
			if (ctrlTransaction) {
				connection.commit();
			}
		} catch (Exception e) {
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

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		if (connection == null) {
			openConnection();
		}

		Categoria cat = (Categoria) entidade;
		StringBuilder sql = new StringBuilder();
		PreparedStatement pst = null;

		if (cat.getId() != null) {
			sql.append("SELECT * FROM tb_categoria ");
			sql.append("WHERE id_categoria = ? ");
		} else {
			sql.append("SELECT * FROM tb_categoria ");
		}

		try {
			openConnection();
			pst = connection.prepareStatement(sql.toString());
			if (cat != null && cat.getId() != null && cat.getId() != 0) {
				pst.setInt(1, cat.getId());
			}
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt("ID_CATEGORIA"));
				c.setCategoria(rs.getString("CATEGORIA"));
				c.setAtivo(rs.getInt("ATIVO"));

				c.setDtCadastro(rs.getDate("DT_CADASTRO"));
				categorias.add(c);
			}

			return categorias;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EntidadeDominio montar(EntidadeDominio entidade) throws SQLException {
		if (connection == null) {
			openConnection();
		}

		Categoria cat = (Categoria) entidade;
		StringBuilder sql = new StringBuilder();
		PreparedStatement pst = null;

		if (cat.getId() != null) {
			sql.append("SELECT * FROM tb_categoria ");
			sql.append("WHERE id_categoria = ? ");
		} else {
			sql.append("SELECT * FROM tb_categoria ");
		}

		try {
			openConnection();
			pst = connection.prepareStatement(sql.toString());

			if (cat.getId() != null) {
				pst.setInt(1, cat.getId());
			}
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> categorias = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId(rs.getInt("ID_CATEGORIA"));
				c.setCategoria(rs.getString("CATEGORIA"));
				c.setAtivo(rs.getInt("ATIVO"));

				c.setDtCadastro(rs.getDate("DT_CADASTRO"));
				categorias.add(c);
			}

			return cat;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
