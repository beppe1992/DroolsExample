package com.sample.complexpojo.pojo;

public enum TipoCliente {

	CORRENTISTA(1, "CORRENTISTA BANCA"), DIPENDENTE_ARCA(2, "DIPENDENTE ARCA"), DIPENDENTE_BANCA(
			3, "DIPENDENTE BANCA"), ALTRO(4, "ALTRO");

	private int codice;
	private String descrizione;

	TipoCliente(int codice, String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public int getCodice() {
		return codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

}
