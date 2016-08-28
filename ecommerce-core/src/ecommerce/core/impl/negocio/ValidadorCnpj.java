package ecommerce.core.impl.negocio;

import ecommerce.core.IStrategy;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.ClienteJuridico;

public class ValidadorCnpj implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof ClienteJuridico){
			ClienteJuridico clienteJuridico = (ClienteJuridico)entidade;
			
			if(clienteJuridico.getCnpj().length() < 14){
				return "CNPJ deve conter 14 digitos!";
			}
			
		}else{
			return "CNPJ n�o pode ser v�lidado, pois entidade n�o � um fornecedor!";
		}
		
		
		return null;
	}

}
