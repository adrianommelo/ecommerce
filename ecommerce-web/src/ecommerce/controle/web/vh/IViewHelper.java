
package ecommerce.controle.web.vh;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ecommerce.core.aplicacao.Resultado;
import ecommerce.dominio.EntidadeDominio;


public interface IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request);
	
	public void setView(Resultado resultado, 
			HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException;
	
}
