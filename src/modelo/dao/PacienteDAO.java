package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Paciente;

public class PacienteDAO {
	
	private EntityManager manager;

	public PacienteDAO() {
		super();
		
		this.manager = JPAUtil.getEntityManager();
	}

	public void fecharConexao() {
		this.manager.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.fecharConexao();
	}

	public void incluir(Paciente obj) {
		// abrir a transação
		this.manager.getTransaction().begin();
		try {
			// atualizar o objeto
			this.manager.persist(obj);
			// confirmar a transação
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			// desfazer a transação
			e.printStackTrace();
			this.manager.getTransaction().rollback();
		}
	}

	public void alterar(Paciente obj) {
		// abrir a transação
		this.manager.getTransaction().begin();
		try {
			// atualizar o objeto
			this.manager.merge(obj);
			// confirmar a transação
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			// desfazer a transação
			this.manager.getTransaction().rollback();
		}
	}

	public void remover(Paciente obj) {
		// abrir a transação
		this.manager.getTransaction().begin();
		try {
			// atualizar o objeto
			this.manager.remove(obj);
			// confirmar a transação
			this.manager.getTransaction().commit();
		} catch (Exception e) {
			// desfazer a transação
			this.manager.getTransaction().rollback();
		}
	}

	public Paciente buscar(Integer chave) {
		return this.manager.find(Paciente.class, chave);
	}

	public List<Paciente> buscarTodos() {
		
		String jpql = "from Paciente p  order by p.codigo";
		TypedQuery<Paciente> query = this.manager.createQuery(jpql, Paciente.class);
		
		return query.getResultList();
	}
}