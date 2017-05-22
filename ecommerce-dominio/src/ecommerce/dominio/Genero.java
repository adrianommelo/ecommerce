package ecommerce.dominio;

import java.util.HashMap;
import java.util.Map;

public class Genero extends EntidadeDominio {

	public static final int FEMININO = 1;
	public static final int MASCULINO = 2;
	public static final int OUTRO = 3;
	private String genero;
	private Map<Integer, String> generos = new HashMap<Integer, String>();
	
	public Genero (){
		getGeneros().put(1, "Feminino");
		getGeneros().put(2, "Masculino");
		getGeneros().put(3, "Outro");
	}
	

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}


	/**
	 * @return the generos
	 */
	public Map<Integer, String> getGeneros() {
		return generos;
	}


	/**
	 * @param generos the generos to set
	 */
	public void setGeneros(Map<Integer, String> generos) {
		this.generos = generos;
	}

}
