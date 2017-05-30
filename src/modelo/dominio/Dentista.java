package modelo.dominio;

import java.util.List;

import javax.persistence.OneToMany;

public class Dentista {
	
	private Integer codDentista;
	private String cro;
	private String nomeDentista;
	private String telefone;
	private String email;
	
	@OneToMany(mappedBy = "dentista")
	private List<Consulta> consultas;
	
	@OneToMany(mappedBy = "dentista")
	private List<Orcamento> orcamentos;
	
	public Integer getCodDentista() {
		return codDentista;
	}
	public void setCodDentista(Integer codDentista) {
		this.codDentista = codDentista;
	}
	public String getCro() {
		return cro;
	}
	public void setCro(String cro) {
		this.cro = cro;
	}
	public String getNomeDentista() {
		return nomeDentista;
	}
	public void setNomeDentista(String nomeDentista) {
		this.nomeDentista = nomeDentista;
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
	
	
}
