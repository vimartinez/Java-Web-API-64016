package jsf;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class Saludo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje = "Saludo desde JSF";
	
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


}
