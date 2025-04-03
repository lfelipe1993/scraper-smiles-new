package br.net.digitialzone.scrapperfidelidade.utils;

import java.sql.Timestamp;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.util.Locale;

import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.UtilValuesScraped;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Acumulo;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Produto;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.json.Resgate;

public class Utilidades {

	public static Timestamp localDateTimeToTimeStamp(LocalDateTime dttm) {
		return Timestamp.valueOf(dttm);
	}

	public static LocalDateTime timeStampToLocalDateTime(Timestamp timestamp) {
		return timestamp.toLocalDateTime();
	}

	public static String formatPrice(Double val) {
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		return nf.format(val);
	}

	public static int compareDouble(Double v1, Double v2) {
		return Double.valueOf(v1).compareTo(Double.valueOf(v2));
	}

	public static UtilValuesScraped convertToUtilValues(Produto prod) {
		UtilValuesScraped produtoFinal = new UtilValuesScraped();
		
		System.out.println("proNome: " + prod.getNome());
		produtoFinal.setNomeProduto(prod.getNome());

		//System.out.println("isAcumuloAvailable: " + prod.isAcumulo());
		produtoFinal.setIsAcumuloAvaliable(prod.isAcumulo());
		
		//System.out.println("isResgateAvailable: " + prod.isResgate());
		produtoFinal.setIsRegateAvaliable(prod.isResgate());
		
		//System.out.println("idProdutoFornecedor: " + prod.getIdProdutoFornecedor());
		produtoFinal.setIdProdutoFornecedor(prod.getIdProdutoFornecedor());
		
		//System.out.println("codigoFornecedor: " + prod.getFornecedor().getCodigoFornecedor());
		produtoFinal.setCodigoFornecedor(prod.getFornecedor().getCodigoFornecedor());

		prod.getSkusCatalogo().stream() // Começa pelo skusCatalogo
				.forEach(sku -> {
					// Acessa idSkuFornecedor
					String idSkuFornecedor = sku.getIdSkuFornecedor();
				//	System.out.println("idSkuFornecedor: " + idSkuFornecedor);
					produtoFinal.setIdSkuFornecedor(idSkuFornecedor);

					sku.getValoresCanal().stream() // Para cada SKU, acessa os canais
							.flatMap(canal -> canal.getValoresModalidade().stream()) // Para cada modalidade
							.forEach(modalidade -> {
								// Filtra por modalidade ACUMULO
								if ("ACUMULO".equals(modalidade.getModalidade())) {
									// Acessa o segmento PADRAO dentro da modalidade ACUMULO
									modalidade.getValoresSegmento().stream()
											.filter(segmento -> "PADRAO".equals(segmento.getSegmento())) // Filtra
																											// segmento
																											// "PADRAO"
											.forEach(segmento -> {
											//	System.out.println("Valor em Reais: " + segmento.getValorReais());
												produtoFinal.setValorEmReais(segmento.getValorReais());

												// Acessa os valoresAcumulo dentro do segmento "PADRAO" e pega o
												// valorAcumulo
												segmento.getValoresAcumulo().stream().filter(
														acumulo -> "CLUBE".equals(acumulo.getCodigoCategoriaPrograma())) // Filtra
																															// por
																															// "CLUBE"
														.map(Acumulo::getValorAcumulo) // Acessa o valorAcumulo
														.forEach(valorAcumulo -> {

															//System.out.println("idSkuFornecedor: " + idSkuFornecedor);

															//System.out.println("valorAcumulo (CLUBE): " + valorAcumulo);
															produtoFinal.setValorAcumuloPontos(valorAcumulo);
															
														});
											});// End Of .forEach(segmento ->
								} // EndIf Of "ACUMULO".equals

								// Filtra por modalidade RESGATE
								if ("RESGATE".equals(modalidade.getModalidade())) {
									// Acessa o segmento PADRAO dentro da modalidade RESGATE
									modalidade.getValoresSegmento().stream()
											.filter(segmento -> "PADRAO".equals(segmento.getSegmento())) // Filtra
																											// segmento
																											// "PADRAO"
											.forEach(segmento -> {
												// Acessa os valoresResgate dentro do segmento "PADRAO" e pega o
												// valorPontos
												segmento.getValoresResgate().stream().filter(
														resgate -> "CLUBE".equals(resgate.getCodigoCategoriaPrograma())) // Filtra
																															// por
														.map(Resgate::getValorPontos) // Acessa o valorAcumulo
														.forEach(valorPontos -> {

															//System.out.println("idSkuFornecedor: " + idSkuFornecedor);

															//System.out.println("valorPontos (CLUBE): " + valorPontos);
															produtoFinal.setValorResgatePontos(valorPontos);
														});
											});// End Of .forEach(segmento -> {
								} // EndIf Of "RESGATE".equals
							});

				});// End Of foreach Stream

		return produtoFinal;

	}

}
