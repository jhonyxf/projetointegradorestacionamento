package servico;

import java.util.List;

import dominio.Veiculo;

public interface VeiculoServico {

	public void inserirAtualizar(Veiculo x);
	public void excluir(Veiculo x);
	public Veiculo buscar(int cod);
	public List<Veiculo> buscarTodos();
}
