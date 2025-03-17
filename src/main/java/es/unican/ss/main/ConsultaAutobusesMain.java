package es.unican.ss.main;

import java.util.List;

import es.unican.ss.business.IConsultaAutobuses;
import es.unican.ss.client.ConsultaAutobusesService;
import es.unican.ss.client.DatosNoDisponibles_Exception;
import es.unican.ss.client.ParadaNoValida_Exception;

public class ConsultaAutobusesMain {

	public static void main(String[] args) throws DatosNoDisponibles_Exception, ParadaNoValida_Exception {
		
		//Creo el servicio
		ConsultaAutobusesService servicio = new ConsultaAutobusesService();
		
		//Obtengo el puero del servicio web
		es.unican.ss.client.IConsultaAutobuses stub = servicio.getConsultaAutobusesPort();
		
		List<Object> resultado = stub.consultaTUS("1", "CORREOS");
		
		String consulta =String.format("Primer TUS: %d (%s);\nSegundo TUS: %d (%s);",
                resultado.get(0), resultado.get(1), resultado.get(2), resultado.get(3));
		
		System.out.println(consulta);
		
	}
}
