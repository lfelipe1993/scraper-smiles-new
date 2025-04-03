package br.net.digitialzone.scrapperfidelidade.scraper.model;

public class ModelPhone {
	private Integer id;
	private String nome;
	private String model;
	private String armaz;
	private Double limitPrice;
	private String sigla;
	private Integer ativo;
	
	public ModelPhone() {
	}

	public ModelPhone(Integer id, String nome, String model, String armaz, Double limitPrice, String sigla,
			Integer ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.model = model;
		this.armaz = armaz;
		this.limitPrice = limitPrice;
		this.sigla = sigla;
		this.setAtivo(ativo);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getArmaz() {
		return armaz;
	}

	public void setArmaz(String armaz) {
		this.armaz = armaz;
	}

	public Double getLimitPrice() {
		return limitPrice;
	}

	public void setLimitPrice(Double limitPrice) {
		this.limitPrice = limitPrice;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sigla == null) ? 0 : sigla.hashCode());
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
		ModelPhone other = (ModelPhone) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sigla == null) {
			if (other.sigla != null)
				return false;
		} else if (!sigla.equals(other.sigla))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModelosNew [id=");
		builder.append(id);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", model=");
		builder.append(model);
		builder.append(", armaz=");
		builder.append(armaz);
		builder.append(", limitPrice=");
		builder.append(limitPrice);
		builder.append(", sigla=");
		builder.append(sigla);
		builder.append("]");
		return builder.toString();
	}
	
}
