package es.unican.ss.business;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.unican.ss.domain.Autobus;
import es.unican.ss.domain.Autobuses;
import es.unican.ss.domain.DatosNoDisponibles;
import es.unican.ss.domain.EstimacionLinea;
import es.unican.ss.domain.EstimacionesLineas;
import es.unican.ss.domain.ParadaNoValida;
import es.unican.ss.soap.NumberConversion;
import es.unican.ss.soap.NumberConversionSoapType;
import jakarta.jws.WebService;

@WebService(endpointInterface = "es.unican.ss.business.IConsultaAutobuses")
public class ConsultaAutobuses implements IConsultaAutobuses {

	/**
	 * Consulta el tiempo estimado de llegada de un autob�s a una parada.
	 * 
	 * @param numeroLinea  N�mero de la l�nea de autob�s.
	 * @param nombreParada Nombre de la parada de autob�s.
	 * @return Informaci�n sobre los dos pr�ximos autobuses (en minutos y en
	 *         palabras).
	 * @throws DatosNoDisponibles Si no se pueden obtener los datos de la API.
	 * @throws ParadaNoValida     Si la parada o la l�nea no existen.
	 */
	public List<Object> consultaTUS(String numeroLinea, String nombreParada) throws DatosNoDisponibles, ParadaNoValida {
		// Declaración de variables.
		int tiempo1;
		int tiempo2;
		String textoTiempo1;
		String textoTiempo2;

		// Primero obtenemos el id de la parada
		String identificadorParada = obtenerIdentificadorAutobus(nombreParada);

		// Obtengo la estimación de la linea en la parada indicada.
		EstimacionLinea estimacionLinea = obtenerEstimacionLinea(identificadorParada, numeroLinea);

		// Obtengo de los tiempos y el texto de los tiempos
		tiempo1 = (estimacionLinea.getTiempo1()) / 60;
		tiempo2 = (estimacionLinea.getTiempo2()) / 60;

		// Convierto los int en bigInteger
		BigInteger bigTiempo1 = BigInteger.valueOf(tiempo1);
		BigInteger bigTiempo2 = BigInteger.valueOf(tiempo2);

		textoTiempo1 = obtenerTextoMinutos(bigTiempo1);
		textoTiempo2 = obtenerTextoMinutos(bigTiempo2);

		List<Object> resultado = new ArrayList<Object>();
		resultado.add(tiempo1);
		resultado.add(textoTiempo1);

		resultado.add(tiempo2);
		resultado.add(textoTiempo2);
		
		return resultado;

	}

	/**
	 * Convierte un n�mero de minutos en palabras.
	 * 
	 * @param tiempo N�mero de minutos.
	 * @return El n�mero en palabras.
	 */
	public String obtenerTextoMinutos(BigInteger tiempo) {
		// Creo el servicio
		NumberConversion servicio = new NumberConversion();

		// Creo el cliente SOAP.
		NumberConversionSoapType cliente = servicio.getNumberConversionSoap();

		return cliente.numberToWords(tiempo);
	}

	/**
	 * Obtiene la estimaci�n de llegada de los autobuses a una parada espec�fica.
	 * 
	 * @param identificadorParada ID de la parada de autob�s.
	 * @param numeroLinea         N�mero de la l�nea de autob�s.
	 * @return La estimaci�n de tiempos de paso de los autobuses.
	 * @throws ParadaNoValida     Si la l�nea no tiene estimaciones en esa parada.
	 * @throws DatosNoDisponibles Si hay problemas con la API.
	 */
	public EstimacionLinea obtenerEstimacionLinea(String identificadorParada, String numeroLinea)
			throws ParadaNoValida, DatosNoDisponibles {
		ObjectMapper mapperEstimacionLinea = new ObjectMapper();
		EstimacionesLineas estimaciones = null;

		try {
			String url = "http://datos.santander.es/api/rest/datasets/control_flotas_estimaciones.json?query=ayto\\:etiqLinea:" + numeroLinea;

			estimaciones = mapperEstimacionLinea.readValue(new URL(url), EstimacionesLineas.class);

			if (estimaciones == null || estimaciones.getEstimaciones() == null || estimaciones.getEstimaciones().isEmpty()) {
				throw new ParadaNoValida("No se encontraron datos de la línea " + numeroLinea);
			}

			for (EstimacionLinea e : estimaciones.getEstimaciones()) {
				if (e.getId().equalsIgnoreCase(identificadorParada)) {
					return e;
				}
			}

		} catch (IOException e) {
			throw new DatosNoDisponibles("Error al conectar con la API: " + e.getMessage());
		}
		return null;
	}
	/**
	 * Obtiene el identificador de una parada a partir de su nombre.
	 * 
	 * @param nombreParada Nombre de la parada de autob�s.
	 * @return ID de la parada de autob�s.
	 * @throws ParadaNoValida     Si la parada no existe.
	 * @throws DatosNoDisponibles Si hay problemas con la API.
	 */
	public String obtenerIdentificadorAutobus(String nombreParada) throws ParadaNoValida, DatosNoDisponibles {
		int idParada = -1;
		ObjectMapper mapperAutobuses = new ObjectMapper();

		try {
			Autobuses autobuses = mapperAutobuses.readValue(new URL("https://datos.santander.es/api/rest/datasets/paradas_bus.json"), Autobuses.class);



			for (Autobus a : autobuses.getAutobuses()) {
				if (a.getNombre().equalsIgnoreCase(nombreParada)) {

					return a.getId();

				}
			}


			if (idParada == -1) { // Si no se encontró la parada, lanza la excepción
				throw new ParadaNoValida("No se encontraron estimaciones para la l�nea " + nombreParada);

			}


		} catch (IOException e) {
			throw new DatosNoDisponibles("Error al conectar con la API: " + e.getMessage());
		}


		return null;
	}

}
