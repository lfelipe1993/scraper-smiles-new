package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Segmento {
    @SerializedName("segmento")
    private String segmento;
    @SerializedName("valorReais")
    private double valorReais;
    @SerializedName("valorReaisReferencia")
    private double valorReaisReferencia;
    @SerializedName("valoresAcumulo")
    private List<Acumulo> valoresAcumulo;
    @SerializedName("valoresResgate")
    private List<Resgate> valoresResgate;
    @SerializedName("valoresBonusPlanoClube")
    private List<BonusPlanoClube> valoresBonusPlanoClube;
	public String getSegmento() {
		return segmento;
	}
	public double getValorReais() {
		return valorReais;
	}
	public double getValorReaisReferencia() {
		return valorReaisReferencia;
	}
	public List<Acumulo> getValoresAcumulo() {
		return valoresAcumulo;
	}
	public List<Resgate> getValoresResgate() {
		return valoresResgate;
	}
	public List<BonusPlanoClube> getValoresBonusPlanoClube() {
		return valoresBonusPlanoClube;
	}
    
	
}