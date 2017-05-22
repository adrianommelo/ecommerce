
package ecommerce.core.impl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ecommerce.dominio.Cidade;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Estado;
import ecommerce.dominio.Fornecedor;

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
		openConnection();
		PreparedStatement pst = null;
		Endereco end = (Endereco) entidade;
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO tb_endereco values (seqid_end.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)");	
		try {
			connection.setAutoCommit(false);
					
			pst = connection.prepareStatement(sql.toString(), 
					new String[] { "id_end" });
			
			pst.setString(1, end.getCidade().getNome());
			pst.setString(2, end.getCidade().getEstado().getNome());
			pst.setString(3, end.getLogradouro());
			pst.setString(4, end.getNumero());
			pst.setString(5, end.getBairro());
			pst.setString(6, end.getCep());	
			pst.setString(7, end.getComplemento());
			end.setAtivo(1);
			pst.setInt(8, end.getAtivo());
			end.setDtCadastro(new Date());
			pst.setDate(9, new java.sql.Date(end.getDtCadastro().getTime()));
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEnd=0;
			if(rs.next())
				idEnd = rs.getInt(1);
			
			end.setId(idEnd);
			
			if (ctrlTransaction)
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
				if(ctrlTransaction)
					connection.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}
	}//salvar

	
	@Override
	public void alterar(EntidadeDominio entidade) {
		openConnection();
		
		PreparedStatement pst = null;
		
		Endereco end = (Endereco) entidade;
		StringBuilder sql = new StringBuilder();
		
		try {
			if(connection == null){
				openConnection();
			}
			
			
			connection.setAutoCommit(false);
			
			sql.append("UPDATE tb_endereco SET ");
			
			if(end != null && end.getCidade() != null 
					&& (end.getCidade().getNome() != null && !end.getCidade().getNome().equals(""))){
				sql.append(" CIDADE = ? ");
			}
			if(end != null && end.getCidade() != null && end.getCidade().getEstado() != null
					&& (end.getCidade().getEstado().getNome() != null && !end.getCidade().getEstado().getNome().equals(""))){
				sql.append(", ESTADO = ? ");
			}
			if(end != null && end.getLogradouro() != null 
					&& !end.getLogradouro().equals("")) {
				sql.append(", LOGRADOURO = ? ");
			}
			if(end != null && end.getNumero() != null 
					&& !end.getNumero().equals("")) {
				sql.append(", NUMERO = ? ");
			}	
			if(end != null && end.getBairro() != null 
					&& !end.getBairro().equals("")) {
				sql.append(", BAIRRO = ? ");
			}
			if(end != null && end.getCep() != null 
					&& !end.getCep().equals("")) {
				sql.append(", CEP = ? ");
			}
			if(end != null && end.getComplemento() != null 
					&& !end.getComplemento().equals("")) {
				sql.append(", COMPLEMENTO = ? ");
			}
			
			sql.append(" WHERE id_end = ? ");
			
			
			
			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, end.getCidade().getNome());
			pst.setString(2, end.getCidade().getEstado().getNome());
			pst.setString(3, end.getLogradouro());
			pst.setString(4, end.getNumero());
			pst.setString(5, end.getBairro());
			pst.setString(6, end.getCep());
			pst.setString(7, end.getComplemento());
			pst.setInt(8, end.getId());

			pst.executeUpdate();
			if (ctrlTransaction)
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
				if(ctrlTransaction)
					connection.close();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		}

	}

	/** 
	 * TODO Descrição do Método
	 * @param entidade
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		if (connection == null) {
			openConnection();
		}
		
		Endereco end = (Endereco) entidade;
		StringBuilder sql = new StringBuilder();
		PreparedStatement pst = null;
		
		if(end.getId() != null) {
			sql.append("SELECT * FROM TB_ENDERECO ");
			sql.append("WHERE ID_END = ? ");
		}
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql.toString());
			
			pst.setInt(1, end.getId());
			
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> enderecos = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Endereco e = new Endereco();
				e.setId(rs.getInt("ID_END"));
				
				e.setCidade(new Cidade());
				e.getCidade().setNome(rs.getString("CIDADE"));
				e.getCidade().setEstado(new Estado());
				e.getCidade().getEstado().setNome(rs.getString("ESTADO"));
				e.setLogradouro(rs.getString("LOGRADOURO"));
				e.setNumero(rs.getString("NUMERO"));
				e.setBairro(rs.getString("BAIRRO"));
				e.setCep(rs.getString("CEP"));
				e.setComplemento(rs.getString("COMPLEMENTO"));
				e.setAtivo(rs.getInt("ATIVO"));
				e.setDtCadastro(rs.getDate("DT_CADASTRO"));
				enderecos.add(e);				
			}
			
			return enderecos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
