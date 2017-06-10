package modelo.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tab_dentista")
public class Dentista {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DENTISTA")
	@SequenceGenerator(name="DENTISTA", allocationSize=1,
						sequenceName="SEQ_DENTISTA")
	private Integer codDentista;
	@Column
	private String cro;
	@Column
	private String nomeDentista;
	@Column
	private String telefone;
	@Column
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
