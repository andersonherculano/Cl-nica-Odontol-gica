package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_orcamento")
public class Orcamento {
	
	@Id
	private Integer codOrca;
	@Column
	private String dtOrca;
	@Column
	private String hrOrca;
	@Column
	private Float vlOrca;
	
	@OneToMany(mappedBy = "orcamento")
	private List<Procedimento> procedimentos;
	
	@ManyToOne
	@JoinColumn(name="dentista_fk", nullable=false)
	private Dentista dentista;
	
	public Integer getCodOrca() {
		return codOrca;
	}
	public void setCodOrca(Integer codOrca) {
		this.codOrca = codOrca;
	}
	public String getDtOrca() {
		return dtOrca;
	}
	public void setDtOrca(String dtOrca) {
		this.dtOrca = dtOrca;
	}
	public String getHrOrca() {
		return hrOrca;
	}
	public void setHrOrca(String hrOrca) {
		this.hrOrca = hrOrca;
	}
	public Float getVlOrca() {
		return vlOrca;
	}
	public void setVlOrca(Float vlOrca) {
		this.vlOrca = vlOrca;
	}
	@Override
	public String toString() {
		return "Orcamento [codOrca=" + codOrca + ", dtOrca=" + dtOrca + ", hrOrca=" + hrOrca + ", vlOrca=" + vlOrca
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codOrca == null) ? 0 : codOrca.hashCode());
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
		Orcamento other = (Orcamento) obj;
		if (codOrca == null) {
			if (other.codOrca != null)
				return false;
		} else if (!codOrca.equals(other.codOrca))
			return false;
		return true;
	}
	
	
}
