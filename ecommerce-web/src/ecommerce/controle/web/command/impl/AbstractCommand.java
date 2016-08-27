
package ecommerce.controle.web.command.impl;

import ecommerce.controle.web.command.ICommand;
import ecommerce.core.IFachada;
import ecommerce.core.impl.controle.Fachada;



public abstract class AbstractCommand implements ICommand {

	protected IFachada fachada = new Fachada();

}
