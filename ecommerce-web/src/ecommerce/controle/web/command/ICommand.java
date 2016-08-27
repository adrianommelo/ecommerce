
package ecommerce.controle.web.command;

import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.EntidadeDominio;


public interface ICommand {

	public Resultado execute(EntidadeDominio entidade);
	
}
