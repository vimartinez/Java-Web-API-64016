package com.educacionit.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usr = request.getParameter("mail");
		String clave = request.getParameter("clave");
		
		Usuario usuarioIngresado = validarUsuario(usr, clave);
		if (usuarioIngresado != null) {
			//generación del objetos sesion
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("usuario", usr);
			httpSession.setAttribute("Mensaje", "Objeto Sesion");
			httpSession.setAttribute("sesionActiva", "1");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else {
			request.setAttribute("mensajeError", "Los datos ingresados no corresponden con un usuario del sistema");
			request.getRequestDispatcher("formulario.jsp").forward(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private Usuario validarUsuario(String mail, String clave) {
		
		//Emular acceso a bd y validación de usuario
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(new Usuario("Lionel Messi", "lionel@gmail.com","1234qwer"));
		usuarios.add(new Usuario("José Gomez", "jose@gmail.com","1234qwer"));
		usuarios.add(new Usuario("Maria Perez", "maria@gmail.com","1234qwer"));
		
		for (Usuario usuario : usuarios) {
			if ((usuario.getNombreUsuario().equalsIgnoreCase(mail) && (usuario.getClave().equals(clave)))) {
				return usuario;
			}
		}
		
		return null;
	}

}
