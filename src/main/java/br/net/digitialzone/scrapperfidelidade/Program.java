package br.net.digitialzone.scrapperfidelidade;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

import br.net.digitialzone.scrapperfidelidade.model.DAO.DAOFactory;
import br.net.digitialzone.scrapperfidelidade.model.DAO.ImportDAO;
import br.net.digitialzone.scrapperfidelidade.model.DAO.ProductSmilesListDAO;
import br.net.digitialzone.scrapperfidelidade.scraper.Scraper;
import br.net.digitialzone.scrapperfidelidade.scraper.model.ProductSmiles;
import br.net.digitialzone.scrapperfidelidade.scraper.model.RunParams;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.ImportTest;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.UtilValuesScraped;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.ListaProduto;
import br.net.digitialzone.scrapperfidelidade.scraper.readers.ScraperHtml;
import br.net.digitialzone.scrapperfidelidade.utils.CatchProductModel;
import br.net.digitialzone.scrapperfidelidade.utils.CatchProgramFidel;
import br.net.digitialzone.scrapperfidelidade.utils.CheckModels;
import br.net.digitialzone.scrapperfidelidade.utils.Utilidades;

public class Program {

	public static void main(String[] args) {
		Locale brasil = new Locale("pt", "BR");
		Locale.setDefault(brasil);

		//mainATT();
		//System.exit(1);

		RunParams runParams = new RunParams();

		//String[] argsTest = new String[1];
		//argsTest[0] = "programa=Smiles";
		//argsTest[1] = "varejista=magazineluiza";

		List<String> params = Arrays.asList(args);

		params.forEach(p -> {
			if (p != null) {
				String[] teste = p.split("=");

				if (teste[0].equalsIgnoreCase("programa") && teste[1].equalsIgnoreCase("Azul")) {
					runParams.setProgram(CatchProgramFidel.toEnum(teste[1]));
				} else if (teste[0].equalsIgnoreCase("programa") && teste[1].equalsIgnoreCase("Smiles")) {
					runParams.setProgram(CatchProgramFidel.toEnum(teste[1]));
				}
				
				if (teste[0].equalsIgnoreCase("varejista") && teste[1].equalsIgnoreCase("casasbahia")) {
					runParams.setVarejista("casasbahia");
				} else if (teste[0].equalsIgnoreCase("varejista") && teste[1].equalsIgnoreCase("extra")) {
					runParams.setVarejista("extra");
				} else if (teste[0].equalsIgnoreCase("varejista") && teste[1].equalsIgnoreCase("pontofrio")) {
					runParams.setVarejista("pontofrio");
				}else if (teste[0].equalsIgnoreCase("varejista") && teste[1].equalsIgnoreCase("magazineluiza")) {
					runParams.setVarejista("magazineluiza");
				}else if (teste[0].equalsIgnoreCase("varejista") && teste[1].equalsIgnoreCase("fastshop")) {
					runParams.setVarejista("fastshop");
				}
			}
		});

		Scraper.Scraping(runParams);

		runParams.getAlertaView().setProgram(runParams.getProgram());
		if (runParams.getAlertaView() != null && !runParams.getAlertaView().getDadosView().isEmpty()) {

			String msgTelegramFinal = runParams.getAlertaView().toString();

			runParams.getAlertaView().SortListByPrice();
			TelegramNotifier.sendNotification(msgTelegramFinal);

		} else {
			System.out.println("Sem mensagens a enviar!");
		}

		Scraper.inserirRunLog(runParams.getProgram().getProgramName());
		System.out.println("Processo finalizado às: " + LocalDateTime.now());

		System.exit(1);

	}// end Of method Main

	public static void buscaProdutos() {

		ImportDAO factory = DAOFactory.CreateImportDao();
		
		List<ImportTest> jaImport = factory.findAll();
		
		String str = "";

		ListaProduto lP = ScraperHtml.jsonListSmiles2JavaObject(str);
		

		// Remover duplicatas usando Set
		Set<UtilValuesScraped> prodConvert = new HashSet<>();

		lP.getProdutos().forEach(x -> {
			System.out.println(Utilidades.convertToUtilValues(x));

			prodConvert.add(Utilidades.convertToUtilValues(x));

		});
		
		Set<UtilValuesScraped> removeProds = new HashSet<>();
		removeProds.addAll(jaImport.stream().map(x -> new UtilValuesScraped(x)).collect(Collectors.toList()));
		
		
        // Encontrar os elementos que estão em uniqueLinks e NÃO estão em removeProds
        List<UtilValuesScraped> uniqueLinks = new ArrayList<>(prodConvert);
        uniqueLinks.removeAll(removeProds); // Remove todos os itens duplicados


		

        uniqueLinks.forEach(x -> {

			factory.insertImport(x);
			System.out.println(x);

		});

	}

	public static void mainATT() {


		ImportDAO factory = DAOFactory.CreateImportDao();
		List<ImportTest> prods = new ArrayList<>();

		prods = factory.findAll();
		
		prods.forEach(x -> {
			
			x.setUrlModelo(x.getUrlModelo().replace(",", "").replace(" - ", "-").replace(" ", "-"));
			
			factory.update(x);
		});

		prods.forEach(x -> {
			System.out.println(x.getNome());

			x.setSigla(CheckModels.checkModel(x.getNome()) + CheckModels.checkArmaz(x.getNome()));

			x.setNomeResumido(
					CatchProductModel.toEnum(CheckModels.checkModel(x.getNome()) + CheckModels.checkArmaz(x.getNome())).getNome()
							+ " " + CatchProductModel
									.toEnum(CheckModels.checkModel(x.getNome()) + CheckModels.checkArmaz(x.getNome())).getArmaz()
							+ "GB " + CheckModels.getColor(x.getNome()));
			System.out.println(x.getNomeResumido());
			System.out.println(x.getSigla().equals(CatchProductModel.toEnum(x.getSigla()).getSigla()));
			factory.update(x);
		});

	}

	public static List<String> readFile() {
		List<String> text = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader("C:\\utilidades\\azul.txt"))) {
			// do reading, usually loop until end of file reading
			String mLine;
			while ((mLine = reader.readLine()) != null) {
				text.add(mLine.replaceAll("[^\\p{ASCII}]", ""));
			}

		} catch (IOException e) {
			e.getMessage();
		}

		return text;
	}

}
