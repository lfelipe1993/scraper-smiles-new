package br.net.digitialzone.scrapperfidelidade.model.DAO;

import java.util.List;

import br.net.digitialzone.scrapperfidelidade.scraper.model.general.MilesProgram;

public interface MilesProgramDAO {
	List<MilesProgram> findAllPrograms();
}
