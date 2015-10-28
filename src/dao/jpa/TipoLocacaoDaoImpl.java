package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.TipoLocacaoDao;
import dominio.TipoLocacao;

public class TipoLocacaoDaoImpl implements TipoLocacaoDao {

	private EntityManager em;
	
	public TipoLocacaoDaoImpl() {
		
		this.em = EM.getLocalEm();
	}
	
	@Override
	public void inserirAtualizar(TipoLocacao x) {
		if (x.getCodTipoLocacao() != null) {
			x = em.merge(x);
		}
		em.persist(x);
	}

	@Override
	public void excluir(TipoLocacao x) {
		x = em.merge(x);
		em.remove(x);
	}

	@Override
	public TipoLocacao buscar(int cod) {
		return em.find(TipoLocacao.class, cod);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TipoLocacao> buscarTodos() {
		String jpql = "SELECT x FROM TipoLocacao x";
		Query query = em.createQuery(jpql);
		return query.getResultList();
	}

}