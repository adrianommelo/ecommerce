package ecommerce.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;


import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Usuario;

public class UsuarioDAO extends AbstractJdbcDAO {

	protected UsuarioDAO(String table, String idTable) {
		super("tb_usuario", "id_usu");
	}

	public UsuarioDAO(Connection cx){
		super(cx, "tb_usuario", "id_usu");
	}
	
	public UsuarioDAO(){
		super("tb_usuario","id_end");
	}
	

	public void salvar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		
		PreparedStatement pst = null;
		Usuario usuario = (Usuario)entidade;
		StringBuilder sql = new StringBuilder();

		sql.append("insert into tb_usuario (email, senha, id_usu_tipo, ativo, ");
		sql.append("dt_cadastro) values (?,?,?,?,?)");
		
		try {
			connection.setAutoCommit(false);
			pst = connection.prepareStatement(sql.toString(),
					Statement.RETURN_GENERATED_KEYS);

			pst.setString(1, usuario.getEmail());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, "2");
			pst.setString(4, "1");
			Timestamp time = new Timestamp(usuario.getDtCadastro().getTime());
			pst.setTimestamp(5, time);
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
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction){
						connection.close();
					}
				}catch (SQLException ef){
					ef.printStackTrace();
				}
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
