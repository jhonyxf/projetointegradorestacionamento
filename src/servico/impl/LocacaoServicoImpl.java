package servico.impl;

		
		import java.util.List;
		
		import dao.LocacaoDao;
		import dao.DaoFactory;
		import dao.jpa.EM;
		import dominio.Locacao;
		import servico.LocacaoServico;
		
		public class LocacaoServicoImpl implements LocacaoServico {
		
			private LocacaoDao dao;
			
			public LocacaoServicoImpl() {
				dao = DaoFactory.criarLocacaoDao();
			}
			
			@Override
			public void inserirAtualizar(Locacao x) {
				EM.getLocalEm().getTransaction().begin();
				dao.inserirAtualizar(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public void excluir(Locacao x) {
				EM.getLocalEm().getTransaction().begin();
				dao.excluir(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public Locacao buscar(int cod) {
				return dao.buscar(cod);
			}
		
			@Override
			public List<Locacao> buscarTodos() {
				return dao.buscarTodos();
			}
		
		}