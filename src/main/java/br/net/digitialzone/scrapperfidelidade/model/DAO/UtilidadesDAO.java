package br.net.digitialzone.scrapperfidelidade.model.DAO;

import java.sql.Timestamp;
import java.util.List;

import br.net.digitialzone.scrapperfidelidade.scraper.model.general.RunLogs;

public interface UtilidadesDAO {
	void insertRunLogs(RunLogs obj);
	List<RunLogs> findAllRunLogsByDate(Timestamp dataTime,String lojista);
}
