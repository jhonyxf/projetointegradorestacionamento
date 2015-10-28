package servico;

import java.util.List;

import dominio.Vaga;

public interface VagaServico {
	public void inserirAtualizar(Vaga x);
	public void Atualizar(Vaga x);
	public void excluir(Vaga x);
	public Vaga buscar(int cod);
	public List<Vaga> buscarTodos();
}
