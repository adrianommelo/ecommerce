package ecommerce.core.impl.negocio;

import ecommerce.core.IStrategy;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.ClienteJuridico;

public class ValidadorDadosObrigatoriosFornecedor implements IStrategy{

	@Override
	public String processar(EntidadeDominio entidade) {
		
		if(entidade instanceof ClienteJuridico){
			ClienteJuridico clienteJuridico = (ClienteJuridico)entidade;
			
			String nome = clienteJuridico.getNome();
			String logradouro = clienteJuridico.getEndereco().getLogradouro();
			String cnpj = clienteJuridico.getCnpj();
			String cidade = clienteJuridico.getEndereco().getCidade().getNome();
			
			if(nome == null || logradouro == null || cnpj==null || cidade == null){
				return "Nome, logradouro, CNPJ e cidade s�o de preenchimento obrigat�rio!";
			}
			
			if(nome.trim().equals("") || logradouro.trim().equals("") || 
					cnpj.trim().equals("")|| cidade.trim().equals("")){
				return "Nome, logradouro, CNPJ e cidade s�o de preenchimento obrigat�rio!";
			}
			
		}else{
			return "Deve ser registrado um fornecedor!";
		}
		
		
		return null;
	}

}
