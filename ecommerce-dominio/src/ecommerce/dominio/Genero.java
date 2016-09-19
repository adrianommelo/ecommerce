package ecommerce.dominio;

public class Genero extends EntidadeDominio {

	public static final int FEMININO = 1;
	public static final int MASCULINO = 2;
	public static final int OUTRO = 3;
	
	private String genero;

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
