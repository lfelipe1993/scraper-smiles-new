package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

import br.net.digitialzone.scrapperfidelidade.scraper.model.ModelPhone;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ProductSmiles;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ProdutoFidel;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.ProductList;
import br.net.digitialzone.scrapperfidelidade.utils.CatchProductModel;

public class ImportTest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String idSellerProduto;
	private String skuProduto;
	private String nome;
	private String nomeResumido;
	private String urlModelo;
	private String sigla;

	public ImportTest() {
		// TODO Auto-generated constructor stub
	}
	
	public ImportTest(UtilValuesScraped util) {
		this.idSellerProduto = util.getIdProdutoFornecedor();
		this.skuProduto = util.getIdSkuFornecedor();
		this.nome = util.getNomeProduto();
		this.nomeResumido = util.getNomeProduto();
		this.urlModelo = util.getNomeProduto();
		this.sigla = "";
	}

	public ImportTest(Integer id, String idSellerProduto, String skuProduto, String nome, String nomeResumido,
			String urlModelo, String sigla) {
		super();
		this.id = id;
		this.idSellerProduto = idSellerProduto;
		this.skuProduto = skuProduto;
		this.nome = nome;
		this.nomeResumido = nomeResumido;
		this.urlModelo = urlModelo;
		this.sigla = sigla;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setIdSellerProduto(String idSellerProduto) {
		this.idSellerProduto = idSellerProduto;
	}

	public String getSkuProduto() {
		return skuProduto;
	}

	public void setSkuProduto(String skuProduto) {
		this.skuProduto = skuProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeResumido() {
		return nomeResumido;
	}

	public void setNomeResumido(String nomeResumido) {
		this.nomeResumido = nomeResumido;
	}

	public String getUrlModelo() {
		return urlModelo;
	}

	public void setUrlModelo(String urlModelo) {
		this.urlModelo = urlModelo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getId() {
		return id;
	}

	public String getIdSellerProduto() {
		return idSellerProduto;
	}

	public ModelPhone getModelo() {
		return CatchProductModel.toEnum(sigla);
	}

	public void setModelo(ModelPhone modelo) {
		this.sigla = modelo.getSigla();
	}

	public String getUrlBuilder() {
		return "https://shoppingsmiles.com.br/" + idSellerProduto + "/" + urlModelo + "/" + skuProduto;
	}

	public String getUrlToGetJsonBuilder() {
		return "https://service.shoppingsmiles.com.br/produtos/precificado?codigoFornecedor=" + idSellerProduto
				+ "&codigoProduto=" + skuProduto + "&primeiroNivel=true&modalidade=RESGATE";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idSellerProduto, nome, nomeResumido, sigla, skuProduto, urlModelo);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductSmiles [id=");
		builder.append(id);
		builder.append(", idSellerProduto=");
		builder.append(idSellerProduto);
		builder.append(", skuProduto=");
		builder.append(skuProduto);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", nomeResumido=");
		builder.append(nomeResumido);
		builder.append(", urlModelo=");
		builder.append(urlModelo);
		builder.append(", sigla=");
		builder.append(sigla);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImportTest other = (ImportTest) obj;
		return Objects.equals(id, other.id) && Objects.equals(idSellerProduto, other.idSellerProduto)
				&& Objects.equals(nome, other.nome) && Objects.equals(nomeResumido, other.nomeResumido)
				&& Objects.equals(sigla, other.sigla) && Objects.equals(skuProduto, other.skuProduto)
				&& Objects.equals(urlModelo, other.urlModelo);
	}

}
