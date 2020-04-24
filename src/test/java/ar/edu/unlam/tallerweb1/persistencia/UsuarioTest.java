package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.SpringTest;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.*;

public class UsuarioTest extends SpringTest{
	
	//guarda un usuario y lo busca
	@Test
	@Transactional
	@ Rollback
	public void crearUsuarioYBuscarloPorId(){
	
		Usuario usuario = new Usuario();
		usuario.setEmail("sss");
		
		getSession().save(usuario);
		
		Usuario buscado = getSession().get(Usuario.class, usuario.getId());
		
		assertThat(buscado.getId()).isEqualTo(usuario.getId());
	}

}
