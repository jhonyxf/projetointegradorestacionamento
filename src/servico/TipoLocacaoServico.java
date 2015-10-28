package servico;

import java.util.List;

import dominio.TipoLocacao;

public interface TipoLocacaoServico {
	public void inserirAtualizar(TipoLocacao x);
	public void excluir(TipoLocacao x);
	public TipoLocacao buscar(int cod);
	public List<TipoLocacao> buscarTodos();
}
