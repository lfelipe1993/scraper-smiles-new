package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles;

import java.util.Objects;

public class UtilValuesScraped implements  Comparable<UtilValuesScraped> {

	private String nomeProduto;
	private String idProdutoFornecedor;
	private String codigoFornecedor;
	private String idSkuFornecedor;
	private Double valorResgatePontos;
	private Double valorEmReais;
	private Double valorAcumuloPontos;

	private Boolean isAcumuloAvaliable;
	private Boolean isRegateAvaliable;

	public UtilValuesScraped() {

	}
	
	//auxilio na importacao
	public UtilValuesScraped(ImportTest iT) {
		this.nomeProduto = iT.getNome();
		this.idProdutoFornecedor = iT.getIdSellerProduto();
		this.codigoFornecedor = iT.getIdSellerProduto();
		this.idSkuFornecedor = iT.getSkuProduto();
		this.valorResgatePontos = 0.00;
		this.valorEmReais = 0.00;
		this.valorAcumuloPontos = 0.00;
		this.isAcumuloAvaliable = Boolean.FALSE;
		this.isRegateAvaliable = Boolean.FALSE;

	}

	public UtilValuesScraped(String nomeProduto, String idProdutoFornecedor, String codigoFornecedor,
			String idSkuFornecedor, Double valorResgatePontos, Double valorEmReais, Double valorAcumuloPontos,
			Boolean isAcumuloAvaliable, Boolean isRegateAvaliable) {

		this.nomeProduto = nomeProduto;
		this.idProdutoFornecedor = idProdutoFornecedor;
		this.codigoFornecedor = codigoFornecedor;
		this.idSkuFornecedor = idSkuFornecedor;
		this.valorResgatePontos = valorResgatePontos;
		this.valorEmReais = valorEmReais;
		this.valorAcumuloPontos = valorAcumuloPontos;
		this.isAcumuloAvaliable = isAcumuloAvaliable;
		this.isRegateAvaliable = isRegateAvaliable;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getIdProdutoFornecedor() {
		return idProdutoFornecedor;
	}

	public void setIdProdutoFornecedor(String idProdutoFornecedor) {
		this.idProdutoFornecedor = idProdutoFornecedor;
	}

	public String getCodigoFornecedor() {
		return codigoFornecedor;
	}

	public void setCodigoFornecedor(String codigoFornecedor) {
		this.codigoFornecedor = codigoFornecedor;
	}

	public String getIdSkuFornecedor() {
		return idSkuFornecedor;
	}

	public void setIdSkuFornecedor(String idSkuFornecedor) {
		this.idSkuFornecedor = idSkuFornecedor;
	}

	public Double getValorResgatePontos() {
		return valorResgatePontos /1000;
	}

	public void setValorResgatePontos(Double valorResgatePontos) {
		this.valorResgatePontos = valorResgatePontos;
	}

	public Double getValorEmReais() {
		return valorEmReais;
	}

	public void setValorEmReais(Double valorEmReais) {
		this.valorEmReais = valorEmReais;
	}

	public Double getValorAcumuloPontos() {
		return valorAcumuloPontos /1000;
	}

	public void setValorAcumuloPontos(Double valorAcumuloPontos) {
		this.valorAcumuloPontos = valorAcumuloPontos;
	}

	public Boolean getIsAcumuloAvaliable() {
		return isAcumuloAvaliable;
	}

	public void setIsAcumuloAvaliable(Boolean isAcumuloAvaliable) {
		this.isAcumuloAvaliable = isAcumuloAvaliable;
	}

	public Boolean getIsRegateAvaliable() {
		return isRegateAvaliable;
	}

	public void setIsRegateAvaliable(Boolean isRegateAvaliable) {
		this.isRegateAvaliable = isRegateAvaliable;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UtilValuesScraped [nomeProduto=");
		builder.append(nomeProduto);
		builder.append(", idProdutoFornecedor=");
		builder.append(idProdutoFornecedor);
		builder.append(", codigoFornecedor=");
		builder.append(codigoFornecedor);
		builder.append(", idSkuFornecedor=");
		builder.append(idSkuFornecedor);
		builder.append(", valorResgatePontos=");
		builder.append(valorResgatePontos);
		builder.append(", valorEmReais=");
		builder.append(valorEmReais);
		builder.append(", valorAcumuloPontos=");
		builder.append(valorAcumuloPontos);
		builder.append(", isAcumuloAvaliable=");
		builder.append(isAcumuloAvaliable);
		builder.append(", isRegateAvaliable=");
		builder.append(isRegateAvaliable);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoFornecedor, idSkuFornecedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UtilValuesScraped other = (UtilValuesScraped) obj;
		return Objects.equals(codigoFornecedor, other.codigoFornecedor)
				&& Objects.equals(idSkuFornecedor, other.idSkuFornecedor);
	}

	@Override
	public int compareTo(UtilValuesScraped o) {
		  // Primeiro compara o ID
        int comp = this.idSkuFornecedor.compareTo(o.idSkuFornecedor);
        if (comp == 0) {
            // Se o ID for igual, compara o SKU
            return this.codigoFornecedor.compareTo(o.codigoFornecedor);
        }
        return comp;
	}



}
