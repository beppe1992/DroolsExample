package com.sample.complexpojo.pojo;

import java.util.List;

/**
 * Classe pojo utilizzata nelle regole
 * 
 * @author arx50011
 * 
 */
public class InputCalcolaPremio {

	private DatiContraente datiContraente;
	private int numeroGaranziePolizza = 0;
	private List<String> garanzie;

	/**
	 * Metodo che data una garanzia che fa sconto controlla che sia presente
	 * all'interno della lista delle garanzie di polizza
	 * 
	 * @param garanziaSconto
	 * @return
	 */
	public boolean contains(String garanziaSconto) {
		for (String s : garanzie) {
			if (s.equals(garanziaSconto)) {
				return true;
			}
		}
		return false;
	}

	// risposta
	private Sconto sconto;

	public List<String> getGaranzie() {
		return garanzie;
	}

	public void setGaranzie(List<String> garanzie) {
		this.garanzie = garanzie;
	}

	public int getNumeroGaranziePolizza() {
		return numeroGaranziePolizza;
	}

	public void setNumeroGaranziePolizza(int numeroGaranziePolizza) {
		this.numeroGaranziePolizza = numeroGaranziePolizza;
	}

	public DatiContraente getDatiContraente() {
		return datiContraente;
	}

	public void setDatiContraente(DatiContraente datiContraente) {
		this.datiContraente = datiContraente;
	}

	public Sconto getSconto() {
		return sconto;
	}

	public void setSconto(Sconto sconto) {
		this.sconto = sconto;
	}

}
