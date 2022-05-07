package interfaz;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import dominio.Avion;
import dominio.Azafata;
import dominio.Pasajero;
import dominio.Persona;
import dominio.Piloto;
import dominio.Vuelo;

public class TestAerolinea {


	/*
	 * una aerolinea maneja informacion de pasajeros, vuelo y personal. para los
	 * pasajeros se considera de interes el pasaporte y los vuelos comprados. para
	 * los vuelos, el nro de vuelo, fecha, hora, ciudad donde escala, personal
	 * asignado y avion. para los aviones se considera modelo, fabricante,
	 * capacidad, hangar y tipo de avion, para el personal, el nombre y apellido,
	 * area asignada y para los pilotos la cantidad de horas de vuelo y el tipo de
	 * avion que pilotea
	 */

	@Test
	public void queSePuedaCrearUnVuelo() {
		String nombreAvion = "pepito", modelo = "Samsung", fabricante = "Marcelo Tinelli";
		Integer capacidad = 600, codHangar = 22;
		Avion avion = new Avion(nombreAvion, modelo, fabricante, capacidad, codHangar);

		String nombre = "Juan", apellido = "Perez";
		Integer dni = 45832, matricula = 3278, cantidadHorasDeVuelo = 90;
		Persona persona = new Piloto(nombre, apellido, dni, avion, matricula, cantidadHorasDeVuelo);

		Integer nroVuelo = 205;
		LocalDate fecha = LocalDate.of(2022, 05, 04);
		String ciudadDondeEscala = "San Benito";
		Vuelo vuelo = new Vuelo(nroVuelo, fecha, ciudadDondeEscala, persona, avion);

		vuelo.agregarPersona(persona);
		vuelo.agregarAvion(avion);

		Integer valorEsperado = 1;
		Integer valorObtenido = vuelo.obtenerCantidadDePersonas();
		assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void queAlVueloSeLePuedaAsignarUnPiloto() {
		
		
	}

	@Test
	public void queAlVueloSeLePuedaAsignarUnAvion() {
	}

	@Test
	public void queNoSePuedanAgregarMasDeDosPilotos() {
	}

	@Test
	public void queSePuedaSubirUnPasajeroAlAvion() {
		String nombre = "Susana", apellido = "Perez";
		Integer dni = 54332, pasaporte = 3284820, vuelosComprados = 5;
		Persona pasajero = new Pasajero(nombre, apellido, dni, pasaporte, vuelosComprados);

		String nombreAvion = "pepito", modelo = "Samsung", fabricante = "Marcelo Tinelli";
		Integer capacidad = 600, codHangar = 22;
		Avion avion = new Avion(nombreAvion, modelo, fabricante, capacidad, codHangar);

		avion.agregarPasajerosAlAvion(pasajero);

		Integer cantidadDePasajerosEnElAvionEsperados = 1;
		Integer cantidadDePasajaerosResultado = avion.obtenerCantidadDePersonas();

		assertEquals(cantidadDePasajerosEnElAvionEsperados, cantidadDePasajaerosResultado);
	}

	@Test
	public void queNoSePuedaAsignarMasDeCuatroAzafatasAlAvion() {
	}

	@Test
	public void queNoSePuedaAsignasMasPasajerosQueLaCapacidadMaximaDelAvion() {
		Persona pasajero = new Pasajero("joaquin", "caamaño", 443418877, 45324, 5);
		Persona pasajero2 = new Pasajero("lula", "redondo", 55654167, 443243, 9);
		Persona azafata = new Azafata("manuela", "josefa", 77889221);

		Avion avion = new Avion("avion 32", "chupapija", "onu", 600, 001);

		Persona piloto = new Piloto("maria", "avalos", 228735613, avion, 4431, 50);

		avion.agregarPasajerosAlAvion(pasajero);
		avion.agregarPasajerosAlAvion(pasajero2);
		avion.agregarPasajerosAlAvion(piloto);
		avion.agregarPasajerosAlAvion(azafata);

		Integer cantidadDePersonasDentroDelAvion = 3;
		Integer cantidadDePersonasResultado = avion.obtenerCantidadDePersonas();

		assertEquals(cantidadDePersonasDentroDelAvion, cantidadDePersonasResultado);

	}

	@Test
	public void queAUnPasajeroSeLeAsigneUnAsientoDeVuelo() {
	}

}
