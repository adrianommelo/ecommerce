
package ecommerce.dominio;



public class Cliente extends Pessoa {

	private String cpf;

	/**
	 * Método de recuperação do campo cpf
	 *
	 * @return valor do campo cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * Valor de cpf atribuído a cpf
	 *
	 * @param cpf Atributo da Classe
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
}
