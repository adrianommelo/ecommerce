package ecommerce.dominio;

import java.util.HashMap;
import java.util.Map;

public class Formato extends EntidadeDominio{

	public static final int CAIXA = 1;
	public static final int ENVELOPE = 2;
	private String formato;
	private Map<Integer, String> formatos = new HashMap<Integer, String>();
	
	public Formato () {
		getFormatos().put(1, "Caixa");
		getFormatos().put(2, "Envelope");
	}

	public Map<Integer, String> getFormatos() {
		return formatos;
	}

	public void setFormatos(Map<Integer, String> formatos) {
		this.formatos = formatos;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}
}
