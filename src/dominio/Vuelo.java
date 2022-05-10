package dominio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Vuelo {

	private Integer nroVuelo;
	private LocalDateTime fecha;
	private String origen;
	private String destino;
	private Avion tipoDeAvion;
	private Persona personalAsignado;

	private ArrayList<Persona> personas = new ArrayList<>();
	private ArrayList<Avion> asientos = new ArrayList<>();
	private ArrayList<Avion> vuelo = new ArrayList<>();

	private Integer cantidadDeAsientosLibres;

	public Vuelo(Integer nroVuelo, LocalDateTime fecha, String origen, String destino, Persona personalAsignado,
			Avion tipoDeAvion) {
		this.nroVuelo = nroVuelo;
		this.fecha = fecha;
		this.origen = origen;
		this.destino = destino;
		this.personalAsignado = personalAsignado;
		this.tipoDeAvion = tipoDeAvion;
	}

	public Integer obtenerCantidadDePersonas() {
		return this.personas.size();
	}

	public Boolean agregarPasajero(Persona pasajero) {
		Boolean sePudoAgregar = false;
		if (pasajero instanceof Pasajero) {
			if (obtenerCantidadDePersonas() < cantidadDeAsientosLibres) {
				personas.add(pasajero);
				sePudoAgregar = true;
			}
		}
		return sePudoAgregar;
//		if(asientos.size() < cantidadDeAsientosLibres) {
//			this.asientos.addAll((Collection<? extends Avion>) persona);
//		}

	}

	public void agregarAvion(Avion avion) {
		this.vuelo.add(avion);

	}

	// SETTERS Y GETTERS

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Integer getNroVuelo() {
		return nroVuelo;
	}

	public void setNroVuelo(Integer nroVuelo) {
		this.nroVuelo = nroVuelo;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
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
