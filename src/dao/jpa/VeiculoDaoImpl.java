package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.VeiculoDao;
import dominio.Veiculo;

public class VeiculoDaoImpl implements VeiculoDao {

	private EntityManager em;
	
	public VeiculoDaoImpl() {
		
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(Veiculo x) {
		if (x.getCodVeiculo() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(Veiculo x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public Veiculo buscar(int cod) {
		return em.find(Veiculo.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Veiculo> buscarTodos() {
		String jpql = "SELECT x FROM Veiculo x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}