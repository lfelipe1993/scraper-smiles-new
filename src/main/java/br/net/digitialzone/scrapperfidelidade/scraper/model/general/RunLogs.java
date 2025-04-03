package br.net.digitialzone.scrapperfidelidade.scraper.model.general;

import java.io.Serializable;
import java.sql.Timestamp;

import br.net.digitialzone.scrapperfidelidade.utils.CatchProgramFidel;

public class RunLogs implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String program;
	private Timestamp dataHorario;
	
	public RunLogs() {
		// TODO Auto-generated constructor stub
	}

	public RunLogs(Integer id, String program, Timestamp dataHorario) {
		this.id = id;
		this.program = program;
		this.dataHorario = dataHorario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MilesProgram getProgram() {
		return CatchProgramFidel.toEnum(program);
	}

	public void setProgram(MilesProgram program) {
		this.program = program.getProgramName();
	}

	public Timestamp getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(Timestamp dataHorario) {
		this.dataHorario = dataHorario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RunLogs other = (RunLogs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
