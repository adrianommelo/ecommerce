package ecommerce.dominio;


import java.util.Date;

public class EntidadeDominio implements IEntidade{
	
	private Integer id;
	private Date dtCadastro;
	
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
	
	
	

}
