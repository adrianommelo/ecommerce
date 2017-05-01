package ecommerce.dominio;

import java.util.HashMap;
import java.util.Map;

public class Categoria extends EntidadeDominio {

	public static final int SMARTPHONE = 1;	
	public static final int COMPUTADOR = 2;	
	public static final int TABLET = 3;	
	public static final int VIDEOGAME = 4;
	private String categoria;
	private Map<Integer, String> categorias = new HashMap<Integer, String>();
	
	public Categoria(){
		getCategorias().put(1, "Smartphone");
		getCategorias().put(2, "Computador");
		getCategorias().put(3, "Tablet");
		getCategorias().put(4, "Video Game");
	}

	public Map<Integer, String> getCategorias() {
		return categorias;
	}

	public void setCategorias(Map<Integer, String> categorias) {
		this.categorias = categorias;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
}
