package modelo.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tab_paciente")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Paciente {
	
	@Id
	private Integer codPaciente;
	@Column
	private String nomePaciente;
	@Column
	private String cpf;
	@Column
	private String rg;
	@Column
	private String dtNasc;
	@Column
	private String telefone;
	@Column
	private String email;
	
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;
	
	@Column
	private ArrayList<Agenda> agenda = new ArrayList<Agenda>();
	
	public ArrayList<Agenda> getAgenda() {
		return agenda;
	}
	public void setAgenda(ArrayList<Agenda> agenda) {
		this.agenda = agenda;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}
	
	public Integer getCodPaciente() {
		return codPaciente;
	}
	public void setCodPaciente(Integer codPaciente) {
		this.codPaciente = codPaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getDtNasc() {
		return dtNasc;
	}
	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Paciente [codPaciente=" + codPaciente + ", nomePaciente=" + nomePaciente + ", cpf=" + cpf + ", rg=" + rg
				+ ", dtNasc=" + dtNasc + ", telefone=" + telefone + ", email=" + email + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPaciente == null) ? 0 : codPaciente.hashCode());
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
		Paciente other = (Paciente) obj;
		if (codPaciente == null) {
			if (other.codPaciente != null)
				return false;
		} else if (!codPaciente.equals(other.codPaciente))
			return false;
		return true;
	}
	
	
}
