package br.net.digitialzone.scrapperfidelidade.scraper.model;

import java.io.Serializable;
import java.util.Objects;

import br.net.digitialzone.scrapperfidelidade.utils.CatchProductModel;

public class ProductSmiles implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String idSellerProduto;
	private String skuProduto;
	private String nome;
	private String nomeResumido;
	private String urlModelo;
	private String sigla;
	private Integer ativo;

	public ProductSmiles() {
		// TODO Auto-generated constructor stub
	}


	public ProductSmiles(Integer id, String idSellerProduto, String skuProduto, String nome, String nomeResumido, String urlModelo, 
			String sigla, Integer ativo) {
		super();
		this.id = id;
		this.idSellerProduto = idSellerProduto;
		this.skuProduto = skuProduto;
		this.nome = nome;
		this.nomeResumido = nomeResumido;
		this.urlModelo = urlModelo;
		this.sigla = sigla;
		this.ativo = ativo;
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


	public Integer getAtivo() {
		return ativo;
	}


	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
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
		return "https://shoppingsmiles.com.br/"+ idSellerProduto +"/"+ urlModelo +"/" + skuProduto;
	}
	
	public String getUrlBuilderFixed() {
		return "https://shoppingsmiles.com.br/"+ idSellerProduto +"/"+ nomeResumido +"/" + skuProduto;
	}
	
	public String getUrlToGetJsonBuilder() {
		return "https://service.shoppingsmiles.com.br/produtos/precificado?codigoFornecedor="+ idSellerProduto 
				+"&codigoProduto=" + skuProduto + "&primeiroNivel=true&modalidade=RESGATE";
	}



	@Override
	public int hashCode() {
		return Objects.hash(ativo, id, idSellerProduto, nome, nomeResumido, sigla, skuProduto, urlModelo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductSmiles other = (ProductSmiles) obj;
		return Objects.equals(ativo, other.ativo) && Objects.equals(id, other.id)
				&& Objects.equals(idSellerProduto, other.idSellerProduto) && Objects.equals(nome, other.nome)
				&& Objects.equals(nomeResumido, other.nomeResumido) && Objects.equals(sigla, other.sigla)
				&& Objects.equals(skuProduto, other.skuProduto) && Objects.equals(urlModelo, other.urlModelo);
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
		builder.append(", ativo=");
		builder.append(ativo);
		builder.append("]");
		return builder.toString();
	}

	

}
