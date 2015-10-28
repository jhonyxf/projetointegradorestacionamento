package servico.impl;

		
		import java.util.List;

import dao.DaoFactory;
import dao.VagaDao;
import dao.jpa.EM;
import dominio.Vaga;

import servico.VagaServico;
		
		public class VagaServicoImpl implements VagaServico {
		
			private VagaDao dao;
			
			public VagaServicoImpl() {
				dao = DaoFactory.criarVagaDao();
			}
			
			@Override
			public void inserirAtualizar(Vaga x) {
				EM.getLocalEm().getTransaction().begin();
					dao.inserirAtualizar(x);
					EM.getLocalEm().getTransaction().commit();
			}
						
		
			@Override
			public void excluir(Vaga x) {
				EM.getLocalEm().getTransaction().begin();
				dao.excluir(x);
				EM.getLocalEm().getTransaction().commit();
			}
		
			@Override
			public Vaga buscar(int cod) {
				return dao.buscar(cod);
			}
		
			@Override
			public List<Vaga> buscarTodos() {
				return dao.buscarTodos();
			}

			@Override
			public void Atualizar(Vaga x) {
				EM.getLocalEm().getTransaction().begin();
				dao.atualizar(x);
				EM.getLocalEm().getTransaction().commit();
				
			}
		
		}