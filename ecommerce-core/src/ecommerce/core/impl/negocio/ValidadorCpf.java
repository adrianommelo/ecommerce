package ecommerce.core.impl.negocio;

import ecommerce.core.IStrategy;
import ecommerce.dominio.ClienteFisico;
import ecommerce.dominio.EntidadeDominio;

public class ValidadorCpf implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof ClienteFisico){
			ClienteFisico c = (ClienteFisico)entidade;
			
			if(c.getCpf().length() < 9){
				return "CPF deve conter 14 digitos!";
			}
			
		}else{
			return "CPF não pode ser válidado, pois entidade não é um cliente!";
		}
		
		
		return null;
	}

}
