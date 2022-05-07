package dominio;

import java.util.ArrayList;

public class Avion {


	private String nombre;
	private String modelo;
	private String fabricante;
	private Integer capacidad;
	private Integer codHangar;

	private Integer cantidadPasajeros;
	private ArrayList<Persona> pasajeros = new ArrayList<>();

	public Avion(String nombre, String modelo, String fabricante, Integer capacidad, Integer codHangar) {
		this.nombre = nombre;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.capacidad = capacidad;
		this.codHangar = codHangar;

	}

	public void agregarPasajerosAlAvion(Persona pasajero) {
		if (cantidadPasajeros < capacidad) {
			pasajeros.add(pasajero);
		}

	}

	public Integer obtenerCantidadDePersonas() {
		return this.pasajeros.size();

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getCodHangar() {
		return codHangar;
	}

	public void setCodHangar(Integer codHangar) {
		this.codHangar = codHangar;
	}

}
