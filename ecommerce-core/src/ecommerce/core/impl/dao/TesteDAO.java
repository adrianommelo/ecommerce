package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Teste;

public class TesteDAO extends AbstractJdbcDAO {

	
	public TesteDAO() {
		super("teste", "idteste");
	}

	@Override
	public void salvar(EntidadeDominio entidade) throws SQLException {
		if (connection == null) {
			openConnection();
		}
		openConnection();
		PreparedStatement pst = null;
		Teste ts = (Teste) entidade;
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into teste values (seqtesteid.NEXTVAL, ?, ?, ?, ?)");
		
		try {
			
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(),
					new String[] { "IDTESTE" } );
			pst.setString(1, ts.getEmail());
			pst.setString(2, ts.getSenha());
			pst.setDate(3, new java.sql.Date(ts.getDtCadastro().getTime()));
			ts.setAtivo(1);
			pst.setInt(4, ts.getAtivo());
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int idTeste = 0;
			if (rs.next()) 
				idTeste = rs.getInt(1);
			
			ts.setId(idTeste);
			
			connection.commit();
			
		} catch (SQLException e) {
			
			try {
				connection.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			
			e.printStackTrace();
			
		}finally{
			if (ctrlTransaction) {	
				
				try {
					pst.close();
					if (ctrlTransaction) 
						connection.close();
				} catch (SQLException e3) {
					e3.printStackTrace();
				}
			}//if
			
		}

	}//salvar

	@Override
	public void alterar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
