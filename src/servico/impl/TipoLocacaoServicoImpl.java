package servico.impl;

		
		import java.util.List;
		
		import dao.TipoLocacaoDao;
		import dao.DaoFactory;
		import dao.jpa.EM;
		import dominio.TipoLocacao;
		import servico.TipoLocacaoServico;
		
		public class TipoLocacaoServicoImpl implements TipoLocacaoServico {
		
			private TipoLocacaoDao dao;
			
			public TipoLocacaoServicoImpl() {
				dao = DaoFactory.criarTipoLocacaoDao();
			}
			
			@Override
			public void inserirAtualizar(TipoLocacao x) {
				EM.getLocalEm().getTransaction().begin();
				dao.inserirAtualizar(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public void excluir(TipoLocacao x) {
				EM.getLocalEm().getTransaction().begin();
				dao.excluir(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public TipoLocacao buscar(int cod) {
				return dao.buscar(cod);
			}
		
			@Override
			public List<TipoLocacao> buscarTodos() {
				return dao.buscarTodos();
			}
		
		}