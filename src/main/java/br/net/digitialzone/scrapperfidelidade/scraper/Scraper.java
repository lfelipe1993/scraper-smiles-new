package br.net.digitialzone.scrapperfidelidade.scraper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.net.digitialzone.scrapperfidelidade.model.DAO.DAOFactory;
import br.net.digitialzone.scrapperfidelidade.model.DAO.ProductSmilesListDAO;
import br.net.digitialzone.scrapperfidelidade.model.DAO.TimeLineDAO;
import br.net.digitialzone.scrapperfidelidade.model.DAO.UtilidadesDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ProductSmiles;
import br.net.digitialzone.scrapperfidelidade.scraper.model.RunParams;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.RunLogs;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.TimeLineProduct;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.UtilValuesScraped;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Acumulo;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Produto;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Resgate;
import br.net.digitialzone.scrapperfidelidade.scraper.readers.ScraperHtml;
import br.net.digitialzone.scrapperfidelidade.utils.Utilidades;

public class Scraper {

	public static void Scraping(RunParams runParams) {

		ProductSmilesListDAO factory = DAOFactory.CreateProductSmilesListDao();
		//List<ProductSmiles> list = factory.findAll();
		List<ProductSmiles> list = factory.findAllWithVarejista(runParams);

		List<TimeLineProduct> listaProcessada = new ArrayList<>();

		list.forEach(x -> {

			Produto sP = ScraperHtml.jsonSmiles2JavaObject(x.getUrlToGetJsonBuilder());
			
			//UtilValuesScraped scrapedProdutct = Utilidades.convertToUtilValues(sP);
			
			//somente adiciona a lista se stiver com acumulo ou resgate true
			if(sP.isAcumulo() || sP.isResgate()){
				listaProcessada.add(new TimeLineProduct(sP,x,runParams.getProgram()));
			}

			
			try {
				Random aleatorio = new Random();
				int sleep = aleatorio.nextInt((2101 - 1502) + 1) + 1502;
				Thread.sleep(sleep);
			} catch (InterruptedException e) { // TODO Auto-generated catch block
				e.printStackTrace();
			}

		});//foreach end
		
		TimeLineDAO fct = DAOFactory.CreateTudoAzulDao();
		listaProcessada.forEach(x -> fct.insert(x));

		listaProcessada.forEach(x -> {

			if (checkPriceWithPoints(x,runParams) == true || checkPriceResgate(x,runParams) == true ) {
				
				if(x.getAnyAvailable()) {
					runParams.getAlertaView().setDadosView(x);
				}
			}
			
			//inserirRunLog(runParams.getProgram().getProgramName());
		});


	}

	public static Boolean checkPriceWithPoints(TimeLineProduct prod, RunParams runParams) {
		return (prod.getPriceWithPoints()) * runParams.getProgram().getMilesValue() < prod.getproductSmilesList().getModelo().getLimitPrice();
	}
	
	public static Boolean checkPriceResgate(TimeLineProduct prod, RunParams runParams) {
		Double calc = prod.getPriceWithMoney() - (prod.getPointsToEarn() * runParams.getProgram().getMilesValue());

		Double target  = prod.getproductSmilesList().getModelo().getLimitPrice();

		return calc < target;
	}

	public static void inserirRunLog(String program) {
		RunLogs runLogs = new RunLogs(null, program, new Timestamp(System.currentTimeMillis()));

		UtilidadesDAO factory = DAOFactory.CreateUtilidadesDao();
		factory.insertRunLogs(runLogs);

	}
}
