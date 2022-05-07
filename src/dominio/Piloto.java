package dominio;

public class Piloto extends Persona {

	private Avion tipoDeAvion;
	private Integer matricula;
	private Integer cantidadHorasDeVuelo;

	public Piloto(String nombre, String apellido, Integer dni, Avion tipoDeAvion, Integer matricula,
			Integer cantidadHorasDeVuelo) {
		super(nombre, apellido, dni);
		this.tipoDeAvion = tipoDeAvion;
		this.matricula = matricula;
		this.cantidadHorasDeVuelo = cantidadHorasDeVuelo;

	}

	public Avion getTipoDeAvion() {
		return tipoDeAvion;
	}

	public void setTipoDeAvion(Avion tipoDeAvion) {
		this.tipoDeAvion = tipoDeAvion;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Integer getCantidadHorasDeVuelo() {
		return cantidadHorasDeVuelo;
	}

	public void setCantidadHorasDeVuelo(Integer cantidadHorasDeVuelo) {
		this.cantidadHorasDeVuelo = cantidadHorasDeVuelo;
	}

}
