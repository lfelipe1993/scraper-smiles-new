package br.net.digitialzone.scrapperfidelidade.scraper.model.general.enums;

public enum Varejistas {
	casasbahia(1, "casasbahia"," AND id_seller_produto = \"casasbahia\""),
	extra(2, "extra"," AND id_seller_produto = \"extra\""),
	magazineluiza(3, "magazineluiza"," AND id_seller_produto = \"magazineluiza\""),
	pontofrio(4, "pontofrio"," AND id_seller_produto = \"pontofrio\""),
	todos(5, "todos"," AND 1=1");

	private Integer id;
	private String name;
	private String sqlQuery;


	private Varejistas(Integer id, String name, String sqlQuery) {
		this.id = id;
		this.name = name;
		this.sqlQuery = sqlQuery;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.name = sqlQuery;
	}


	public static Varejistas toEnum(String name) {
		if (name == null) {
			return null;
		}
		for (Varejistas x : Varejistas.values()) {
			if (name.toLowerCase().equals(x.getName().toLowerCase())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Invalid Varejista: " + name);
	}
}
