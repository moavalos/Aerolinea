package dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Vuelo {

	
	private Integer nroVuelo;
	private LocalDate fecha;
	private String ciudadDondeEscala;
	private Avion tipoDeAvion;
	private Persona personalAsignado;
	
	private ArrayList<Persona> personas = new ArrayList<>();
	private ArrayList<Avion> asientos = new ArrayList<>();
	private ArrayList<Avion> vuelo = new ArrayList<>();
	private Integer cantidadDeAsientosLibres;

	public Vuelo(Integer nroVuelo, LocalDate fecha, String ciudadDondeEscala, 
			Persona personalAsignado, Avion tipoDeAvion) {
		this.nroVuelo = nroVuelo;
		this.fecha = fecha;
		this.ciudadDondeEscala = ciudadDondeEscala;
		this.personalAsignado = personalAsignado;
		this.tipoDeAvion = tipoDeAvion;
	}

	public void agregarPersona(Persona persona) {
		if(asientos.size() < cantidadDeAsientosLibres) {
			this.asientos.addAll((Collection<? extends Avion>) persona);
		}
		
	}

	public void agregarAvion(Avion avion) {
		this.vuelo.add(avion);
		
	}

	public Integer obtenerCantidadDePersonas() {
		return this.personas.size();
	}

	public Integer getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(Integer nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public String getCiudadDondeEscala() {
		return ciudadDondeEscala;
	}

	public void setCiudadDondeEscala(String ciudadDondeEscala) {
		this.ciudadDondeEscala = ciudadDondeEscala;
	}

	public Avion getTipoDeAvion() {
		return tipoDeAvion;
	}

	public void setTipoDeAvion(Avion tipoDeAvion) {
		this.tipoDeAvion = tipoDeAvion;
	}

	public Persona getPersonalAsignado() {
		return personalAsignado;
	}

	public void setPersonalAsignado(Persona personalAsignado) {
		this.personalAsignado = personalAsignado;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(ArrayList<Persona> personas) {
		this.personas = personas;
	}

	public ArrayList<Avion> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Avion> asientos) {
		this.asientos = asientos;
	}

	public ArrayList<Avion> getVuelo() {
		return vuelo;
	}

	public void setVuelo(ArrayList<Avion> vuelo) {
		this.vuelo = vuelo;
	}

	public Integer getCantidadDeAsientosLibres() {
		return cantidadDeAsientosLibres;
	}

	public void setCantidadDeAsientosLibres(Integer cantidadDeAsientosLibres) {
		this.cantidadDeAsientosLibres = cantidadDeAsientosLibres;
	}

}
