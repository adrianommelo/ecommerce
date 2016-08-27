
package ecommerce.controle.web.command.impl;

import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.EntidadeDominio;


public class ExcluirCommand extends AbstractCommand{

	
	public Resultado execute(EntidadeDominio entidade) {
		
		return fachada.excluir(entidade);
	}

}
