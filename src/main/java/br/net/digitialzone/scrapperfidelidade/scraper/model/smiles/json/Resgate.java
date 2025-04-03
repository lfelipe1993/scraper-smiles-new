package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import com.google.gson.annotations.SerializedName;

public class Resgate {
	@SerializedName("codigoCategoriaPrograma")
	private String codigoCategoriaPrograma;

	@SerializedName("valorPontos")
	private Double valorPontos;

	public String getCodigoCategoriaPrograma() {
		return codigoCategoriaPrograma;
	}

	public Double getValorPontos() {
		return valorPontos;
	}
}