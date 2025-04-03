package br.net.digitialzone.scrapperfidelidade.scraper.model.general;

import java.io.Serializable;

public class MilesProgram  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String programName;
	private Double milesValue;
	
	public MilesProgram() {
		// TODO Auto-generated constructor stub
	}
	
	public MilesProgram(MilesProgram milesProgram) {
		this.id = milesProgram.getId();
		this.programName = milesProgram.getProgramName();
		this.milesValue = milesProgram.getMilesValue();
	}

	public MilesProgram(Integer id, String programName, Double milesValue) {
		super();
		this.id = id;
		this.programName = programName;
		this.milesValue = milesValue;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}

	public Double getMilesValue() {
		return milesValue;
	}

	public void setMilesValue(Double milesValue) {
		this.milesValue = milesValue;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((milesValue == null) ? 0 : milesValue.hashCode());
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
		MilesProgram other = (MilesProgram) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (milesValue == null) {
			if (other.milesValue != null)
				return false;
		} else if (!milesValue.equals(other.milesValue))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MilesProgram [id=");
		builder.append(id);
		builder.append(", programName=");
		builder.append(programName);
		builder.append(", milesValue=");
		builder.append(milesValue);
		builder.append("]");
		return builder.toString();
	}

}
