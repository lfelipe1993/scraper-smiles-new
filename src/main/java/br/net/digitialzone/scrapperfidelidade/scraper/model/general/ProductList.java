package br.net.digitialzone.scrapperfidelidade.scraper.model.general;

import java.io.Serializable;

public class ProductList implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String url;
	private String productName;
	private Double milesValue;
	private Integer ativo;
	
	private MilesProgram milesProgram = new MilesProgram();
	private Product product = new Product();
	
	public ProductList() {
		// TODO Auto-generated constructor stub
	}

	public ProductList(Integer id, String url, String productName, Double milesValue, Integer ativo) {
		this.id = id;
		this.url = url;
		this.productName = productName;
		this.setMilesValue(milesValue);
		this.ativo = ativo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public MilesProgram getMilesProgram() {
		return milesProgram;
	}

	public void setMilesProgram(MilesProgram milesProgram) {
		this.milesProgram = milesProgram;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Double getMilesValue() {
		return milesValue;
	}

	public void setMilesValue(Double milesValue) {
		this.milesValue = milesValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductList other = (ProductList) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductList [id=");
		builder.append(id);
		builder.append(", url=");
		builder.append(url);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", milesValue=");
		builder.append(milesValue);
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append(", milesProgram=");
		builder.append(milesProgram);
		builder.append(", product=");
		builder.append(product);
		builder.append("]");
		return builder.toString();
	}


}
