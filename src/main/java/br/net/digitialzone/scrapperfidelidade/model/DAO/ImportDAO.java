package br.net.digitialzone.scrapperfidelidade.model.DAO;

import java.util.List;

import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.ImportTest;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.UtilValuesScraped;

public interface ImportDAO {
	void insertImport(String idSellerProduto, String skuProduto, String nome, String nomeResumido,
			String urlModelo);
	void insertImport(UtilValuesScraped utilValuesScraped);
	public List<ImportTest> findAll(); 
	public void update(ImportTest obj);
}
