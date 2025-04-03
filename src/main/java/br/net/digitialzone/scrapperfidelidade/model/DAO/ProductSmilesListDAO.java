package br.net.digitialzone.scrapperfidelidade.model.DAO;

import java.util.List;

import br.net.digitialzone.scrapperfidelidade.scraper.model.ProductSmiles;
import br.net.digitialzone.scrapperfidelidade.scraper.model.RunParams;

public interface ProductSmilesListDAO {
	void insert(ProductSmiles obj);
	void update(ProductSmiles obj);
	ProductSmiles findByIdAndSku(String id, String sku);
	List<ProductSmiles> findAll();
	List<ProductSmiles> findAllWithVarejista(RunParams runParams);
}
