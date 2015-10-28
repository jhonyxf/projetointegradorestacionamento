package servico;

import java.util.List;

import dominio.Locacao;

public interface LocacaoServico {

	public void inserirAtualizar(Locacao x);
	public void excluir(Locacao x);
	public Locacao buscar(int cod);
	public List<Locacao> buscarTodos();
}
