package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Consulta;

public class ConsultaDAO {
	private EntityManager manager;

	public ConsultaDAO() {
		super();
		
		this.manager = JPAUtil.criarEntityManager();
	}

	public void fecharConexao() {
		this.manager.close();
	}

	@Override
	protected void finalize() throws Throwable {
		this.fecharConexao();
	}

	public void incluir(Consulta obj) {
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

	public void alterar(Consulta obj) {
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

	public void remover(Consulta obj) {
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

	public Consulta buscar(Integer chave) {
		return this.manager.find(Consulta.class, chave);
	}

	public List<Consulta> buscarTodos() {
		
		String jpql = "from Consulta C  order by C.codConsulta";
		TypedQuery<Consulta> query = this.manager.createQuery(jpql, Consulta.class);
		
		return query.getResultList();
	}

}
