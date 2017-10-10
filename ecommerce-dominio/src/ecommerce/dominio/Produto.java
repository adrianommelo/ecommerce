
package ecommerce.dominio;

import java.util.ArrayList;
import java.util.List;

public class Produto extends EntidadeDominio {

	private String nome;
	private String descricao;
	private Double preco;
	private Integer quantidade;
	private List<Categoria> categoria;
	private Fornecedor fornecedor;
	private Double peso;
	private Long comprimento;
	private Long altura;
	private Long largura;
	private Long diametro;
	private Formato formato;
	
	/**
	 * Getter e Setter que componhem a classe {@link Produto}
	 * @return
	 */
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
		
	public List<Categoria> getCategoria() {
		if(categoria == null) {
			categoria = new ArrayList<Categoria>();
		}
		return this.categoria;
	}
	public void setCategoria(List<Categoria> categoria) {
		this.categoria = categoria;
	}
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Long getComprimento() {
		return comprimento;
	}
	public void setComprimento(Long comprimento) {
		this.comprimento = comprimento;
	}
	public Long getAltura() {
		return altura;
	}
	public void setAltura(Long altura) {
		this.altura = altura;
	}
	public Long getLargura() {
		return largura;
	}
	public void setLargura(Long largura) {
		this.largura = largura;
	}
	public Long getDiametro() {
		return diametro;
	}
	public void setDiametro(Long diametro) {
		this.diametro = diametro;
	}
	public Formato getFormato() {
		return formato;
	}
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	
	public void addCategoria (Categoria cat) {
		getCategoria().add(cat);
	}
	
	
	
	
}
