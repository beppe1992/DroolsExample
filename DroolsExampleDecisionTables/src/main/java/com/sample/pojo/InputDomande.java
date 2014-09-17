package com.sample.pojo;

import java.util.Date;

/**
 * Classe pojo utilizzata nelle regole
 * 
 * @author valerio.martini
 * 
 */
public class InputDomande {

	private int age = 0;
	private String gender = null;
	private String rispostaAccettate = null;
	private Date dataAttivazioneDomanda = null;

	private String risposta = null;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDataAttivazioneDomanda() {
		return dataAttivazioneDomanda;
	}

	public void setDataAttivazioneDomanda(Date dataAttivazioneDomanda) {
		this.dataAttivazioneDomanda = dataAttivazioneDomanda;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public String getRispostaAccettate() {
		return rispostaAccettate;
	}

	public void setRispostaAccettate(String rispostaAccettate) {
		this.rispostaAccettate = rispostaAccettate;
	}

}
