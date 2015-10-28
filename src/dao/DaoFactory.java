package dao;


import dao.jpa.ClienteDaoImpl;

import dao.jpa.FuncionarioDaoImpl;
import dao.jpa.LocacaoDaoImpl;
import dao.jpa.TipoLocacaoDaoImpl;
import dao.jpa.VagaDaoImpl;
import dao.jpa.VeiculoDaoImpl;


public class DaoFactory {

		
	public static ClienteDao criarClienteDao() {
		return new ClienteDaoImpl();
	}
	
	public static FuncionarioDao criarFuncionarioDao() {
		return new FuncionarioDaoImpl();
	}
	
	public static LocacaoDao criarLocacaoDao() {
		return new LocacaoDaoImpl();
	}
	
	public static VeiculoDao criarVeiculoDao () {
		return new VeiculoDaoImpl();
	}
	
	public static TipoLocacaoDao criarTipoLocacaoDao() {
		return new TipoLocacaoDaoImpl();
	}
	
	public static VagaDao criarVagaDao() {
		return new VagaDaoImpl();
	}
}