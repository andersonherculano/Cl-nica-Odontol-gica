package modelo.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_procedimento")
public class Procedimento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PROCEDIEMENTO")
	@SequenceGenerator(name="PROCEDIMENTO", allocationSize=1,
						sequenceName="SEQ_PROCEDIMENTO")
	private Integer codProced;
	@Column
	private String nomeProced;
	@Column
	private Float vlProced;
	
	@ManyToOne
	@JoinColumn(name="consulta_fk", nullable=false)
	private Consulta consulta;
	
	@ManyToOne
	@JoinColumn(name="orcamento_fk", nullable=false)
	private Orcamento orca;
	
	public Integer getCodProced() {
		return codProced;
	}
	public void setCodProced(Integer codProced) {
		this.codProced = codProced;
	}
	public String getNomeProced() {
		return nomeProced;
	}
	public void setNomeProced(String nomeProced) {
		this.nomeProced = nomeProced;
	}
	public Float getVlProced() {
		return vlProced;
	}
	public void setVlProced(Float vlProced) {
		this.vlProced = vlProced;
	}
	@Override
	public String toString() {
		return "Procedimento [codProced=" + codProced + ", nomeProced=" + nomeProced + ", vlProced=" + vlProced + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codProced == null) ? 0 : codProced.hashCode());
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
		Procedimento other = (Procedimento) obj;
		if (codProced == null) {
			if (other.codProced != null)
				return false;
		} else if (!codProced.equals(other.codProced))
			return false;
		return true;
	}
	
	
}
