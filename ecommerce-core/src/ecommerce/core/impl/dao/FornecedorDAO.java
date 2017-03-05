
package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ecommerce.dominio.Fornecedor;
import ecommerce.dominio.Endereco;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Usuario;

public class FornecedorDAO extends AbstractJdbcDAO {
	
	public FornecedorDAO() {
		super("tb_fornecedor", "id_fornecedor");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		
		Fornecedor fornecedor = (Fornecedor) entidade;
		
		Endereco end = fornecedor.getEndereco();
		end.setDtCadastro(entidade.getDtCadastro());
		
		Usuario usu = fornecedor.getUsuario();
		usu.setDtCadastro(entidade.getDtCadastro());
		
		
		
		try {
			connection.setAutoCommit(false);			
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.connection = connection;
			endDAO.ctrlTransaction = false;
			endDAO.salvar(end);			
			
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_fornecedor VALUES (seqid_fornecedor.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)");
					
			pst = connection.prepareStatement(sql.toString(),
					new String[] { "id_fornecedor" } );
			
			pst.setString(1, fornecedor.getRazaoSocial());
			pst.setString(2, fornecedor.getCnpj());
			pst.setString(3, fornecedor.getUsuario().getEmail());
			pst.setString(4, fornecedor.getTelefone());
			pst.setInt(5, end.getId());
			fornecedor.setAtivo(1);
			pst.setInt(6, fornecedor.getAtivo());
			pst.setDate(7, new java.sql.Date(fornecedor.getDtCadastro().getTime()));
			
			pst.executeUpdate();			
			
			ResultSet rs = pst.getGeneratedKeys();
			int idFor = 0;
			if (rs.next()) {
				idFor = rs.getInt(1);
			}
			
			fornecedor.setId(idFor);

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
		PreparedStatement pst = null;
		
		Fornecedor fornecedor = (Fornecedor) entidade;
		Endereco end = fornecedor.getEndereco();
		
		StringBuilder sql = new StringBuilder();
		
		try {
			openConnection();
		
			connection.setAutoCommit(false);			
			EnderecoDAO endDAO = new EnderecoDAO();
			endDAO.connection = connection;
			endDAO.ctrlTransaction = false;
			endDAO.alterar(end);			
			
			if(fornecedor != null && fornecedor.getRazaoSocial() != null 
					&& !fornecedor.getRazaoSocial().equals("")) {
				sql.append("UPDATE tb_fornecedor ");
				sql.append("SET RZSOCIAL = ? ");
			}
			if(fornecedor != null && fornecedor.getCnpj() != null 
					&& !fornecedor.getCnpj().equals("")) {
				sql.append(", CNPJ = ? ");
			}	
			if(fornecedor != null && fornecedor.getUsuario() != null 
					&& (fornecedor.getUsuario().getEmail() != null && !fornecedor.getUsuario().getEmail().equals(""))) {
				sql.append(", EMAIL = ? ");
			}	
			if(fornecedor != null && fornecedor.getTelefone() != null 
					&& !fornecedor.getTelefone().equals("")) {
				sql.append(", TELEFONE = ? ");
			}	
			if(fornecedor != null && fornecedor.getId() != null) {
				sql.append("WHERE id_fornecedor = ?");			
			}
			
			
			pst = connection.prepareStatement(sql.toString());

			pst.setString(1, fornecedor.getRazaoSocial());
			pst.setString(2, fornecedor.getCnpj());
			pst.setString(3, fornecedor.getUsuario().getEmail());
			pst.setString(4, fornecedor.getTelefone());
			pst.setInt(5, fornecedor.getId());

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
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException{
		PreparedStatement pst = null;

		Fornecedor fornecedor = (Fornecedor) entidade;
		
		StringBuilder sql = new StringBuilder();
		
		if(fornecedor != null && fornecedor.getId() == null
				&& (fornecedor.getRazaoSocial() == null || fornecedor.getRazaoSocial().equals(""))
				&& (fornecedor.getCnpj() == null || fornecedor.getCnpj().equals(""))) {
			sql.append("SELECT * FROM tb_fornecedor ");
		}
		else {
			sql.append("SELECT * FROM tb_fornecedor ");
			sql.append("WHERE 1 = 1 ");
			if(fornecedor != null && fornecedor.getId() !=null){
				sql.append("AND ID_FORNECEDOR = ? ");
			}
			if(fornecedor != null && (fornecedor.getRazaoSocial() !=null && !fornecedor.getRazaoSocial().equals(""))){
				sql.append("AND RZSOCIAL like ? ");
			}
			if(fornecedor != null && (fornecedor.getCnpj() !=null && !fornecedor.getCnpj().equals(""))){
				sql.append("AND CNPJ = ? ");
			}			
		}
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql.toString());
			
			
			if(fornecedor != null && fornecedor.getId() !=null){
				pst.setInt(1, fornecedor.getId());
			}
			if(fornecedor != null && (fornecedor.getRazaoSocial() !=null && !fornecedor.getRazaoSocial().equals(""))){
				pst.setString(1, "%"+fornecedor.getRazaoSocial()+"%");
			}
			if(fornecedor != null && (fornecedor.getCnpj() !=null && !fornecedor.getCnpj().equals(""))){
				pst.setString(1, fornecedor.getCnpj());
			}
			
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> fornecedores = new ArrayList<EntidadeDominio>();
			
			while (rs.next()) {
				Fornecedor f = new Fornecedor();
				f.setId(rs.getInt("ID_FORNECEDOR"));
				f.setRazaoSocial(rs.getString("RZSOCIAL"));
				f.setCnpj(rs.getString("CNPJ"));

				f.setUsuario(new Usuario());
				f.getUsuario().setEmail(rs.getString("EMAIL"));
				f.setTelefone(rs.getString("TELEFONE"));
				
				Endereco end = new Endereco();
				f.setEndereco(end);
				f.getEndereco().setId(rs.getInt("ID_END"));
				EnderecoDAO endDAO = new EnderecoDAO();
				endDAO.connection = connection;
				List<EntidadeDominio> enderecos = endDAO.consultar(end);
				f.setEndereco((Endereco)enderecos.get(0));
				
				f.setAtivo(rs.getInt("ATIVO"));
				f.setDtCadastro(rs.getDate("DT_CADASTRO"));
				
				fornecedores.add(f);

			}
			
			rs.close();
			pst.close();
			return fornecedores;	
			
		} catch (SQLException e) {
			e.printStackTrace();
			e.getMessage();
		}
		return null;
	}

	
	

	

}
