package com.sample.complexpojo.pojo;

/**
 * Classe pojo utilizzata nelle regole
 * 
 * @author arx50011
 * 
 */
public class InputCalcolaPremio {

	private DatiContraente datiContraente;
	private int numeroGaranziePolizza = 0;

	// risposta
	private Sconto sconto;

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
