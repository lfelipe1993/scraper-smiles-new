package br.net.digitialzone.scrapperfidelidade.utils;

import java.util.ArrayList;
import java.util.List;

import br.net.digitialzone.scrapperfidelidade.model.DAO.DAOFactory;
import br.net.digitialzone.scrapperfidelidade.model.DAO.ProductModelsDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ModelPhone;

public class CatchProductModel {
	static List<ModelPhone> modelosList = new ArrayList<>();

	public CatchProductModel() {
		checkValues();
	}
	
	public static ModelPhone toEnum(String sigla) {
		if (sigla == null) {
			return null;
		}
		
		checkValues();

		for (ModelPhone x : modelosList) {
			if (sigla.equals(x.getSigla())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Modelo inválido: " + sigla);
	}
	
	

	public static void getValues() {
		ProductModelsDAO factory = DAOFactory.CreateProductModelsDao();
		modelosList = factory.findAllModels();
	}

	public static void checkValues() {
		if (modelosList.isEmpty() || modelosList == null) {
			System.out.println("Carregou os modelos");
			getValues();
		}
	}
}
