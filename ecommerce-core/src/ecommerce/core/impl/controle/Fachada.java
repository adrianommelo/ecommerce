package ecommerce.core.impl.controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ecommerce.core.IDAO;
import ecommerce.core.IFachada;
import ecommerce.core.IStrategy;
import ecommerce.core.aplicacao.Resultado;
import ecommerce.core.impl.dao.ClienteFisicoDAO;
import ecommerce.core.impl.dao.ClienteJuricoDAO;
import ecommerce.core.impl.dao.ProdutoDAO;
import ecommerce.core.impl.dao.TesteDAO;
import ecommerce.core.impl.negocio.ComplementarDtCadastro;
import ecommerce.core.impl.negocio.ValidadorCnpj;
import ecommerce.core.impl.negocio.ValidadorCpf;
import ecommerce.core.impl.negocio.ValidadorDadosObrigatoriosFornecedor;
import ecommerce.core.impl.negocio.ValidadorQtdProduto;
import ecommerce.dominio.ClienteFisico;
import ecommerce.dominio.ClienteJuridico;
import ecommerce.dominio.EntidadeDominio;
import ecommerce.dominio.Produto;

public class Fachada implements IFachada {

	/** 
	 * Mapa de DAOS, será indexado pelo nome da entidade 
	 * O valor é uma instância do DAO para uma dada entidade; 
	 */
	private Map<String, IDAO> daos;
	
	/**
	 * Mapa para conter as regras de negócio de todas operações por entidade;
	 * O valor é um mapa que de regras de negócio indexado pela operação
	 */
	private Map<String, Map<String, List<IStrategy>>> rns;
	
