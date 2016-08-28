
package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import ecommerce.dominio.ClienteFisico;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.ClienteJuridico;

public class ClienteFisicoDAO extends AbstractJdbcDAO {
	
	public ClienteFisicoDAO() {
		super("tb_cliente", "id_cli");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		ClienteFisico clienteFisico = (ClienteFisico)entidade;
		
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cliente(nome, cpf, ");
			sql.append("dt_cadastro) VALUES (?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, clienteFisico.getNome());
			pst.setString(2, clienteFisico.getCpf());
			Timestamp time = new Timestamp(clienteFisico.getDtCadastro().getTime());
			pst.setTimestamp(3, time);
			pst.executeUpdate();			
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
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		

	}
	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @see fai.dao.IDAO#alterar(fai.domain.EntidadeDominio)
	 */
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
