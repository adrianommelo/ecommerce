
package ecommerce.dominio;

import java.util.ArrayList;
import java.util.List;

public class Produto extends EntidadeDominio {

	private String nome;
	private String descricao;
	private Double preco;
	private Categoria categoria;
	private Integer quantidade;
	private Fornecedor fornecedor;
	private Double peso;
	private Long comprimento;
	private Long altura;
	private Long largura;
	private Long diametro;
	private Formato formato;
	
	private List<Categoria> categorias;
	private List<Fornecedor> fornecedores;
	
	
	
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
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
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
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		if(categorias == null) {
			categorias = new ArrayList<Categoria>();
		}
		this.categorias = categorias;
	}
	public List<Fornecedor> getFornecedores() {
		if(fornecedores == null) {
			fornecedores = new ArrayList<Fornecedor>();
		}
		return fornecedores;
	}
	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	public void addCategoria (Categoria cat) {
		getCategorias().add(cat);
	}
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", categoria=" + categoria
				+ ", quantidade=" + quantidade + ", fornecedor=" + fornecedor + ", peso=" + peso + ", comprimento="
				+ comprimento + ", altura=" + altura + ", largura=" + largura + ", diametro=" + diametro + ", formato="
				+ formato + ", categorias=" + categorias + ", fornecedores=" + fornecedores + "]";
	}
	
	
	
	
}
