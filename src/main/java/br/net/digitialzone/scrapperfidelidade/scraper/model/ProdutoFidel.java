package br.net.digitialzone.scrapperfidelidade.scraper.model;

import java.io.Serializable;

import br.net.digitialzone.scrapperfidelidade.scraper.model.general.ProductList;

public class ProdutoFidel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String productTitleNew;
	private String precoSemClubeNew;
	private String precoClubeNew;
	private String fornecidoByNew;

	private String productTitle;
	private String productId;
	private String productSku;
	
	private String precoSemClube;
	private String precoComClube;

	private String fornecidoBy="SMILES";

	private String buyButton;
	private Integer coringa=0;
	
	private ProductList productList;
	
	public ProdutoFidel() {
		// TODO Auto-generated constructor stub
	}

	public ProdutoFidel(String productTitleNew, String precoSemClubeNew, String precoClubeNew, String fornecidoByNew,
			String productTitle, String productId, String productSku, String precoSemClube, String precoClube,
			String fornecidoBy, String buyButton, ProductList productList) {
		this.productTitleNew = productTitleNew;
		this.precoSemClubeNew = precoSemClubeNew;
		this.precoClubeNew = precoClubeNew;
		this.fornecidoByNew = fornecidoByNew;
		this.productTitle = productTitle;
		this.productId = productId;
		this.productSku = productSku;
		this.precoSemClube = precoSemClube;
		this.precoComClube = precoClube;
		this.fornecidoBy = fornecidoBy;
		this.buyButton = buyButton;
		this.productList = productList;
	}

	public void setProductTitleNew(String productTitleNew) {
		this.productTitleNew = productTitleNew;
	}

	public void setPrecoSemClubeNew(String precoSemClubeNew) {
		this.precoSemClubeNew = precoSemClubeNew;
	}

	public void setPrecoClubeNew(String precoClubeNew) {
		this.precoClubeNew = precoClubeNew;
	}

	public void setFornecidoByNew(String fornecidoByNew) {
		this.fornecidoByNew = fornecidoByNew;
	}
	
	//-----------------------------------------------------------------

	public String getProductTitle() {
		return productTitle == "" || productTitle == null ? productTitleNew : productTitle;
	}

	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductSku() {
		return productSku;
	}

	public void setProductSku(String productSku) {
		this.productSku = productSku;
	}

	public String getPrecoSemClube() {
		return precoSemClube == "" || precoSemClube == null ? precoSemClubeNew : precoSemClube;
	}

	public void setPrecoSemClube(String precoSemClube) {
		this.precoSemClube = precoSemClube;
	}

	public String getPrecoComClube() {
		return precoComClube == "" || precoComClube == null ? precoClubeNew : precoComClube;
	}

	public void setPrecoComClube(String precoClube) {
		this.precoComClube = precoClube;
	}

	public String getFornecidoBy() {
		return fornecidoBy == "" || precoComClube == null ? fornecidoByNew : fornecidoBy;
	}

	public void setFornecidoBy(String fornecidoBy) {
		this.fornecidoBy = fornecidoBy;
	}

	public String getBuyButton() {
		return buyButton;
	}

	public void setBuyButton(String buyButton) {
		this.buyButton = buyButton;
	}

	public ProductList getProductList() {
		return productList;
	}

	public void setProductList(ProductList productList) {
		this.productList = productList;
	}
	
	public Integer getCoringa() {
		return coringa;
	}

	public void setCoringa(Integer coringa) {
		this.coringa = coringa;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ScrapedProduct [productTitleNew=");
		builder.append(productTitleNew);
		builder.append(", precoSemClubeNew=");
		builder.append(precoSemClubeNew);
		builder.append(", precoClubeNew=");
		builder.append(precoClubeNew);
		builder.append(", fornecidoByNew=");
		builder.append(fornecidoByNew);
		builder.append(", productTitle=");
		builder.append(productTitle);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", productSku=");
		builder.append(productSku);
		builder.append(", precoSemClube=");
		builder.append(precoSemClube);
		builder.append(", precoComClube=");
		builder.append(precoComClube);
		builder.append(", fornecidoBy=");
		builder.append(fornecidoBy);
		builder.append(", buyButton=");
		builder.append(buyButton);
		builder.append(", coringa=");
		builder.append(coringa);
		builder.append(", productList=");
		builder.append(productList);
		builder.append("]");
		return builder.toString();
	}

}
