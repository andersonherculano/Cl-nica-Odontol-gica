package modelo.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_consulta")
public class Consulta {
	
	@Id
	private Integer codConsulta;
	@Column
	private Float vlConsulta;
	
	@Column
	private ArrayList<Agenda> agenda = new ArrayList<Agenda>();
	
	@ManyToOne
	@JoinColumn(name="dentista_fk", nullable=false)
	private Paciente dentista;
	
	@OneToMany(mappedBy = "consulta")
	private List<Procedimento> procedimentos;
	
	public ArrayList<Agenda> getAgenda() {
		return agenda;
	}

	public void setAgenda(ArrayList<Agenda> agenda) {
		this.agenda = agenda;
	}

	public Consulta() {
		super();
	}

	public Integer getCodConsulta() {
		return codConsulta;
	}
	public void setCodConsulta(Integer codConsulta) {
		this.codConsulta = codConsulta;
	}
	public Float getVlConsulta() {
		return vlConsulta;
	}
	public void setVlConsulta(Float vlConsulta) {
		this.vlConsulta = vlConsulta;
	}
	
	@Override
	public String toString() {
		return "Consulta [codConsulta=" + codConsulta + ", vlConsulta=" + vlConsulta + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codConsulta == null) ? 0 : codConsulta.hashCode());
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
		Consulta other = (Consulta) obj;
		if (codConsulta == null) {
			if (other.codConsulta != null)
				return false;
		} else if (!codConsulta.equals(other.codConsulta))
			return false;
		return true;
	}
}
