package ar.edu.unlam.tallerweb1.modelo;

public class Parcial {
	private Integer nota;

	public void recuperar(Integer nota) {
		this.nota = nota;
	}

	public Integer obtenerNota() {
		return this.nota;
	}

	public Boolean estaAprobado() {
		return this.nota >= 4;
	}

	public Boolean estaPromocionado() {
		return this.nota >= 7;
	}

}
