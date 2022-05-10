package interfaz;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

		// CODIGO DE IVAN
		/*
		 * String origen = "Buenos Aires"; String destino = "Cancun"; Integer nro = 12;
		 * LocalDate fecha = LocalDate.of(2022, Month.MAY, 04); LocalTime hora =
		 * LocalTime.of(9, 30);
		 * 
		 * Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);
		 * 
		 * Integer idVuelo = 1;
		 * 
		 * assertEquals(idVuelo, vuelo.getId());
		 */

		// que el mio esté largo es al re pedo pero necesito verlo asi por ahora

		// AVION
		String nombreAvion = "Super avion", modelo = "Airbus", fabricante = "Marcelo Tinelli";
		Integer capacidad = 1000, codHangar = 220;
		Avion avion = new Avion(nombreAvion, modelo, fabricante, capacidad, codHangar);

		// PASAJERO
		String nombrePasajero = "Juan", apellidoPasajero = "Perez", pasaporte = "1x23a45b6";
		Integer dniPasajero = 12345678, vuelosComprados = 3;
		Persona pasajero = new Pasajero(nombrePasajero, apellidoPasajero, dniPasajero, pasaporte, vuelosComprados);

		// PESONAL
		String nombrePiloto = "Susana", apellidoPiloto = "Pelotuda";
		Integer dniPiloto = 18371038, matricula = 0012356, horasEnVuelo = 50;
		Persona piloto = new Piloto(nombrePiloto, apellidoPiloto, dniPiloto, avion, matricula, horasEnVuelo);

		// VUELO
		Integer nroVuelo = 205;
		LocalDateTime fecha = LocalDateTime.of(2019, 10, 10, 11, 25); // (año, mes, dia, hora, minuto)
		String origen = "Bueos Aires", destino = "Mendoza";
		Vuelo vuelo = new Vuelo(nroVuelo, fecha, origen, destino, piloto, avion);
		
		vuelo.agregarPasajero(pasajero);
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
		/*String origen = "Buenos Aires";
		String destino = "Cancun";
		Integer nro = 12;
		LocalDate fecha = LocalDate.of(2022, Month.MAY, 04);
		LocalTime hora = LocalTime.of(9, 30);

		Integer nroDeAvion = 520;
		String modelo = "Boing 747";
		String fabricante = "Airbuss";
		Integer capacidad = 200;

		Avion avion = new Avion(nroDeAvion, modelo, fabricante, capacidad);

		Vuelo vuelo = new Vuelo(nro, fecha, hora, origen, destino);

		String nombre = "Humanos unidos";

		Aerolinea aerolinea = new Aerolinea(nombre);

		aerolinea.agregarVuelo(vuelo);

		aerolinea.agregarAvion(avion, vuelo.getId());

		assertEquals(avion, aerolinea.buscarVueloPorId(vuelo.getId()).getAvion());*/
		
		Avion avioncito = new Avion("Avion", "Being", "Mora Avalos", 800, 306);
		Persona azafata = new Azafata("Pablo", "Caamano", 443215742);
		Vuelo vuelito = new Vuelo(304, LocalDateTime.of(2022, 10, 26, 22,30), "Buenos Aires", "Usuahia", azafata, avioncito);
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
