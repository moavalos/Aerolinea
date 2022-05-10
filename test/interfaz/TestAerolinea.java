package interfaz;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dominio.Aerolinea;
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
		String nombrePasajero = "Juan", apellidoPasajero = "Perez";
		Boolean pasaporte = true;
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
	public void queAlVueloSeLePuedaAsignarUnAvion() {
		Avion avioncito = new Avion("Avion", "Being", "Mora Avalos", 800, 306);
		Persona azafata = new Azafata("Pablo", "Caamano", 443215742);
		Vuelo vuelito = new Vuelo(304, LocalDateTime.of(2022, 10, 26, 22, 30), "Buenos Aires", "Usuahia", azafata,
				avioncito);
		Aerolinea aerolinea = new Aerolinea("Aerolineas Argentinas");

		aerolinea.agregarVuelo(vuelito);
		aerolinea.agregarAvion(avioncito, vuelito.getId());
		assertEquals(avioncito, aerolinea.buscarAvionPorId(vuelito.getId()).getCodHangar());

	}

	@Test
	public void queNoSePuedanAgregarMasDeDosPilotos() {

		ArrayList<Persona> personalGeneral = new ArrayList<>();

		Avion avioncito = new Avion("Avion", "Being", "Mora Avalos", 800, 306);
		Persona azafata = new Azafata("Juliana", "Borrego", 442299771);
		Persona piloto1 = new Piloto("Julian", "Forza", 5852620, avioncito, 33972, 80);
		Persona piloto2 = new Piloto("Pepepito", "No se", 5852255, avioncito, 382109, 4);

		personalGeneral.add(azafata);
		personalGeneral.add(piloto1);
		personalGeneral.add(piloto2);

		Vuelo vuelito = new Vuelo(304, LocalDateTime.of(2022, 10, 26, 22, 30), "Buenos Aires", "Usuahia", azafata,
				avioncito);
		Aerolinea aerolinea = new Aerolinea("Aerolinea Haedo");

		aerolinea.agregarVuelo(vuelito);
		aerolinea.agregarAvion(avioncito, vuelito.getId());
		aerolinea.agregarPesonalAlVuelo(personalGeneral, vuelito);

		Integer cantPersonal = 2;
		assertEquals(cantPersonal, vuelito.getCantDePersonal());
	}

	@Test
	public void queSePuedaSubirUnPasajeroAlAvion() {
		String nombre = "Susana", apellido = "Perez";
		Integer dni = 54332, vuelosComprados = 5;
		Boolean pasaporte = true;
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

		ArrayList<Persona> personalGeneral = new ArrayList<>();

		Avion avioncito = new Avion("Avion", "Being", "Mora Avalos", 800, 306);
		Persona azafata1 = new Azafata("Laila", "Perez", 63991472);
		Persona azafata2 = new Azafata("Maria", "Hown", 585222);
		Persona azafata3 = new Azafata("Julieta", "Hown", 585282);
		Persona azafata4 = new Azafata("Julian", "Hown", 58522);
		Persona azafata5 = new Azafata("Rouz", "Hown", 585282);
		Persona piloto1 = new Piloto("Julian", "Forza", 585220, avioncito, 55331, 50);

		personalGeneral.add(azafata1);
		personalGeneral.add(azafata2);
		personalGeneral.add(azafata3);
		personalGeneral.add(azafata4);
		personalGeneral.add(azafata5);
		personalGeneral.add(piloto1);

		Vuelo vuelito = new Vuelo(304, LocalDateTime.of(2022, 10, 26, 22, 30), "Buenos Aires", "Usuahia", piloto1,
				avioncito);
		Aerolinea aerolinea = new Aerolinea("nopuedomas");

		aerolinea.agregarVuelo(vuelito);
		aerolinea.agregarAvion(avioncito, vuelito.getId());
		aerolinea.agregarPesonalAlVuelo(personalGeneral, vuelito);

		Integer cantPersonal = 5;
		assertEquals(cantPersonal, vuelito.getCantDePersonal());
	}

	@Test
	public void queNoSePuedaAsignasMasPasajerosQueLaCapacidadMaximaDelAvion() {
		Persona pasajero = new Pasajero("joaquin", "caamaño", 443418877, false, 5);
		Persona pasajero2 = new Pasajero("lula", "redondo", 55654167, true, 9);
		Persona azafata = new Azafata("manuela", "josefa", 77889221);

		Avion avion = new Avion("avion 32", "chupapija", "onu", 600, 001);

		Persona piloto = new Piloto("maria", "avalos", 228735613, avion, 4431, 50);

		avion.agregarPasajerosAlAvion(pasajero);
		avion.agregarPasajerosAlAvion(pasajero2);
		avion.agregarPasajerosAlAvion(piloto);
		avion.agregarPasajerosAlAvion(azafata);

		Integer cantidadDePersonasDentroDelAvion = 4;
		Integer cantidadDePersonasResultado = avion.obtenerCantidadDePersonas();

		assertEquals(cantidadDePersonasDentroDelAvion, cantidadDePersonasResultado);

	}

	@Test
	public void queAUnPasajeroSeLeAsigneUnAsientoDeVuelo() {
		Pasajero pasajero = new Pasajero("lula", "circulo", 442237108, true, 10);
		Avion avion = new Avion("avion 32", "chupapija", "onu", 600, 001);
		ArrayList<Persona> personalGeneral = new ArrayList<>();

		Persona azafata = new Azafata("juana", "pelotuda", 92548163);
		Persona piloto1 = new Piloto("Julian", "forza", 585220, avion, 743219, 0);
		Persona piloto2 = new Piloto("Julian", "Hown", 585220, avion, 4442, 30);

		personalGeneral.add(azafata);
		personalGeneral.add(piloto1);
		personalGeneral.add(piloto2);
		avion.contarAsientos();

		Vuelo vuelo = new Vuelo(441, LocalDateTime.of(2022, 10, 26, 22, 30), "Mendoza", "Cordoba", piloto1, avion);

		String nombreAero = "Humanos unidos";
		Aerolinea aerolinea = new Aerolinea(nombreAero);

		aerolinea.agregarVuelo(vuelo);
		aerolinea.agregarAvion(avion, vuelo.getId());
		aerolinea.agregarPesonalAlVuelo(personalGeneral, vuelo);

		Integer asiento = 1;
		Boolean sePudo = true;
		assertEquals(sePudo, aerolinea.comprarVuelo(pasajero, vuelo, asiento));

	}

}
