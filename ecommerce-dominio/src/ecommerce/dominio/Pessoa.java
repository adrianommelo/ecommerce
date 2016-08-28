package ecommerce.dominio;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa extends EntidadeDominio {

	private String nome;
	private Genero genero;
	private Endereco endereco;
	private Date dataNascimento;
	private String telefone;
	
	protected Pessoa(){
		
	}
		
	public Pessoa(String nome, Date dataNascimento, String telefone) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getDataNascimento() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return (simpleDateFormat.format(dataNascimento));
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Genero getGenero() {
		return genero;
	}
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	

}
