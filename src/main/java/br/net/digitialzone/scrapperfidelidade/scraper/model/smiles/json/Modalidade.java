package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Modalidade {
    @SerializedName("modalidade")
    private String modalidade;
    @SerializedName("valoresSegmento")
    private List<Segmento> valoresSegmento;
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
	public List<Segmento> getValoresSegmento() {
		return valoresSegmento;
	}
	public void setValoresSegmento(List<Segmento> valoresSegmento) {
		this.valoresSegmento = valoresSegmento;
	}

    // getters e setters omitidos
}