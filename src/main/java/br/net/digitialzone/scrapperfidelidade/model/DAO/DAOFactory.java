package br.net.digitialzone.scrapperfidelidade.model.DAO;

import br.net.digitialzone.scrapperfidelidade.db.DB;
import br.net.digitialzone.scrapperfidelidade.model.DAO.impl.ImportJDBC;
import br.net.digitialzone.scrapperfidelidade.model.DAO.impl.ProductSmilesListJDBC;
import br.net.digitialzone.scrapperfidelidade.model.DAO.impl.ProductModelsJDBC;
import br.net.digitialzone.scrapperfidelidade.model.DAO.impl.ProgFideListJDBC;
import br.net.digitialzone.scrapperfidelidade.model.DAO.impl.TimeLineJDBC;
import br.net.digitialzone.scrapperfidelidade.model.DAO.impl.UtilidadesJDBC;

public class DAOFactory {
	
	public static UtilidadesJDBC CreateUtilidadesDao() {
		return new UtilidadesJDBC(DB.getConnection());
	}
	
	//old
	public static TimeLineJDBC CreateTudoAzulDao() {
		return new TimeLineJDBC(DB.getConnection());
	}
	
	//new
	public static ProductSmilesListJDBC CreateProductSmilesListDao() {
		return new ProductSmilesListJDBC(DB.getConnection());
	}
	
	
	public static ImportJDBC CreateImportDao() {
		return new ImportJDBC(DB.getConnection());
	}
	
	
	//new
	public static ProductModelsJDBC CreateProductModelsDao() {
		return new ProductModelsJDBC(DB.getConnection());
	}
	
	//new
	public static ProgFideListJDBC CreateMilesProgramsDao() {
		return new ProgFideListJDBC(DB.getConnection());
	}
	

}
