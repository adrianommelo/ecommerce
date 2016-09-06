package ecommerce.dominio;


import java.util.Date;

public class EntidadeDominio implements IEntidade{
	
	private Integer id;
	private Date dtCadastro;
	private Integer ativo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDtCadastro() {
		return dtCadastro;
	}
	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}
	/**
	 * @return the ativo
	 */
	public Integer getAtivo() {
		return ativo;
	}
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}
	
	
	

}
