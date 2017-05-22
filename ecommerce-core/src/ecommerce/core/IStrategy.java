package ecommerce.core;

import ecommerce.dominio.EntidadeDominio;


public interface IStrategy 
{

	public String processar(EntidadeDominio entidade);
	
}
