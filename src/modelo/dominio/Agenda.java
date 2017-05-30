package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tab_agenda")
public class Agenda {
	
	@Id
	private Integer codAgenda;
	@Column
	private String dtAgenda;
	@Column
	private String hrAgenda;
	@Column
	
	@ManyToOne
	@JoinColumn(name="paciente_fk", nullable=false)
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="consulta_fk", nullable=false)
	private Paciente consulta;
	
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Integer getCodAgenda() {
		return codAgenda;
	}
	public void setCodAgenda(Integer codAgenda) {
		this.codAgenda = codAgenda;
	}
	public String getDtAgenda() {
		return dtAgenda;
	}
	public void setDtAgenda(String dtAgenda) {
		this.dtAgenda = dtAgenda;
	}
	public String getHrAgenda() {
		return hrAgenda;
	}
	public void setHrAgenda(String hrAgenda) {
		this.hrAgenda = hrAgenda;
	}
	@Override
	public String toString() {
		return "Agenda [codAgenda=" + codAgenda + ", dtAgenda=" + dtAgenda + ", hrAgenda=" + hrAgenda + ", paciente="
				+ paciente + ", consulta=" + consulta + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAgenda == null) ? 0 : codAgenda.hashCode());
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
		Agenda other = (Agenda) obj;
		if (codAgenda == null) {
			if (other.codAgenda != null)
				return false;
		} else if (!codAgenda.equals(other.codAgenda))
			return false;
		return true;
	}
	
	
}
