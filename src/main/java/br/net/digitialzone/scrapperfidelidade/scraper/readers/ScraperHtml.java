package br.net.digitialzone.scrapperfidelidade.scraper.readers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;

import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.ListaProduto;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Produto;

public class ScraperHtml {

	public static Produto jsonSmiles2JavaObject(String url) {
		// String url =
		// "https://service.shoppingsmiles.com.br/produtos/precificado?codigoFornecedor=pontofrio&codigoProduto=74541857&primeiroNivel=true&modalidade=RESGATE";
		// String url2 = "https://testes.digitalzone.net.br/smiles.json";

		System.out.println(url);

		HttpResponse<String> response = null;
		Gson gson = new Gson();

		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).header("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36 Edg/134.0.0.0")
					.header("origin", "https://shoppingsmiles.com.br")
					.header("reffer", "https://shoppingsmiles.com.br/").header("Accept", "application/json").build();

			response = client.send(request, BodyHandlers.ofString());

			// System.out.println("Response in file:" + response.body());
			// System.out.println(response.statusCode());
			// System.out.println(response.uri());

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// System.out.println(response.body());

		return gson.fromJson(response.body(), Produto.class);

	}

	public static ListaProduto jsonListSmiles2JavaObject(String url) {
		// String url =
		// "https://service.shoppingsmiles.com.br/produtos/precificado?codigoFornecedor=pontofrio&codigoProduto=74541857&primeiroNivel=true&modalidade=RESGATE";
		 String url2 = "https://service.shoppingsmiles.com.br/produtos/buscar?ordenacao=SCORE&nonTipoProduto=CASHBACK_EXTERNO"
		 		+ "&nonTipoProduto=COMPRA_PONTOS&page=1&pageSize=36&termo=Apple%20iphone&modalidade=RESGATE"
		 		+ "&habilitado=true&publicado=true&aggrCategoriaGopoints=true&valueSortMode=MIN";

		System.out.println(url2);

		HttpResponse<String> response = null;
		Gson gson = new Gson();

		try {
			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url2)).header("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/134.0.0.0 Safari/537.36 Edg/134.0.0.0")
					.header("custom-origin", "https://shoppingsmiles.com.br")
					.header("origin", "https://shoppingsmiles.com.br")
					.header("reffer", "https://shoppingsmiles.com.br/")
					.header("Accept", "application/json, text/plain, */*")
					.build();

			response = client.send(request, BodyHandlers.ofString());

			// System.out.println("Response in file:" + response.body());
			// System.out.println(response.statusCode());
			// System.out.println(response.uri());

		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		// System.out.println(response.body());

		return gson.fromJson(response.body(), ListaProduto.class);

	}

	public static String checkPrice(String str) {
		Pattern p = Pattern.compile("[\\d]{1,3}.[\\d]{1,3}.[\\d]{1,3}");
		Matcher m = p.matcher(str);

		if (m.find()) {
			return m.group(0).replace(".", "");
		} else {
			return null;
		}

	}

	public static String REGEX_FIND_WORD = "(?i).*\\bcapa\\b.*";

	public static boolean containsWord(String text, String word) {
		String regex = String.format(REGEX_FIND_WORD, Pattern.quote(word));
		return text.matches(regex);
	}
}
