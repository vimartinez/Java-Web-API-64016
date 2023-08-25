package jsf;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@RequestScoped
@ManagedBean
@SessionScoped
public class UserBean {
	
	private User usuario = new User();
	
	public String iniciarSesion() {
		//emula un inicio de sesion
		
		System.out.println("el usuario recibido es " + usuario.getUserName());
		//origen de datos
		Map<String,String> listaUsuarios = new HashMap<>();
		listaUsuarios.put("User1", "1234");
		listaUsuarios.put("User2", "1234");
		listaUsuarios.put("User3", "123456");
		listaUsuarios.put("User4", "1234");
		
		for (Entry<String,String> element : listaUsuarios.entrySet()) {
			String clave = element.getKey();
			String valor = element.getValue();
			
			if(clave.equals(usuario.getUserName()) && valor.equals(usuario.getPassword())) {
				System.out.println("usuario logeado exitosamente");
				return "home";
			}
			
		}
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage("user", new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario o clave incorrectos", null));
		return null;
		
	}

	public User getUsuario() {
		return usuario;
	}

	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	
	

}
