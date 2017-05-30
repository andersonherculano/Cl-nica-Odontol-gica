package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Procedimento;

public class ProcedimentoDAO {
	private EntityManager manager;
	
	public ProcedimentoDAO() {
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

		public void incluir(Procedimento obj5) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.persist(obj5);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				e.printStackTrace();
				this.manager.getTransaction().rollback();
			}
		}

		public void alterar(Procedimento obj5) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.merge(obj5);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				this.manager.getTransaction().rollback();
			}
		}

		public void remover(Procedimento obj5) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.remove(obj5);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				this.manager.getTransaction().rollback();
			}
		}

		public Procedimento buscar(Integer chave) {
			return this.manager.find(Procedimento.class, chave);
		}

		public List<Procedimento> buscarTodos() {
			
			String jpql = "from Procedimento Pr  order by Pr.nomeProced";
			TypedQuery<Procedimento> query = this.manager.createQuery(jpql, Procedimento.class);
			
			return query.getResultList();
		}
}
