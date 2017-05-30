package modelo.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UtilJPA {
		
	private static EntityManagerFactory factory =
			Persistence.createEntityManagerFactory("meu_banco");
		
		public static EntityManager criarEntityManager() {
			EntityManager manager = factory.createEntityManager();
			return manager;
		}

	}