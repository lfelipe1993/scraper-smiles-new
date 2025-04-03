package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import br.net.digitialzone.scrapperfidelidade.scraper.model.ProductSmiles;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.MilesProgram;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Produto;
import br.net.digitialzone.scrapperfidelidade.utils.Utilidades;

public class TimeLineProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String idProduct;
	private String SkuProduct;
	private Double priceWithPoints;
	private Double priceWithMoney;
	private Double pointsToEarn;

	private String retailer;

	private Boolean isAcumuloAvailable;
	private Boolean isResgateAvailable;

	private Timestamp dateTime;

	private ProductSmiles productSmilesList;
	private MilesProgram milesProgram;

	public TimeLineProduct() {
		// TODO Auto-generated constructor stub
	}

	public TimeLineProduct(Produto scrapedProduct, ProductSmiles pSmiles, MilesProgram mp) {

		UtilValuesScraped uC = Utilidades.convertToUtilValues(scrapedProduct);

		this.idProduct = uC.getIdProdutoFornecedor();
		this.SkuProduct = uC.getIdSkuFornecedor();
		this.priceWithPoints = uC.getValorResgatePontos();
		this.priceWithMoney = uC.getValorEmReais();
		this.pointsToEarn = uC.getValorAcumuloPontos();
		this.retailer = uC.getCodigoFornecedor();
		this.isAcumuloAvailable = uC.getIsAcumuloAvaliable();
		this.isResgateAvailable = uC.getIsRegateAvaliable();

		this.dateTime = new Timestamp(System.currentTimeMillis());
		this.productSmilesList = pSmiles;
		this.setMilesProgram(mp);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}

	public String getSkuProduct() {
		return SkuProduct;
	}

	public void setSkuProduct(String skuProduct) {
		SkuProduct = skuProduct;
	}

	public Double getPriceWithPoints() {
		return priceWithPoints;
	}

	public void setPriceWithPoints(Double priceWithPoints) {
		this.priceWithPoints = priceWithPoints;
	}

	public Double getPriceWithMoney() {
		return priceWithMoney;
	}

	public void setPriceWithMoney(Double priceWithMoney) {
		this.priceWithMoney = priceWithMoney;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public ProductSmiles getproductSmilesList() {
		return productSmilesList;
	}

	public void setProductList(ProductSmiles productSmilesList) {
		this.productSmilesList = productSmilesList;
	}

	public Timestamp getDateTime() {
		return dateTime;
	}

	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}

	public Double getPointsToEarn() {
		return pointsToEarn;
	}

	public void setPointsToEarn(Double pointsToEarn) {
		this.pointsToEarn = pointsToEarn;
	}

	public Boolean getIsAcumuloAvailable() {
		return isAcumuloAvailable;
	}

	public void setIsAcumuloAvailable(Boolean isAcumuloAvailable) {
		this.isAcumuloAvailable = isAcumuloAvailable;
	}

	public Boolean getIsResgateAvailable() {
		return isResgateAvailable;
	}

	public void setIsResgateAvailable(Boolean isResgateAvailable) {
		this.isResgateAvailable = isResgateAvailable;
	}

	public MilesProgram getMilesProgram() {
		return milesProgram;
	}

	public void setMilesProgram(MilesProgram milesProgram) {
		this.milesProgram = milesProgram;
	}

	// ------------------------------------------------------------

	// checar se algum ta disponivel
	public Boolean getAnyAvailable() {
		return isResgateAvailable && isAcumuloAvailable;
	}
	
	public Double getValorAcumuloTotal() {
		return ( getPriceWithMoney() - (getPointsToEarn() * getMilesProgram().getMilesValue()));
	}
	
	public Double getValorPointsToMoney () {
		return ( (getPriceWithPoints() * getMilesProgram().getMilesValue()) );
	}

	// --------------------------------------------------------------------------------

	@Override
	public int hashCode() {
		return Objects.hash(SkuProduct, dateTime, id, idProduct, isAcumuloAvailable, isResgateAvailable, pointsToEarn,
				priceWithMoney, priceWithPoints, productSmilesList, retailer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimeLineProduct other = (TimeLineProduct) obj;
		return Objects.equals(SkuProduct, other.SkuProduct) && Objects.equals(dateTime, other.dateTime)
				&& Objects.equals(id, other.id) && Objects.equals(idProduct, other.idProduct)
				&& Objects.equals(isAcumuloAvailable, other.isAcumuloAvailable)
				&& Objects.equals(isResgateAvailable, other.isResgateAvailable)
				&& Objects.equals(pointsToEarn, other.pointsToEarn)
				&& Objects.equals(priceWithMoney, other.priceWithMoney)
				&& Objects.equals(priceWithPoints, other.priceWithPoints)
				&& Objects.equals(productSmilesList, other.productSmilesList)
				&& Objects.equals(retailer, other.retailer);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TimeLineProduct [id=");
		builder.append(id);
		builder.append(", idProduct=");
		builder.append(idProduct);
		builder.append(", SkuProduct=");
		builder.append(SkuProduct);
		builder.append(", priceWithPoints=");
		builder.append(priceWithPoints);
		builder.append(", priceWithMoney=");
		builder.append(priceWithMoney);
		builder.append(", pointsToEarn=");
		builder.append(pointsToEarn);
		builder.append(", retailer=");
		builder.append(retailer);
		builder.append(", isAcumuloAvailable=");
		builder.append(isAcumuloAvailable);
		builder.append(", isResgateAvailable=");
		builder.append(isResgateAvailable);
		builder.append(", dateTime=");
		builder.append(dateTime);
		builder.append(", productSmilesList=");
		builder.append(productSmilesList);
		builder.append("]");
		return builder.toString();
	}

}
