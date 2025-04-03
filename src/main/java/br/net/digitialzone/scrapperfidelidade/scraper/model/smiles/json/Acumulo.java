package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import com.google.gson.annotations.SerializedName;

public class Acumulo {
    @SerializedName("nomeCategoriaPrograma")
    private String nomeCategoriaPrograma;
    @SerializedName("codigoCategoriaPrograma")
    private String codigoCategoriaPrograma;
    @SerializedName("valorAcumulo")
    private double valorAcumulo;
    @SerializedName("isRegraPromocional")
    private boolean isRegraPromocional;
    @SerializedName("fatorConversaoAcumulo")
    private double fatorConversaoAcumulo;
	public String getNomeCategoriaPrograma() {
		return nomeCategoriaPrograma;
	}
	public void setNomeCategoriaPrograma(String nomeCategoriaPrograma) {
		this.nomeCategoriaPrograma = nomeCategoriaPrograma;
	}
	public String getCodigoCategoriaPrograma() {
		return codigoCategoriaPrograma;
	}
	public void setCodigoCategoriaPrograma(String codigoCategoriaPrograma) {
		this.codigoCategoriaPrograma = codigoCategoriaPrograma;
	}
	public double getValorAcumulo() {
		return valorAcumulo;
	}
	public void setValorAcumulo(double valorAcumulo) {
		this.valorAcumulo = valorAcumulo;
	}
	public boolean isRegraPromocional() {
		return isRegraPromocional;
	}
	public void setRegraPromocional(boolean isRegraPromocional) {
		this.isRegraPromocional = isRegraPromocional;
	}
	public double getFatorConversaoAcumulo() {
		return fatorConversaoAcumulo;
	}
	public void setFatorConversaoAcumulo(double fatorConversaoAcumulo) {
		this.fatorConversaoAcumulo = fatorConversaoAcumulo;
	}

    // getters e setters omitidos
}