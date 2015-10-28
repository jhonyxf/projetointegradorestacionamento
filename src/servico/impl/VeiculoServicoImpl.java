package servico.impl;

		
		import java.util.List;
		
		import dao.VeiculoDao;
		import dao.DaoFactory;
		import dao.jpa.EM;
		import dominio.Veiculo;
		import servico.VeiculoServico;
		
		public class VeiculoServicoImpl implements VeiculoServico {
		
			private VeiculoDao dao;
			
			public VeiculoServicoImpl() {
				dao = DaoFactory.criarVeiculoDao();
			}
			
			@Override
			public void inserirAtualizar(Veiculo x) {
				EM.getLocalEm().getTransaction().begin();
				dao.inserirAtualizar(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public void excluir(Veiculo x) {
				EM.getLocalEm().getTransaction().begin();
				dao.excluir(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public Veiculo buscar(int cod) {
				return dao.buscar(cod);
			}
		
			@Override
			public List<Veiculo> buscarTodos() {
				return dao.buscarTodos();
			}
		
		}