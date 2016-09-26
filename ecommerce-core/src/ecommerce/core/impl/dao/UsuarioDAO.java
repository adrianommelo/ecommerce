package ecommerce.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Usuario;
import ecommerce.dominio.UsuarioTipo;

public class UsuarioDAO extends AbstractJdbcDAO {

	protected UsuarioDAO(String table, String idTable) {
		super("tb_usuario", "id_usu");
	}

	public UsuarioDAO(Connection cx){
		super(cx, "tb_usuario", "id_usu");
	}
	
	public UsuarioDAO(){
		super("tb_usuario","id_usu");
	}
	

	public void salvar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		
		PreparedStatement pst = null;
		Usuario usuario = (Usuario)entidade;
		
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into tb_usuario values (seqid_usu.NEXTVAL, ?, ?, ?, ?, ?)");
		
		try {
			connection.setAutoCommit(false);
			
			pst = connection.prepareStatement(sql.toString(),
					new String[] { "id_usu" } );

			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			pst.setInt(3, (UsuarioTipo.CLIENTE));
			usuario.setAtivo(1);
			pst.setInt(4, usuario.getAtivo());
			pst.setDate(5, new java.sql.Date(usuario.getDtCadastro().getTime()));
			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			int idUsu = 0;
			if (rs.next()) {
				idUsu = rs.getInt(1);
			}
			usuario.setId(idUsu);
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
				if(ctrlTransaction){
					connection.close();
				}
			}catch (SQLException e3){
				e3.printStackTrace();
			}
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
