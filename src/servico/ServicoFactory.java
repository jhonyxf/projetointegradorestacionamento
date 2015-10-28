package servico;

import servico.impl.ClienteServicoImpl;
import servico.impl.FuncionarioServicoImpl;
import servico.impl.LocacaoServicoImpl;
import servico.impl.TipoLocacaoServicoImpl;
import servico.impl.VagaServicoImpl;
import servico.impl.VeiculoServicoImpl;


public class ServicoFactory {

	public static ClienteServico criarClienteServico() {
		return new ClienteServicoImpl();
	}
	
	public static FuncionarioServico criarFuncionarioServico() {
		return new FuncionarioServicoImpl();
	}
	
	public static LocacaoServico criarLocacaoServico() {
		return new LocacaoServicoImpl();
	}
	
	public static TipoLocacaoServico criarTipoLocacaoServico() {
		return new TipoLocacaoServicoImpl();
	}		
	public static VagaServico criarVagaServico() {
			return new VagaServicoImpl();
	}		
	public static VeiculoServico criarVeiculoServico() {
			return new VeiculoServicoImpl();
	}
}