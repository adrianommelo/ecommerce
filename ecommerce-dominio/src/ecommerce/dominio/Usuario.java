package ecommerce.dominio;

import java.util.Date;

public class Usuario extends Pessoa {

	private String email;
	private String senha;
	private UsuarioTipo usuTipo;
	
	
	public Usuario(){
	}

	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Usuario(String nome, Date dataNascimento, String telefone, String email, String senha) {
		super(nome, dataNascimento, telefone);
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * @return the usuTipo
	 */
	public UsuarioTipo getUsuTipo() {
		return usuTipo;
	}

	/**
	 * @param usuTipo the usuTipo to set
	 */
	public void setUsuTipo(UsuarioTipo usuTipo) {
		this.usuTipo = usuTipo;
	}
	
}
