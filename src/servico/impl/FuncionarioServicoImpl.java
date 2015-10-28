package servico.impl;

		
		import java.util.List;
		
		import dao.FuncionarioDao;
		import dao.DaoFactory;
		import dao.jpa.EM;
		import dominio.Funcionario;
		import servico.FuncionarioServico;
		
		public class FuncionarioServicoImpl implements FuncionarioServico {
		
			private FuncionarioDao dao;
			
			public FuncionarioServicoImpl() {
				dao = DaoFactory.criarFuncionarioDao();
			}
			
			@Override
			public void inserirAtualizar(Funcionario x) {
				EM.getLocalEm().getTransaction().begin();
				dao.inserirAtualizar(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public void excluir(Funcionario x) {
				EM.getLocalEm().getTransaction().begin();
				dao.excluir(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public Funcionario buscar(int cod) {
				return dao.buscar(cod);
			}
		
			@Override
			public List<Funcionario> buscarTodos() {
				return dao.buscarTodos();
			}
		
		}