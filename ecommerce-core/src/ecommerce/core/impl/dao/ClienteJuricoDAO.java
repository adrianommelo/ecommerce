
package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.ClienteJuridico;

public class ClienteJuricoDAO extends AbstractJdbcDAO {
	
	public ClienteJuricoDAO() {
		super("tb_cliente_juridico", "id_cli_juridico");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		ClienteJuridico clienteJuridico = (ClienteJuridico)entidade;
		Endereco end = clienteJuridico.getEndereco();
		
		
		try {
			connection.setAutoCommit(false);			
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.connection = connection;
			endDAO.ctrlTransaction = false;
			endDAO.salvar(end);			
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_fornecedor(rzsocial, cnpj, end_id, ");
			sql.append("dt_cadastro) VALUES (?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, clienteJuridico.getNome());
			pst.setString(2, clienteJuridico.getCnpj());
			pst.setInt(3, end.getId());
			Timestamp time = new Timestamp(clienteJuridico.getDtCadastro().getTime());
			pst.setTimestamp(4, time);
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
