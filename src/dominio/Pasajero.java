package dominio;

public class Pasajero extends Persona {

	private Integer pasaporte;
	private Integer vuelosComprados;

	public Pasajero(String nombre, String apellido, Integer dni, Integer pasaporte, Integer vuelosComprados) {
		super(nombre, apellido, dni);
		this.pasaporte = pasaporte;
		this.vuelosComprados = vuelosComprados;
		
	}

	public Integer getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Integer pasaporte) {
		this.pasaporte = pasaporte;
	}

	public Integer getVuelosComprados() {
		return vuelosComprados;
	}

	public void setVuelosComprados(Integer vuelosComprados) {
		this.vuelosComprados = vuelosComprados;
	}
}
