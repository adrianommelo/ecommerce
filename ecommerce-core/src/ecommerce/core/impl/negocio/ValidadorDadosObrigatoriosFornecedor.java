package ecommerce.core.impl.negocio;

import ecommerce.core.IStrategy;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Fornecedor;

public class ValidadorDadosObrigatoriosFornecedor implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof Fornecedor){
			Fornecedor fornecedor = (Fornecedor)entidade;
			
			String nome = fornecedor.getNome();
			String logradouro = fornecedor.getEndereco().getLogradouro();
			String cnpj = fornecedor.getCnpj();
			String cidade = fornecedor.getEndereco().getCidade().getNome();
			
			if(nome == null || logradouro == null || cnpj==null || cidade == null){
				return "Nome, logradouro, CNPJ e cidade são de preenchimento obrigatório!";
			}
			
			if(nome.trim().equals("") || logradouro.trim().equals("") || 
					cnpj.trim().equals("")|| cidade.trim().equals("")){
				return "Nome, logradouro, CNPJ e cidade são de preenchimento obrigatório!";
			}
			
		}else{
			return "Deve ser registrado um fornecedor!";
		}
		
		
		return null;
	}

}
