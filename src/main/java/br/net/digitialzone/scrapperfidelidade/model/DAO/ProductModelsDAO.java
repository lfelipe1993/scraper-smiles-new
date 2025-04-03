package br.net.digitialzone.scrapperfidelidade.model.DAO;

import java.util.List;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ModelPhone;

public interface ProductModelsDAO {
	void insertProducsModels(ModelPhone obj);
	List<ModelPhone> findAllModels();
}
