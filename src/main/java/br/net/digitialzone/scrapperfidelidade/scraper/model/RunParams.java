package br.net.digitialzone.scrapperfidelidade.scraper.model;

import br.net.digitialzone.scrapperfidelidade.scraper.model.general.MilesProgram;
import br.net.digitialzone.scrapperfidelidade.scraper.model.general.enums.Varejistas;
import br.net.digitialzone.scrapperfidelidade.utils.CatchProgramFidel;
import br.net.digitialzone.scrapperfidelidade.view.AlertaView;

public class RunParams {
	private MilesProgram program;
	private Boolean sendTelegramMsg = null;
	private Boolean filtroAdvanced = null;
	private String varejista = "todos";
	
	private AlertaView alertaView = new AlertaView() {
	};
	
	public RunParams() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getSendTelegramMsg() {
		return sendTelegramMsg;
	}

	public void setSendTelegramMsg(Boolean sendTelegramMsg) {
		this.sendTelegramMsg = sendTelegramMsg;
	}

	public MilesProgram getProgram() {
		return CatchProgramFidel.toEnum(program.getProgramName());
	}

	public void setProgram(MilesProgram program) {
		this.program = program;
	}

	public Boolean getFiltroAdvanced() {
		return filtroAdvanced;
	}

	public void setFiltroAdvanced(Boolean filtroAdvanced) {
		this.filtroAdvanced = filtroAdvanced;
	}

	public AlertaView getAlertaView() {
		return alertaView;
	}

	public void setAlertaView(AlertaView alertaView) {
		this.alertaView = alertaView;
	}

	public Varejistas getVarejista() {
		return Varejistas.toEnum(varejista);
	}

	public void setVarejista(String varejista) {
		this.varejista = varejista;
	}
}
