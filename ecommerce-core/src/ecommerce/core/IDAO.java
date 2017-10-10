package ecommerce.core;

import java.sql.SQLException;
import java.util.List;

import ecommerce.dominio.EntidadeDominio;

public interface IDAO {

	public void salvar(EntidadeDominio entidade) throws SQLException;
	public void alterar(EntidadeDominio entidade)throws SQLException;
	public void excluir(EntidadeDominio entidade)throws SQLException;
	public List<EntidadeDominio> consultar(EntidadeDominio entidade)throws SQLException;
	public EntidadeDominio montar(EntidadeDominio entidade) throws SQLException;
	
	
}
