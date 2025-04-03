package br.net.digitialzone.scrapperfidelidade.utils;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.net.digitialzone.scrapperfidelidade.scraper.model.ModelPhone;

public class CheckModels {

	public static String checkModel(String nome) {
		Pattern i5 = Pattern.compile("(?i)\\b(?:iphone 5)\\b");
		Pattern i5S = Pattern.compile("(?i)\\b(?:iphone 5s)\\b");
		Pattern i6 = Pattern.compile("(?i)\\b(?:iphone 6)\\b");
		Pattern i6S = Pattern.compile("(?i)\\b(?:iphone 6s|iphone Apple 6s)\\b");
		Pattern i7 = Pattern.compile("(?i)\\b(?:iphone 7)\\b");
		Pattern i7P = Pattern.compile("(?i)\\b(?:iphone 7 Plus)\\b");
		Pattern i8 = Pattern.compile("(?i)\\b(?:iphone 8|iphone  8)\\b");
		Pattern i8P = Pattern.compile("(?i)\\b(?:iphone 8 Plus)\\b");
		Pattern iSE = Pattern.compile("(?i)\\b(?:iphone SE)\\b");
		Pattern iX = Pattern.compile("(?i)\\b(?:iphone X)\\b");
		Pattern iXR = Pattern.compile("(?i)\\b(?:iphone XR)\\b");
		Pattern iXS = Pattern.compile("(?i)\\b(?:iphone XS)\\b");
		Pattern iXSM = Pattern.compile("(?i)\\b(?:iphone XS Max)\\b");
		Pattern i11 = Pattern.compile("(?i)\\b(?:iphone 11)\\b");
		Pattern i11P = Pattern.compile("(?i)\\b(?:iphone 11 Pro)\\b");
		Pattern i11PM = Pattern.compile("(?i)\\b(?:iphone 11 Pro Max)\\b");
		Pattern i12M = Pattern.compile("(?i)\\b(?:iphone 12 Mini)\\b");
		Pattern i12 = Pattern.compile("(?i)\\b(?:iphone 12)\\b(?!.*mini)");
		Pattern i12P = Pattern.compile("(?i)\\b(?:iphone 12 Pro)\\b");
		Pattern i12PM = Pattern.compile("(?i)\\b(?:iphone 12 Pro Max)\\b");
		Pattern i13M = Pattern.compile("(?i)\\b(?:iphone 13 Mini)\\b");
		Pattern i13 = Pattern.compile("(?i)\\b(?:iphone 13)\\b(?!.*mini)");
		Pattern i13P = Pattern.compile("(?i)\\b(?:iphone 13 Pro)\\b");
		Pattern i13PM = Pattern.compile("(?i)\\b(?:iphone 13 Pro Max)\\b");
		Pattern i14M = Pattern.compile("(?i)\\b(?:iphone 14 Plus)\\b");
		Pattern i14 = Pattern.compile("(?i)\\b(?:iphone 14)\\b(?!.*Plus)");
		Pattern i14P = Pattern.compile("(?i)\\b(?:iphone 14 Pro)\\b");
		Pattern i14PM = Pattern.compile("(?i)\\b(?:iphone 14 Pro Max)\\b");
		Pattern i15M = Pattern.compile("(?i)\\b(?:iphone 15 Plus)\\b");
		Pattern i15 = Pattern.compile("(?i)\\b(?:iphone 15)\\b(?!.*Plus)");
		Pattern i15P = Pattern.compile("(?i)\\b(?:iphone 15 Pro)\\b");
		Pattern i15PM = Pattern.compile("(?i)\\b(?:iphone 15 Pro Max)\\b");

		Pattern i16E = Pattern.compile("(?i)\\b(?:iphone 16e)\\b");
		Pattern i16M = Pattern.compile("(?i)\\b(?:iphone 16 Plus)\\b");
		Pattern i16 = Pattern.compile("(?i)\\b(?:iphone 16)\\b(?!.*Plus)");
		Pattern i16P = Pattern.compile("(?i)\\b(?:iphone 16 Pro)\\b");
		Pattern i16PM = Pattern.compile("(?i)\\b(?:iphone 16 Pro Max)\\b");

		try {
			if (i5S.matcher(nome).find()) {
				return "5S";
			} else if (i5.matcher(nome).find()) {
				return "5";
			} else if (i6S.matcher(nome).find()) {
				return "6S";
			} else if (i6.matcher(nome).find()) {
				return "6";
			} else if (i7P.matcher(nome).find()) {
				return "7P";
			} else if (i7.matcher(nome).find()) {
				return "7";
			} else if (i8P.matcher(nome).find()) {
				return "8P";
			} else if (i8.matcher(nome).find()) {
				return "8";
			} else if (iSE.matcher(nome).find()) {
				return "SE";
			} else if (iXSM.matcher(nome).find()) {
				return "XSM";
			} else if (iXS.matcher(nome).find()) {
				return "XS";
			} else if (iXR.matcher(nome).find()) {
				return "XR";
			} else if (iX.matcher(nome).find()) {
				return "X";
			} else if (i11PM.matcher(nome).find()) {
				return "11PM";
			} else if (i11P.matcher(nome).find()) {
				return "11P";
			} else if (i12PM.matcher(nome).find()) {
				return "12PM";
			} else if (i12P.matcher(nome).find()) {
				return "12P";
			} else if (i12.matcher(nome).find()) {
				return "12";
			} else if (i12M.matcher(nome).find()) {
				return "12M";
			} else if (i13PM.matcher(nome).find()) {
				return "13PM";
			} else if (i13P.matcher(nome).find()) {
				return "13P";
			} else if (i13.matcher(nome).find()) {
				return "13";
			} else if (i13M.matcher(nome).find()) {
				return "13M";
			} else if (i14PM.matcher(nome).find()) {
				return "14PM";
			} else if (i14P.matcher(nome).find()) {
				return "14P";
			} else if (i14.matcher(nome).find()) {
				return "14";
			} else if (i14M.matcher(nome).find()) {
				return "14M";
			} else if (i15PM.matcher(nome).find()) {
				return "15PM";
			} else if (i15P.matcher(nome).find()) {
				return "15P";
			} else if (i15.matcher(nome).find()) {
				return "15";
			} else if (i15M.matcher(nome).find()) {
				return "15M";
			} else if (i11.matcher(nome).find()) {
				return "11";
			} else if (i16PM.matcher(nome).find()) {
				return "16PM";
			} else if (i16P.matcher(nome).find()) {
				return "16P";
			} else if (i16.matcher(nome).find()) {
				return "16";
			} else if (i16M.matcher(nome).find()) {
				return "16M";
			} else if (i16E.matcher(nome).find()) {
				return "16E";
			}

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public static String checkArmaz(String nome) {
		Pattern p16GB = Pattern.compile("(?i)\\b(?:16|16GB)\\b");
		Pattern p32GB = Pattern.compile("(?i)\\b(?:32|32GB)\\b");
		Pattern p64GB = Pattern.compile("(?i)\\b(?:64|64GB)\\b");
		Pattern p128GB = Pattern.compile("(?i)\\b(?:128|128GB)\\b");
		Pattern p256GB = Pattern.compile("(?i)\\b(?:256|256GB)\\b");
		Pattern p512GB = Pattern.compile("(?i)\\b(?:512|512GB)\\b");
		Pattern p1000GB = Pattern.compile("(?i)\\b(?:1000|1TB|1 TB)\\b");

		try {
			// if (p16GB.matcher(nome).find()) {
			// return "16";
			// } else

			if (p32GB.matcher(nome).find()) {
				return "32";
			} else if (p64GB.matcher(nome).find()) {
				return "64";
			} else if (p128GB.matcher(nome).find()) {
				return "128";
			} else if (p256GB.matcher(nome).find()) {
				return "256";
			} else if (p512GB.matcher(nome).find()) {
				return "512";
			} else if (p1000GB.matcher(nome).find()) {
				return "1000";
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "SMC";
	}

	public static String getColor(String nome) {
		Pattern pColor = Pattern.compile("(?i)\\b(?:Branco|White|Preto|Black|Vermelho|Red"
				+ "|Verde|Green|Azul|Blue|Rosa|Rose|Dourado|Gold|Silver|Prata|Prateado|Cinza|Gray"
				+ "|Amarelo|Yellow|Grafite|Roxo|Lilás|Lilas|Purple|Titânio|Titanio|Coral|Durado|Starlight|Estelar|Meia-noite|Midnight|Sierra Blue"
				+ "|Roxo-Profundo|Deep Purple|Deep-Purple|Preto-Espacial|Preto Espacial|Space-Black|Space Black|Verde-acinzentado|Ultramarino"
				+ "|deserto|Natural|Natural)\\b");

		Matcher m = pColor.matcher(nome);

		if (m.find()) {
			return m.group(0).replace("Durado", "Dourado");
		}

		return "SCC";
	}

	public static Optional<Double> checkPrice(Double price, ModelPhone modelo) {
		Optional<Double> checkPrice = Optional.empty();

		if (modelo == null) {
			return checkPrice;
		}

		if (Utilidades.compareDouble(price, modelo.getLimitPrice()) == -1) {
			// System.out.println("BestPrice");
			checkPrice = Optional.of(price);
		}

		return checkPrice;
	}

}
