package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import com.google.gson.annotations.SerializedName;

public class Fornecedor {

	    @SerializedName("idFornecedor")
	    private int idFornecedor;
	    @SerializedName("nome")
	    private String nome;
	    @SerializedName("imagemLogo")
	    private String imagemLogo;
	    @SerializedName("codigoFornecedor")
	    private String codigoFornecedor;
	    @SerializedName("tipoFrete")
	    private String tipoFrete;
	    @SerializedName("temDuplaCustodiaPendente")
	    private boolean temDuplaCustodiaPendente;
	    @SerializedName("hasResgate")
	    private boolean hasResgate;
	    @SerializedName("hasAcumulo")
	    private boolean hasAcumulo;
		public int getIdFornecedor() {
			return idFornecedor;
		}
		public void setIdFornecedor(int idFornecedor) {
			this.idFornecedor = idFornecedor;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getImagemLogo() {
			return imagemLogo;
		}
		public void setImagemLogo(String imagemLogo) {
			this.imagemLogo = imagemLogo;
		}
		public String getCodigoFornecedor() {
			return codigoFornecedor;
		}
		public void setCodigoFornecedor(String codigoFornecedor) {
			this.codigoFornecedor = codigoFornecedor;
		}
		public String getTipoFrete() {
			return tipoFrete;
		}
		public void setTipoFrete(String tipoFrete) {
			this.tipoFrete = tipoFrete;
		}
		public boolean isTemDuplaCustodiaPendente() {
			return temDuplaCustodiaPendente;
		}
		public void setTemDuplaCustodiaPendente(boolean temDuplaCustodiaPendente) {
			this.temDuplaCustodiaPendente = temDuplaCustodiaPendente;
		}
		public boolean isHasResgate() {
			return hasResgate;
		}
		public void setHasResgate(boolean hasResgate) {
			this.hasResgate = hasResgate;
		}
		public boolean isHasAcumulo() {
			return hasAcumulo;
		}
		public void setHasAcumulo(boolean hasAcumulo) {
			this.hasAcumulo = hasAcumulo;
		}

	    // getters e setters omitidos
	
}
