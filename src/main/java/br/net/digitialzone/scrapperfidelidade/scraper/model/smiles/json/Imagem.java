package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import com.google.gson.annotations.SerializedName;

public class Imagem {
    @SerializedName("url")
    private String url;
    @SerializedName("ordemExibicao")
    private int ordemExibicao;

    // getters e setters omitidos
}