	private Resultado resultado;
	
	
	public Fachada(){
		
		/* Intânciando o Map de DAOS */
		daos = new HashMap<String, IDAO>();
		/* Intânciando o Map de Regras de Negócio */
		rns = new HashMap<String, Map<String, List<IStrategy>>>();
		
		/* Criando instâncias dos DAOs a serem utilizados*/
		ClienteJuricoDAO forDAO = new ClienteJuricoDAO();
		ClienteFisicoDAO cliDAO = new ClienteFisicoDAO();
		ProdutoDAO proDAO = new ProdutoDAO();
		
//		TesteDAO testeDAO = new TesteDAO();
		
		/* Adicionando cada dao no MAP indexando pelo nome da classe */
		daos.put(ClienteJuridico.class.getName(), forDAO);
		daos.put(ClienteFisico.class.getName(), cliDAO);
			//daos.put(Teste.class.getName(), testeDAO);		
		daos.put(Produto.class.getName(), proDAO);
		
		
		/* Criando instâncias de regras de negócio a serem utilizados*/		
		ValidadorDadosObrigatoriosFornecedor vrDadosObrigatoriosFornecedor = new ValidadorDadosObrigatoriosFornecedor();
		ValidadorCnpj vCnpj = new ValidadorCnpj();
		ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();
		ValidadorCpf vCpf = new ValidadorCpf();
		ValidadorQtdProduto vQtd = new ValidadorQtdProduto();
		
		/* Criando uma lista para conter as regras de negócio de fornencedor
		 * quando a operação for salvar
		 */
		List<IStrategy> rnsSalvarFornecedor = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do fornecedor*/
		rnsSalvarFornecedor.add(vrDadosObrigatoriosFornecedor);
		rnsSalvarFornecedor.add(vCnpj);
		rnsSalvarFornecedor.add(cDtCadastro);
		
		/* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação  do fornecedor
		 */
		Map<String, List<IStrategy>> rnsFornecedor = new HashMap<String, List<IStrategy>>();
		/*
		 * Adiciona a listra de regras na operação salvar no mapa do fornecedor (lista criada na linha 70)
		 */
		rnsFornecedor.put("SALVAR", rnsSalvarFornecedor);	
		
		/* Adiciona o mapa(criado na linha 79) com as regras indexadas pelas operações no mapa geral indexado 
		 * pelo nome da entidade
		 */
		rns.put(ClienteJuridico.class.getName(), rnsFornecedor);
		
		
		
		
		/* Criando uma lista para conter as regras de negócio de cliente
		 * quando a operação for salvar
		 */
		List<IStrategy> rnsSalvarCliente = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do cliente */
		rnsSalvarCliente.add(cDtCadastro);		
		rnsSalvarCliente.add(vCpf);
		
		/* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação do cliente
		 */
		Map<String, List<IStrategy>> rnsCliente = new HashMap<String, List<IStrategy>>();
		/*
		 * Adiciona a listra de regras na operação salvar no mapa do cliente (lista criada na linha 93)
		 */
		rnsCliente.put("SALVAR", rnsSalvarCliente);		
		/* Adiciona o mapa(criado na linha 101) com as regras indexadas pelas operações no mapa geral indexado 
		 * pelo nome da entidade. Observe que este mapa (rns) é o mesmo utilizado na linha 88.
		 */
		rns.put(ClienteFisico.class.getName(), rnsCliente);
		
		//Regra para Teste
		
		/* Criando uma lista para conter as regras de negócio de cliente
		 * quando a operação for salvar
		 */
		//List<IStrategy> rnsSalvarTeste = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do cliente */
		//rnsSalvarTeste.add(cDtCadastro);		
		
		/* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação do cliente
		 */
//		Map<String, List<IStrategy>> rnsTeste = new HashMap<String, List<IStrategy>>();
//		/*
//		 * Adiciona a listra de regras na operação salvar no mapa do cliente (lista criada na linha 93)
//		 */
//		rnsTeste.put("SALVAR", rnsSalvarTeste);		
//		/* Adiciona o mapa(criado na linha 101) com as regras indexadas pelas operações no mapa geral indexado 
//		 * pelo nome da entidade. Observe que este mapa (rns) é o mesmo utilizado na linha 88.
//		 */
//		rns.put(Teste.class.getName(), rnsTeste);
//		
		//
		
		/* Criando uma lista para conter as regras de negócio de produto
		 * quando a operação for salvar
		 */
		List<IStrategy> rnsSalvarProduto = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do produto */
		rnsSalvarProduto.add(cDtCadastro);		
		rnsSalvarProduto.add(vQtd);
		
		/* Criando uma lista para conter as regras de negócio de produto
		 * quando a operação for alterar
		 */
		List<IStrategy> rnsAlterarProduto = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação alterar do produto */
		rnsAlterarProduto.add(vQtd);
		
		/* Cria o mapa que poderá conter todas as listas de regras de negócio específica 
		 * por operação do produto
		 */
		Map<String, List<IStrategy>> rnsProduto = new HashMap<String, List<IStrategy>>();
		/*
		 * Adiciona a listra de regras na operação salvar no mapa do produto (lista criada na linha 114)
		 */
		rnsProduto.put("SALVAR", rnsSalvarProduto);
		/*
		 * Adiciona a listra de regras na operação alterar no mapa do produto (lista criada na linha 122)
		 */
		rnsProduto.put("ALTERAR", rnsAlterarProduto);
		
		/* Adiciona o mapa(criado na linha 129) com as regras indexadas pelas operações no mapa geral indexado 
		 * pelo nome da entidade. Observe que este mapa (rns) é o mesmo utilizado na linha 88.
		 */
		rns.put(Produto.class.getName(), rnsProduto);
		
	}
	
	
	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "SALVAR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.salvar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "ALTERAR");
	
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.alterar(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "EXCLUIR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "EXCLUIR");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				
				resultado.setEntidades(dao.consultar(entidade));
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar a consulta!");
				
			}
		}else{
			resultado.setMsg(msg);
			
		}
		
		return resultado;

	}
	
	@Override
	public Resultado visualizar(EntidadeDominio entidade) {
		resultado = new Resultado();
		resultado.setEntidades(new ArrayList<EntidadeDominio>(1));
		resultado.getEntidades().add(entidade);		
		return resultado;

	}

	
	private String executarRegras(EntidadeDominio entidade, String operacao){
		String nmClasse = entidade.getClass().getName();		
		StringBuilder msg = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = rns.get(nmClasse);
		
		
		if(regrasOperacao != null){
			List<IStrategy> regras = regrasOperacao.get(operacao);
			
			if(regras != null){
				for(IStrategy s: regras){			
					String m = s.processar(entidade);			
					
					if(m != null){
						msg.append(m);
						msg.append("\n");
					}			
				}	
			}			
			
		}
		
		if(msg.length()>0)
			return msg.toString();
		else
			return null;
	}
}
