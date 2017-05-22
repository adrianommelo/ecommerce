
package ecommerce.controle.web.command.impl;

import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.EntidadeDominio;


public class ConsultarCommand extends AbstractCommand{

	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.consultar(entidade);
	}

}
