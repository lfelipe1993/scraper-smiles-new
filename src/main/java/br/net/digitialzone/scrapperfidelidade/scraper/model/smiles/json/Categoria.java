package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import com.google.gson.annotations.SerializedName;

public class Categoria {
    @SerializedName("name")
    private String name;
    @SerializedName("categoryId")
    private String categoryId;
    @SerializedName("parentCategoryId")
    private String parentCategoryId;

    // getters e setters omitidos
}
