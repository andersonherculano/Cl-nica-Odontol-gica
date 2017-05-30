package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Dentista;

public class DentistaDAO {
	private EntityManager manager;
	
	public DentistaDAO() {
		super();
		this.manager = UtilJPA.criarEntityManager();
	}
		
		public void fecharConexao() {
			this.manager.close();
		}

		@Override
		protected void finalize() throws Throwable {
			this.fecharConexao();
		}

		public void incluir(Dentista obj4) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.persist(obj4);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				e.printStackTrace();
				this.manager.getTransaction().rollback();
			}
		}

		public void alterar(Dentista obj4) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.merge(obj4);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				this.manager.getTransaction().rollback();
			}
		}

		public void remover(Dentista obj4) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.remove(obj4);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				this.manager.getTransaction().rollback();
			}
		}

		public Dentista buscar(Integer chave) {
			return this.manager.find(Dentista.class, chave);
		}

		public List<Dentista> buscarTodos() {
			
			String jpql = "from Dentista D  order by D.cro";
			TypedQuery<Dentista> query = this.manager.createQuery(jpql, Dentista.class);
			
			return query.getResultList();
		}
}
