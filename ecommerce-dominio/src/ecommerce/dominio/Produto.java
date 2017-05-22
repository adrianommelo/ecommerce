
package ecommerce.dominio;

public class Produto extends EntidadeDominio {

	private String nome;
	private String descricao;
	private Double preco;
	private int quantidade;
	private Categoria categoria;
	private Fornecedor fornecedor;
	private double peso;
	private long comprimento;
	private long altura;
	private long largura;
	private long diametro;
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
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public long getComprimento() {
		return comprimento;
	}
	public void setComprimento(long comprimento) {
		this.comprimento = comprimento;
	}
	public long getAltura() {
		return altura;
	}
	public void setAltura(long altura) {
		this.altura = altura;
	}
	public long getLargura() {
		return largura;
	}
	public void setLargura(long largura) {
		this.largura = largura;
	}
	public long getDiametro() {
		return diametro;
	}
	public void setDiametro(long diametro) {
		this.diametro = diametro;
	}
	public Formato getFormato() {
		return formato;
	}
	public void setFormato(Formato formato) {
		this.formato = formato;
	}
	
	
	
	
	
	
}
