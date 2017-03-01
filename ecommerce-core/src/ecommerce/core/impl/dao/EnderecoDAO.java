
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
			end.setDtCadastro(new Date());
			pst.setDate(8, new java.sql.Date(end.getDtCadastro().getTime()));
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
		if (connection == null) {
			openConnection();
		}
		
		Endereco end = (Endereco) entidade;
		StringBuilder sql = new StringBuilder();
		PreparedStatement pst = null;
		
		if(end.getId() != null) {
			sql.append("select * from TB_ENDERECO e ");
	//		sql.append("TB_CLIENTE_JURIDICO cj ");
	//		sql.append("AND cj.ID_USU = e.ID_USU ");
			sql.append("AND e.ID_USU = ? ");
			sql.append("AND e.ATIVO = 1 ");
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
				e.setCep(rs.getString("CEP"));
				e.setComplemento(rs.getString("COMPLEMENTO"));
				e.setAtivo(rs.getInt("ATIVO"));
				e.setDtCadastro(rs.getDate("DT_CADASTRO"));
				enderecos.add(e);
//				System.out.println(rs.getString("ID_END")+" ");
//				System.out.println(rs.getString("CIDADE")+" ");
//				System.out.println(rs.getString("ESTADO")+" ");
//				System.out.println(rs.getString("LOGRADOURO")+" ");
//				System.out.println(rs.getString("NUMERO")+" ");
//				System.out.println(rs.getString("CEP")+" ");
//				System.out.println(rs.getString("COMPLEMENTO")+" ");
//				System.out.println(rs.getString("ATIVO")+" ");
//				System.out.println(rs.getString("DT_CADASTRO"));
				
			}
			
			return enderecos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
