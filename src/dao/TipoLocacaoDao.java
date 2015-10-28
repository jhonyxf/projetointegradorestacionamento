package dao;

import java.util.List;

import dominio.TipoLocacao;

public interface TipoLocacaoDao {

	public void inserirAtualizar(TipoLocacao x);
	public void excluir(TipoLocacao x);
	public TipoLocacao buscar(int cod);
	public List<TipoLocacao> buscarTodos();
}
