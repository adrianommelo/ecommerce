
package ecommerce.core.impl.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Produto;

public class ProdutoDAO extends AbstractJdbcDAO {
	
	public ProdutoDAO() {
		super("tb_produto", "id_prod");		
	}
	public void salvar(EntidadeDominio entidade) {
		openConnection();
		PreparedStatement pst=null;
		
		Produto produto = (Produto)entidade;
		
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO tb_produto VALUES (seqid_prod.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
			
			pst = connection.prepareStatement(sql.toString(), 
					new String[] { "id_prod" } );
			
			pst.setString(1, produto.getNome());
			pst.setString(2, produto.getDescricao());
			pst.setDouble(3, produto.getPreco());
			pst.setInt(4, produto.getQuantidade());
			pst.setInt(5, produto.getCategoria().getId());
			pst.setInt(6, produto.getFornecedor().getId());
			pst.setDouble(7, produto.getPeso());
			pst.setDouble(8, produto.getComprimento());
			pst.setDouble(9, produto.getAltura());
			pst.setDouble(10, produto.getLargura());
			pst.setDouble(11, produto.getDiametro());
			pst.setInt(12, produto.getFormato().getId());
			produto.setAtivo(1);
			pst.setInt(13, produto.getAtivo());
			pst.setDate(14, new java.sql.Date(produto.getDtCadastro().getTime()));
			
			pst.executeUpdate();	
			
			ResultSet rs = pst.getGeneratedKeys();
			int idProd = 0;
			if (rs.next()) {
				idProd = rs.getInt(1);
			}
			
			produto.setId(idProd);

			connection.commit();		
			
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
		openConnection();
		PreparedStatement pst=null;
		Produto produto = (Produto)entidade;		
		
		try {
			connection.setAutoCommit(false);			
					
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE tb_produto SET descricao=?, quantidade=? ");
			sql.append("WHERE id_pro=?");				
			
					
			pst = connection.prepareStatement(sql.toString());
			pst.setString(1, produto.getDescricao());
			pst.setInt(2, produto.getQuantidade());
			pst.setInt(3, produto.getId());
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
	 * @return
	 * @see fai.dao.IDAO#consulta(fai.domain.EntidadeDominio)
	 */
	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
			PreparedStatement pst = null;
			
			Produto produto = (Produto)entidade;
			String sql=null;
			
			if(produto.getDescricao() == null){
				produto.setDescricao("");
			}
			
			if(produto.getId() == null && produto.getDescricao().equals("")){
				sql = "SELECT * FROM tb_produto";
			}else if(produto.getId() != null && produto.getDescricao().equals("")){
				sql = "SELECT * FROM tb_produto WHERE id_pro=?";
			}else if(produto.getId() == null && !produto.getDescricao().equals("")){
				sql = "SELECT * FROM tb_produto WHERE descricao like ?";
			
			}
		
		
		
		try {
			openConnection();
			pst = connection.prepareStatement(sql);
			
			if(produto.getId() != null && produto.getDescricao().equals("")){
				pst.setInt(1, produto.getId());
			}else if(produto.getId() == null && !produto.getDescricao().equals("")){
				pst.setString(1, "%"+produto.getDescricao()+"%");			
			}
			

			
			ResultSet rs = pst.executeQuery();
			List<EntidadeDominio> produtos = new ArrayList<EntidadeDominio>();
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id_pro"));
				p.setDescricao(rs.getString("descricao"));
				p.setQuantidade(rs.getInt("quantidade"));
				
				java.sql.Date dtCadastroEmLong = rs.getDate("dt_cadastro");
				Date dtCadastro = new Date(dtCadastroEmLong.getTime());				
				p.setDtCadastro(dtCadastro);
				produtos.add(p);
			}
			return produtos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	

	

}
