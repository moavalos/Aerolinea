package dominio;

public class Pasajero extends Persona {

	private String pasaporte; // el pasaporte consta de 3 letras y numeros
	private Integer vuelosComprados;

	public Pasajero(String nombre, String apellido, Integer dni, String pasaporte, Integer vuelosComprados) {
		super(nombre, apellido, dni);
		this.pasaporte = pasaporte;
		this.vuelosComprados = vuelosComprados;
		
	}

	
	// SETTERS Y GETTERS
	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public Integer getVuelosComprados() {
		return vuelosComprados;
	}

	public void setVuelosComprados(Integer vuelosComprados) {
		this.vuelosComprados = vuelosComprados;
	}
}
