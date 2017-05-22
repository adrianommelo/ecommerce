
package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import ecommerce.dominio.ClienteFisico;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Genero;
import ecommerce.dominio.Usuario;
import ecommerce.dominio.Fornecedor;

public class ClienteFisicoDAO extends AbstractJdbcDAO {
	
	public ClienteFisicoDAO() {
		super("tb_cliente_fisico", "id_cli_fisico");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		ClienteFisico clienteFisico = (ClienteFisico)entidade;
		Endereco end = clienteFisico.getEndereco();
		Genero gen = clienteFisico.getGenero();
		Usuario usu = (Usuario) entidade;	
		
		try {
			connection.setAutoCommit(false);
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.connection = connection;
			endDAO.ctrlTransaction = false;
			endDAO.salvar(end);
			
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.connection = connection;
			usuarioDAO.ctrlTransaction = false;
			usuarioDAO.salvar(usu);
	
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_cliente_fisico(nome, cpf, id_gen, id_end, id_usu, ativo, ");
			sql.append("dt_cadastro) VALUES (?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, clienteFisico.getNome());
			pst.setString(2, clienteFisico.getCpf());
			pst.setInt(3, gen.getId());
			pst.setInt(4, end.getId());
			pst.setInt(5, usu.getId());
			pst.setInt(5, clienteFisico.getAtivo());
			
			Timestamp time = new Timestamp(clienteFisico.getDtCadastro().getTime());
			pst.setTimestamp(6, time);
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
			} catch (SQLException e2) {
				e2.printStackTrace();
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
