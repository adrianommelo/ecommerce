package ecommerce.core.impl.negocio;

import ecommerce.core.IStrategy;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Produto;

public class ValidadorQtdProduto implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Produto){
			Produto c = (Produto)entidade;
			
			if(c.getQuantidade() < 1){
				return "Quantidade deve ser no minimo 1!";
			}
			
		}else{
			return "Quantidade não pode ser válidado, pois entidade não é um produto!";
		}
		
		
		return null;
	}

}
