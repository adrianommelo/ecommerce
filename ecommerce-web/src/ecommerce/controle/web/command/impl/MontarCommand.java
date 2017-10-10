package ecommerce.controle.web.command.impl;

import ecommerce.controle.web.command.ICommand;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.EntidadeDominio;

public class MontarCommand extends AbstractCommand {

	public Resultado execute(EntidadeDominio entidade) {
		return fachada.montar(entidade);
	}

}
