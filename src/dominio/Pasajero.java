package dominio;

public class Pasajero extends Persona {

	private Boolean pasaporte; // el pasaporte consta de 3 letras y numeros
	private Integer vuelosComprados;

	public Pasajero(String nombre, String apellido, Integer dni, Boolean pasaporte, Integer vuelosComprados) {
		super(nombre, apellido, dni);
		this.pasaporte = pasaporte;
		this.vuelosComprados = vuelosComprados;
		
	}

	
	// SETTERS Y GETTERS
	public Boolean getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(Boolean pasaporte) {
		this.pasaporte = pasaporte;
	}

	public Integer getVuelosComprados() {
		return vuelosComprados;
	}

	public void setVuelosComprados(Integer vuelosComprados) {
		this.vuelosComprados = vuelosComprados;
	}
}
