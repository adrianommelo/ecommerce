package ecommerce.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
			pst.setInt(3, (UsuarioTipo.FORNECEDOR));
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
			

			if(ctrlTransaction)
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
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		if (connection == null) {
			openConnection();
		}
		
		Usuario usu = (Usuario) entidade;
		StringBuilder sql = new StringBuilder();
		PreparedStatement pst = null;
		
		if(usu.getId() != null) {
			sql.append("select * from TB_USUARIO usu ");
	//		sql.append("TB_CLIENTE_JURIDICO cj ");
	//		sql.append("AND cj.ID_USU = e.ID_USU ");
			sql.append("WHERE usu.ID_USU = ? ");
			sql.append("AND e.ATIVO = 1 ");
		}
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql.toString());
			
			pst.setInt(1, usu.getId());
			
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> usuarios = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("ID_USU"));
				
				u.setEmail(rs.getString("EMAIL"));
				u.setSenha(rs.getString("SENHA"));
				u.setUsuTipo(new UsuarioTipo());
				u.getUsuTipo().setId(rs.getInt("ID_USU_TIPO"));
				u.setAtivo(rs.getInt("ATIVO"));
				u.setDtCadastro(rs.getDate("DT_CADASTRO"));
				usuarios.add(u);				
			}
			
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
