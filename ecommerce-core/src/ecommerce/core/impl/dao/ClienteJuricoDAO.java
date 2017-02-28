
package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import ecommerce.dominio.ClienteJuridico;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Usuario;

public class ClienteJuricoDAO extends AbstractJdbcDAO {
	
	public ClienteJuricoDAO() {
		super("tb_cliente_juridico", "id_cli_juridico");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		ClienteJuridico clienteJuridico = (ClienteJuridico)entidade;
		Endereco end = clienteJuridico.getEndereco();
		Usuario usu = new Usuario();
		usu = (Usuario)entidade;
		
		
		try {
			connection.setAutoCommit(false);			
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.connection = connection;
			endDAO.ctrlTransaction = false;
			endDAO.salvar(end);			
			
			StringBuilder sql = new StringBuilder();

			sql.append("INSERT INTO tb_cliente_juridico VALUES (seqid_cli_juridico.NEXTVAL, ?, ?, ?, ?, ?, ?)");
					
			pst = connection.prepareStatement(sql.toString(), new String[] { "id_cli_juridico" } );
			pst.setString(1, clienteJuridico.getNome().trim());

			pst.setString(2, clienteJuridico.getCnpj());
			pst.setInt(3, end.getId());
			pst.setInt(4, usu.getId());
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
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException{
		PreparedStatement pst = null;

		ClienteJuridico clienteJuridico = (ClienteJuridico) entidade;
		
		StringBuilder sql = new StringBuilder();
		if(clienteJuridico != null && clienteJuridico.getCnpj() !=null ){
			sql.append("SELECT * FROM tb_cliente_juridico ");
			sql.append("WHERE CNPJ = ? ");
		}
		
		try {
			openConnection();
						
			pst = connection.prepareStatement(sql.toString());
			if(clienteJuridico != null && clienteJuridico.getCnpj() !=null ){
				pst.setString(1, clienteJuridico.getCnpj());
			}
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> clientesJuridicos = new ArrayList<EntidadeDominio>();
			
			while (rs.next()) {
				ClienteJuridico cj = new ClienteJuridico();
				cj.setId(rs.getInt("ID_CLI_JURIDICO"));
				cj.setRazaoSocial(rs.getString("RZSOCIAL"));
				cj.setCnpj(rs.getString("CNPJ"));
				
//				UsuarioDAO usuarioDAO = new UsuarioDAO();
//				usuarioDAO.connection = connection;
//				List<EntidadeDominio> usuarios = usuarioDAO.consultar(usu);
				
				Usuario usu = new Usuario();
				cj.setUsuario(usu);
				cj.getUsuario().setId(rs.getInt("ID_USU"));

//				EnderecoDAO endDAO = new EnderecoDAO();
//				endDAO.connection = connection;
//				List<EntidadeDominio> enderecos = endDAO.consultar(end);			

				Endereco end = new Endereco();
				cj.setEndereco(end);
				cj.getEndereco().setId(rs.getInt("ID_END"));
				cj.setAtivo(rs.getInt("ATIVO"));
				cj.setDtCadastro(rs.getDate("DT_CADASTRO"));
				clientesJuridicos.add(cj);

			}
			
			rs.close();
			pst.close();
			return clientesJuridicos;	
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}

	
	

	

}
