package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.VagaDao;
import dominio.Vaga;

public class VagaDaoImpl implements VagaDao {

	private EntityManager em;
	
	public VagaDaoImpl() {
		
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Vaga x) {
		if (x.getCodVaga() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	public void atualizar(Vaga x) {
		if (x.isDisponibilidade() == true) {
			x.setDisponibilidade(false);
			inserirAtualizar(x);
		}
		else{
			x.setDisponibilidade(true);
			inserirAtualizar(x);
		}
		em.persist(x);
	}
	@Override
	public void excluir(Vaga x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Vaga buscar(int cod) {
		return em.find(Vaga.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vaga> buscarTodos() {
		String jpql = "SELECT x FROM Vaga x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

	

}