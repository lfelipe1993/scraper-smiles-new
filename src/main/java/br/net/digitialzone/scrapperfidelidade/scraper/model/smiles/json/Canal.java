package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Canal {
    @SerializedName("tipoCanal")
    private String tipoCanal;
    @SerializedName("valoresModalidade")
    private List<Modalidade> valoresModalidade;
	public String getTipoCanal() {
		return tipoCanal;
	}
	public void setTipoCanal(String tipoCanal) {
		this.tipoCanal = tipoCanal;
	}
	public List<Modalidade> getValoresModalidade() {
		return valoresModalidade;
	}
	public void setValoresModalidade(List<Modalidade> valoresModalidade) {
		this.valoresModalidade = valoresModalidade;
	}

    // getters e setters omitidos
}