package dao;

import java.util.List;
import dominio.Vaga;


public interface VagaDao {

	public void inserirAtualizar(Vaga x);
	public void atualizar(Vaga x);
	public void excluir(Vaga x);
	public Vaga buscar(int cod);
	public List<Vaga> buscarTodos();
}
