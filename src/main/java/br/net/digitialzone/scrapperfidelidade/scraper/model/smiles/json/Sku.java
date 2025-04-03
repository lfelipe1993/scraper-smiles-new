package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Sku {
    @SerializedName("idSkuGopoints")
    private String idSkuGopoints;
    @SerializedName("idSkuFornecedor")
    private String idSkuFornecedor;
    @SerializedName("nome")
    private String nome;
    @SerializedName("imagens")
    private List<Imagem> imagens;
    @SerializedName("valoresCanal")
    private List<Canal> valoresCanal;
	public String getIdSkuGopoints() {
		return idSkuGopoints;
	}
	public void setIdSkuGopoints(String idSkuGopoints) {
		this.idSkuGopoints = idSkuGopoints;
	}
	public String getIdSkuFornecedor() {
		return idSkuFornecedor;
	}
	public void setIdSkuFornecedor(String idSkuFornecedor) {
		this.idSkuFornecedor = idSkuFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public List<Imagem> getImagens() {
		return imagens;
	}
	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}
	public List<Canal> getValoresCanal() {
		return valoresCanal;
	}
	public void setValoresCanal(List<Canal> valoresCanal) {
		this.valoresCanal = valoresCanal;
	}

    // getters e setters omitidos
}
