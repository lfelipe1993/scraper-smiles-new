package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import com.google.gson.annotations.SerializedName;

public class BonusPlanoClube {
    @SerializedName("codigoPlanoClube")
    private String codigoPlanoClube;
    @SerializedName("nomePlanoClube")
    private String nomePlanoClube;
    @SerializedName("valorBonus")
    private double valorBonus;
    @SerializedName("fatorConversaoBonus")
    private double fatorConversaoBonus;

    // getters e setters omitidos
}