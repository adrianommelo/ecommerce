
package ecommerce.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;

public class EnderecoDAO extends AbstractJdbcDAO {

	
	protected EnderecoDAO(String table, String idTable) {
		super("tb_endereco", "id_end");	
	}
	
	public EnderecoDAO(Connection cx){
		super(cx, "tb_endereco", "id_end");
	}
	
	public EnderecoDAO(){
		super("tb_endereco", "id_end");			
	}
	
	public void salvar(EntidadeDominio entidade) {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Endereco end = (Endereco)entidade;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_endereco values (seqid_end.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)");	
		try {
			connection.setAutoCommit(false);
					
			pst = connection.prepareStatement(sql.toString(), 
					new String[] { "id_end" });
			pst.setString(1, end.getCidade().getNome());
			pst.setString(2, end.getCidade().getEstado().getNome());
			pst.setString(3, end.getLogradouro());
			pst.setString(4, end.getNumero());
			pst.setString(5, end.getCep());	
			pst.setString(6, end.getComplemento());
			end.setAtivo(1);
			pst.setInt(7, end.getAtivo());
			pst.setDate(8, new java.sql.Date(end.getDtCadastro().getTime()));
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			
			end.setId(idEnd);
			
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
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}
		}
	}//salvar

	
	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub

	}

	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
