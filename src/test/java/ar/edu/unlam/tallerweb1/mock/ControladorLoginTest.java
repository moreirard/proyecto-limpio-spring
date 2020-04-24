package ar.edu.unlam.tallerweb1.mock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.controladores.ControladorLogin;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.servicios.ServicioLogin;

public class ControladorLoginTest {

	private ControladorLogin controladorLogin = new ControladorLogin();

	@Test
	public void validarLoginSiUsuarioNoExisteDeberíaRedirigirALoginYMostarMenmsajeDeError() {

		Usuario usuario = null;
		HttpServletRequest request = null;
		
		ServicioLogin servicio = mock(ServicioLogin.class);
		controladorLogin.setServivioLogin(servicio);
// Una u otra:		controladorLogin = new ControladorLogin(servicio);
		
		
		
		when(servicio.consultarUsuario(usuario)).thenReturn(null);

		ModelAndView mav = controladorLogin.validarLogin(usuario, request); //ex
		
		assertThat(mav.getViewName()).isEqualTo("login"); //V
		assertThat(mav.getModelMap()).containsKey("error");
	//	assertThat(mav.getModelMap()).containsValue("error");
		//assertThat(mav.getModelMap()).get("error").isEqualTo("Usuario o clave incorrecta");
		assertThat(mav.getModelMap().get("error")).isEqualTo("Usuario o clave incorrecta");
	}

	@Test
	public void validarLoginSiUsuarioExisteDeberíaRedirigirALogin() {

		Usuario usuario = null;
		HttpServletRequest request = null;
//		request = mock(HttpServet)
		HttpSession sesion = mock(HttpSession.class);
		ServicioLogin servicio = mock(ServicioLogin.class);
		controladorLogin.setServivioLogin(servicio);
// Una u otra:		controladorLogin = new ControladorLogin(servicio);
		
		
		
		when(servicio.consultarUsuario(usuario)).thenReturn(new Usuario());
		when(request.getSession()).thenReturn(sesion);
		ModelAndView mav = controladorLogin.validarLogin(usuario, request); //ex
	
		assertThat(mav.getViewName()).isEqualTo("redirect:/home"); //V
	//	assertThat(mav.getModelMap()).containsKey("error");
	//	assertThat(mav.getModelMap()).containsValue("error");
		//assertThat(mav.getModelMap()).get("error").isEqualTo("Usuario o clave incorrecta");
//		assertThat(mav.getModelMap().get("error")).isEqualTo("Usuario o clave incorrecta");
	}

	
}
