package br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Produto {
    @SerializedName("id")
    private String id;
    @SerializedName("idProdutoFornecedor")
    private String idProdutoFornecedor;
    @SerializedName("nome")
    private String nome;
    @SerializedName("fabricante")
    private String fabricante;
    @SerializedName("descricao")
    private String descricao;
    @SerializedName("idProdutoGopoints")
    private String idProdutoGopoints;
    @SerializedName("categoria")
    private String categoria;
    @SerializedName("habilitado")
    private boolean habilitado;
    @SerializedName("publicado")
    private boolean publicado;
    @SerializedName("fornecedor")
    private Fornecedor fornecedor;
    @SerializedName("atributos")
    private List<Atributo> atributos;
    @SerializedName("tipoProduto")
    private String tipoProduto;
    @SerializedName("customizavel")
    private boolean customizavel;
    @SerializedName("customizacao")
    private boolean customizacao;
    @SerializedName("resgate")
    private boolean resgate;
    @SerializedName("acumulo")
    private boolean acumulo;
    @SerializedName("categoriasFornecedor")
    private List<Categoria> categoriasFornecedor;
    @SerializedName("categoriasGoPoints")
    private List<Categoria> categoriasGoPoints;
    @SerializedName("skusCatalogo")
    private List<Sku> skusCatalogo;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdProdutoFornecedor() {
		return idProdutoFornecedor;
	}
	public void setIdProdutoFornecedor(String idProdutoFornecedor) {
		this.idProdutoFornecedor = idProdutoFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getIdProdutoGopoints() {
		return idProdutoGopoints;
	}
	public void setIdProdutoGopoints(String idProdutoGopoints) {
		this.idProdutoGopoints = idProdutoGopoints;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
	public boolean isPublicado() {
		return publicado;
	}
	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public List<Atributo> getAtributos() {
		return atributos;
	}
	public void setAtributos(List<Atributo> atributos) {
		this.atributos = atributos;
	}
	public String getTipoProduto() {
		return tipoProduto;
	}
	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}
	public boolean isCustomizavel() {
		return customizavel;
	}
	public void setCustomizavel(boolean customizavel) {
		this.customizavel = customizavel;
	}
	public boolean isCustomizacao() {
		return customizacao;
	}
	public void setCustomizacao(boolean customizacao) {
		this.customizacao = customizacao;
	}
	public boolean isResgate() {
		return resgate;
	}
	public void setResgate(boolean resgate) {
		this.resgate = resgate;
	}
	public boolean isAcumulo() {
		return acumulo;
	}
	public void setAcumulo(boolean acumulo) {
		this.acumulo = acumulo;
	}
	public List<Categoria> getCategoriasFornecedor() {
		return categoriasFornecedor;
	}
	public void setCategoriasFornecedor(List<Categoria> categoriasFornecedor) {
		this.categoriasFornecedor = categoriasFornecedor;
	}
	public List<Categoria> getCategoriasGoPoints() {
		return categoriasGoPoints;
	}
	public void setCategoriasGoPoints(List<Categoria> categoriasGoPoints) {
		this.categoriasGoPoints = categoriasGoPoints;
	}
	public List<Sku> getSkusCatalogo() {
		return skusCatalogo;
	}
	public void setSkusCatalogo(List<Sku> skusCatalogo) {
		this.skusCatalogo = skusCatalogo;
	}

    // getters e setters omitidos para brevidade
}
