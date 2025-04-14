package br.net.digitialzone.scrapperfidelidade.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.net.digitialzone.scrapperfidelidade.scraper.model.general.MilesProgram;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.enums.Varejistas;
import br.net.digitialzone.scrapperfidelidade.scraper.model.smiles.TimeLineProduct;
import br.net.digitialzone.scrapperfidelidade.utils.Utilidades;

public abstract class AlertaView {
	private MilesProgram program;
	private List<DadosView> dadosView = new ArrayList<DadosView>();
	private String varejista = "todos";

	public AlertaView() {
		// TODO Auto-generated constructor stub
	}

	public AlertaView(MilesProgram programs) {
		this.program = programs;
	}

	public MilesProgram getProgram() {
		return this.program;
	}

	public void setProgram(MilesProgram program) {
		this.program = program;
	}

	public List<DadosView> getDadosView() {
		return dadosView;
	}

	public void setDadosView(TimeLineProduct obj) {
		this.dadosView.add(new DadosView(obj));
	}

	public void SortListByPrice() {
		Collections.sort(this.dadosView);
	}

	public Varejistas getVarejista() {
		return Varejistas.toEnum(varejista);
	}

	public void setVarejista(String varejista) {
		this.varejista = varejista;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		String EmojiVoltage = "%E2%9A%A1";

		builder.append(EmojiVoltage + " [ <b>" + program.getProgramName().toUpperCase() + "</b>] " + EmojiVoltage);
		builder.append("\n <b>PREÇO MILHAR: " + Utilidades.formatPrice(program.getMilesValue()) + "</b> \n\n");
		builder.append("\n <b>VAREJISTA: [" + getVarejista().getName().toLowerCase() + "]</b> \n\n");
		dadosView.forEach(x -> {
			builder.append(x);
		});
		return builder.toString();
	}

}
