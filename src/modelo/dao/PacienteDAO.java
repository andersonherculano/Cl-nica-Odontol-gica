package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import modelo.dominio.Paciente;

public class PacienteDAO {
		
	private EntityManager manager;
		
	public PacienteDAO() {
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

		public void incluir(Paciente obj1) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.persist(obj1);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				e.printStackTrace();
				this.manager.getTransaction().rollback();
			}
		}

		public void alterar(Paciente obj1) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.merge(obj1);
				// confirmar a transação
				this.manager.getTransaction().commit();
			} catch (Exception e) {
				// desfazer a transação
				this.manager.getTransaction().rollback();
			}
		}

		public void remover(Paciente obj1) {
			// abrir a transação
			this.manager.getTransaction().begin();
			try {
				// atualizar o objeto
				this.manager.remove(obj1);
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
			
			String jpql = "from Paciente P  order by P.nomePaciente";
			TypedQuery<Paciente> query = this.manager.createQuery(jpql, Paciente.class);
			
			return query.getResultList();
		}
	}