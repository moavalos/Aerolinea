package dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Avion {

	private String nombre;
	private String modelo;
	private String fabricante;
	private Integer capacidad;
	private Integer codHangar;

	private Integer cantidadPasajeros;
	private ArrayList<Persona> pasajeros = new ArrayList<>();

	private Integer id;

	public Avion(String nombre, String modelo, String fabricante, Integer capacidad, Integer codHangar) {
		this.nombre = nombre;
		this.modelo = modelo;
		this.fabricante = fabricante;
		this.capacidad = capacidad;
		this.codHangar = codHangar;
		this.id++;

	}

	public void agregarPasajerosAlAvion(Persona pasajero) {
		if (cantidadPasajeros < capacidad) {
			pasajeros.add(pasajero);
		}

	}

	public void contarAsientos() {
		Integer asientoNumero = 1;
		for (int i = 0; i < this.capacidad; i++) {
			this.capacidad.put(asientoNumero, null);
			asientoNumero++;
		}

	}

	public Boolean ocuparAsiento(Integer numeroAsiento, Persona pasajero) {
		// ESTO SIRVE PARA RECORRER UN MAP. ENTRY ALMACENADA CADA UNO DE LOS VALORES DEL
		// MAPA. PERO EN EL MAPA PONGO .ENTRYSET() PORQUE ASI SE PODRA VER TODO LO QUE
		// TIENE EL MAPA
		// ES UNA VISTA QUE A SU VEZ ES UNA COLLECION

		for (Map.Entry<Integer, Pasajero> asiento : capacidad.entrySet()) {
			Integer nroAsiento = asiento.getKey();
			Pasajero ocupado = asiento.getValue();
			if (nroAsiento.equals(numeroAsiento) && ocupado == null) {
				this.capacidad.put(nroAsiento, pasajero);
				return true;
			}

		}
		return false;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
