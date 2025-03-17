package es.unican.ss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EstimacionLinea {
	
	@JsonProperty("ayto:paradaId")
	private String id;
	
	@JsonProperty("ayto:tiempo1")
	private int tiempo1;
	
	@JsonProperty("ayto:tiempo2")
	private int tiempo2;
	
	
	public EstimacionLinea () {
		
	}
	
	
	@Override
	public String toString() {
		return "EstimacionLinea [id=" + id + ", tiempo1=" + tiempo1 + ", tiempo2=" + tiempo2 + ", ]";
	}


	public EstimacionLinea (String id, int tiempo1, int tiempo2, String nombre, String linea) {
		this.id = id;
		this.tiempo1 = tiempo1;
		this.tiempo2 = tiempo2;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getTiempo1() {
		return tiempo1;
	}

	public void setTiempo1(int tiempo1) {
		this.tiempo1 = tiempo1;
	}

	public int getTiempo2() {
		return tiempo2;
	}

	public void setTiempo2(int tiempo2) {
		this.tiempo2 = tiempo2;
	}

	
	

}
