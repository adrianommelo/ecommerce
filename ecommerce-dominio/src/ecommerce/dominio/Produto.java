
package ecommerce.dominio;


public class Produto extends EntidadeDominio {

	private String descricao;
	private int quantidade;
	/**
	 * Método de recuperação do campo descricao
	 *
	 * @return valor do campo descricao
	 */
	public String getDescricao() {
		return descricao;
	}
	/**
	 * Valor de descricao atribuído a descricao
	 *
	 * @param descricao Atributo da Classe
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	/**
	 * Método de recuperação do campo quantidade
	 *
	 * @return valor do campo quantidade
	 */
	public int getQuantidade() {
		return quantidade;
	}
	/**
	 * Valor de quantidade atribuído a quantidade
	 *
	 * @param quantidade Atributo da Classe
	 */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
