package br.net.digitialzone.scrapperfidelidade.view;

import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.TimeLineProduct;
import br.net.digitialzone.scrapperfidelidade.utils.Utilidades;

public class DadosView implements Comparable<DadosView>{
	private TimeLineProduct prod;

	public DadosView() {
		// TODO Auto-generated constructor stub
	}

	public DadosView(TimeLineProduct prod) {
		this.prod = prod;
	}
	
	public TimeLineProduct getProd() {
		return prod;
	}

	public void setProd(TimeLineProduct prod) {
		this.prod = prod;
	}
	
	public String getUrl() {
		String url = "<a href=\"" + prod.getproductSmilesList().getUrlBuilderFixed() +"\">" + prod.getproductSmilesList().getNomeResumido() + "</a>";
		
		return url;
	}

	@Override
	public int compareTo(DadosView o) {
		if (this.prod.getproductSmilesList().getModelo().getLimitPrice() > o.prod.getproductSmilesList().getModelo().getLimitPrice()) {
			return -1;
		}
		if (this.prod.getproductSmilesList().getModelo().getLimitPrice() < o.prod.getproductSmilesList().getModelo().getLimitPrice()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String EmojiMoney = "%F0%9F%92%B5";
		String EmojiChart = "%F0%9F%93%8A";
		String EmojiPoints = "%F0%9F%92%B1";
		String EmojiReturn = "%F0%9F%94%84";
		String EmojiBack = "%F0%9F%94%99";

		builder.append("\n\n##############################\n");
		builder.append(getUrl());
		builder.append("<b>\n PREÇO ALVO: " + Utilidades.formatPrice(prod.getproductSmilesList().getModelo().getLimitPrice()) + "</b>");
		builder.append("\n\n");
		builder.append("**ACUMULO DE PONTOS**\n");
		builder.append(EmojiMoney + " <b>" + Utilidades.formatPrice(prod.getPriceWithMoney()) + "</b>");
		builder.append(" [" + "PTS: " + String.format("%.2f",prod.getPointsToEarn()*1000) + "]");
		builder.append("\n");
		builder.append("<b> VALOR FINAL: " + Utilidades.formatPrice(prod.getValorAcumuloTotal()) + "</b>");
		builder.append("\n");
		builder.append("-----------------------------------\n");
		builder.append("**RESGATE DE PONTOS**\n");
		builder.append(EmojiPoints + " <b>" + prod.getPriceWithPoints() + "</b>");
		builder.append("\n CONVERTIDO: <b>" + Utilidades.formatPrice(prod.getValorPointsToMoney()) + "</b>");
		
		return builder.toString();
	}



}
