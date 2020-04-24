package ar.edu.unlam.tallerweb1.mock;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

import ar.edu.unlam.tallerweb1.modelo.Parcial;

public class ParcialTest {
	@Test
	public void testQueSePuedaCrearUnParcialSinNota() {
		Parcial parcial = new Parcial();
		assertThat(parcial.obtenerNota().equals(0));

	}
}

