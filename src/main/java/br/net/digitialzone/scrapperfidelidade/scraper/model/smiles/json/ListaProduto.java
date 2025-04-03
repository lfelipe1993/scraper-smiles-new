package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ListaProduto {

    @SerializedName("itens")
    private List<Produto> produtos;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
    
   
}
