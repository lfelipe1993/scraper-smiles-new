package br.net.digitialzone.scrapperfidelidade.scraper.model.general;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String shortName;
	private Double targetPrice;
	private Double MilesValue;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	public Product(Product product) {
		this.id = product.getId();
		this.shortName = product.getShortName();
		this.targetPrice = product.getTargetPrice();
		this.MilesValue = product.getMilesValue();
	}

	public Product(Integer id, String shortName, Double targetPrice, Double milesValue) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.targetPrice = targetPrice;
		MilesValue = milesValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Double getTargetPrice() {
		return targetPrice;
	}

	public void setTargetPrice(Double targetPrice) {
		this.targetPrice = targetPrice;
	}

	public Double getMilesValue() {
		return MilesValue;
	}

	public void setMilesValue(Double milesValue) {
		MilesValue = milesValue;
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
		Product other = (Product) obj;
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
		builder.append("Product [id=");
		builder.append(id);
		builder.append(", shortName=");
		builder.append(shortName);
		builder.append(", targetPrice=");
		builder.append(targetPrice);
		builder.append(", MilesValue=");
		builder.append(MilesValue);
		builder.append("]");
		return builder.toString();
	}
	
	

}
