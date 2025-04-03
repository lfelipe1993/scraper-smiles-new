package br.net.digitialzone.scrapperfidelidade.utils;

import java.util.ArrayList;
import java.util.List;

import br.net.digitialzone.scrapperfidelidade.model.DAO.DAOFactory;
import br.net.digitialzone.scrapperfidelidade.model.DAO.MilesProgramDAO;
import br.net.digitialzone.scrapperfidelidade.model.DAO.ProductModelsDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ModelPhone;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.MilesProgram;

public class CatchProgramFidel {
	static List<MilesProgram> ProgFideList = new ArrayList<>();

	public CatchProgramFidel() {
		checkValues();
	}
	
	public static MilesProgram toEnum(String nome) {
		if (nome == null) {
			return null;
		}
		
		checkValues();

		for (MilesProgram x : ProgFideList) {
			if (nome.equals(x.getProgramName())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Modelo inválido: " + nome);
	}
	
	

	public static void getValues() {
		MilesProgramDAO factory = DAOFactory.CreateMilesProgramsDao();
		ProgFideList = factory.findAllPrograms();
	}

	public static void checkValues() {
		if (ProgFideList.isEmpty() || ProgFideList == null) {
			System.out.println("Carregou os modelos");
			getValues();
		}
	}
}
