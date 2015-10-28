package servico;

import java.util.List;

import dominio.Funcionario;

public interface FuncionarioServico {

	public void inserirAtualizar(Funcionario x);
	public void excluir(Funcionario x);
	public Funcionario buscar(int cod);
	public List<Funcionario> buscarTodos();
}
