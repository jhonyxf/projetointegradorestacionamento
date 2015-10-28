package aplicacao;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import dominio.Cliente;
import dominio.Funcionario;
import dominio.Locacao;
import dominio.TipoLocacao;
import dominio.Vaga;
import dominio.Veiculo;
import servico.ClienteServico;
import servico.FuncionarioServico;
import servico.LocacaoServico;
import servico.ServicoFactory;
import servico.TipoLocacaoServico;
import servico.VagaServico;
import servico.VeiculoServico;

public class Principal2{

public static void main(String args[]) throws ParseException {

		Scanner sc = new Scanner(System.in);
		int op;
		
		int cod;
		
				
		Cliente cli = null;
		Funcionario func = null;
		Locacao loc = null;
		TipoLocacao tipoloc= null;
		Vaga vag= null;
		Veiculo vei = null;
		
		
		ClienteServico clienteServico = ServicoFactory.criarClienteServico();
		FuncionarioServico funcionarioServico = ServicoFactory.criarFuncionarioServico();
		LocacaoServico locacaoServico = ServicoFactory.criarLocacaoServico();
		TipoLocacaoServico tipolocacaoServico = ServicoFactory.criarTipoLocacaoServico();
		VagaServico vagaServico = ServicoFactory.criarVagaServico();
		VeiculoServico veiculoServico = ServicoFactory.criarVeiculoServico();

		do {
			System.out.println("--------- ESTACIONAMENTO EAKI -------------");
			System.out.println("Digite 1 para Cadastrar Vaga.");
			System.out.println("Digite 2 para Cadastrar Veiculo.");
			System.out.println("Digite 3 para Cadastrar Cliente.");
			System.out.println("Digite 4 para Registrar locação.");
			System.out.println("Digite 5 para Atualizar valores.");
			System.out.println("Digite 6 para Gerenciar vaga.");
			System.out.println("Digite 7 - Sair.");
			op = sc.nextInt();
			
			switch (op) {
			case 1:
				
				List<Vaga> listVaga = vagaServico.buscarTodos();
				
				System.out.println("Vagas existentes: ");
				for (Vaga x : listVaga) {
					System.out.println(x);
				}
									
				System.out.println("A nova vaga devera estar [ 1 - disponivel , 0 - indisponivel ] ? ");
				int disponibilidade =  Integer.parseInt(sc.next());
				
				boolean disp = false;
				if(disponibilidade == 0){
					disp = false;
				}
				else if(disponibilidade == 1){
					disp = true;
				}
					
				System.out.println("Digite o cod da nova vaga ");
				int numero =  Integer.parseInt(sc.next());
										
				List<Vaga> listVagaa = vagaServico.buscarTodos();
				for (Vaga x : listVagaa) {
					if (x.equals(numero)){
						System.out.println("Essa vaga já existe");
						break;
					}
					else{
						vag = new Vaga(null,numero,disp);
						try{
						vagaServico.inserirAtualizar(vag);
						System.out.println("Vaga inserida! ");
						}
						catch (Exception e) {
							
							System.out.println("Erro ao inserir vaga!");
						}
						break;
						
					}
				}
	
				break;

			case 2:
				
				List<Veiculo> listVeiculo = veiculoServico.buscarTodos();
				
				System.out.println("Veiculos existentes: ");
				for (Veiculo x : listVeiculo) {
					System.out.println(x);
				}
					
				System.out.println("Digite o codigo do cliente dono do veículo: ");
						int codCliente = Integer.parseInt(sc.next());
						
						cli = clienteServico.buscar(codCliente);
						
						if (cli == null) {
							System.out.println("Código de Cliente inexistente!");
						}
						
						else{
							System.out.println("Digite a placa do novo cliente: ");
							String placa = sc.next();
							
						
							vei = new Veiculo(null,placa,cli);
						}
						
						
					try {
						veiculoServico.inserirAtualizar(vei);
									
						System.out.println("Veiculo inserido com sucesso! ");
					}
					catch (Exception e) {
						
						System.out.println("Erro ao inserir veiculo!" + e.getMessage());
					}
					
				break;

			case 3:
								
				List<Cliente> listCliente = clienteServico.buscarTodos();
				
				System.out.println("Clientes existentes: ");
				for (Cliente x : listCliente) {
					System.out.println(x);
				}
									
				System.out.println("Digite o nome do novo cliente: ");
				String nome = sc.next();
					
				System.out.println("Digite o telefone do novo cliente: ");
				String telefone = sc.next();
				
				cli = new Cliente(null,nome,telefone);
												
					try {
						clienteServico.inserirAtualizar(cli);
						System.out.println("Cliente inserido! ");
					}
					catch (Exception e) {
						
						System.out.println("Falha ao inserir cliente!");
				}
									
				break;

			case 4:

					List<Locacao> listLocacao = locacaoServico.buscarTodos();
				
					System.out.println("Locacoes existentes: ");
					for (Locacao x : listLocacao) {
						System.out.println(x);
					}
					
					//Data
					
						System.out.println("Digite o data da locacao (dd/mm/yyyy): ");
						String data = sc.next();
						DateFormat df = new SimpleDateFormat("dd/MM/yyyy");    
					    Date dt = df.parse(data);
					
				
					//Funcionario
					System.out.println("Digite o cog do funcionario da locacao: ");
					int cod_func = Integer.parseInt(sc.next());
					
					func = funcionarioServico.buscar(cod_func);
					
					
					// Veiculo
					System.out.println("Digite o cog do veiculo da locacao: ");
					int cod_vei = Integer.parseInt(sc.next());
					
					vei = veiculoServico.buscar(cod_vei);
					
					// Vaga
					System.out.println("Digite o cog do vaga da locacao: ");
					int cod_vaga = Integer.parseInt(sc.next());
					
					vag = vagaServico.buscar(cod_vaga);
					
					
					// Cliente
					System.out.println("Digite o cog do cliente da locacao: ");
					int cod_cli = Integer.parseInt(sc.next());
					
					cli = clienteServico.buscar(cod_cli);
					
					// TipoLocacao
					System.out.println("Digite o cog do tipo da locacao: ");
					int cod_tipo = Integer.parseInt(sc.next());
					
					tipoloc = tipolocacaoServico.buscar(cod_tipo);
				
					if (func == null || vag == null || tipoloc == null || vei == null || cli == null) {
						System.out.println("Código inexistente!");
					} else {
						
						loc = new Locacao(null,dt,func,vei,vag,cli,tipoloc);
						
						try {
							locacaoServico.inserirAtualizar(loc);

							System.out.println("Locacao feita com sucesso! ");
						}
						catch (Exception e) {
							
							System.out.println("Falha ao efetuar a locação!");
					}
						
						
					}
					break;
					
			case 5:
				
				List<TipoLocacao> listTipoLocacao = tipolocacaoServico.buscarTodos();
				
				System.out.println("Tipos de locações existentes: ");
				for (TipoLocacao x : listTipoLocacao) {
					System.out.println(x);
				}
				
				System.out.println("Deseja alterar o valor de algum tipo de locação ? 1 - Sim ; 2 - Não");
				int opcao1 = Integer.parseInt(sc.next());
				
				
				if (opcao1 == 1){
					System.out.println("Digite o cog do tipo d locacao que deseja alterar: ");
					int tipo = Integer.parseInt(sc.next());
					
					tipoloc = tipolocacaoServico.buscar(tipo);
					
					System.out.println("Qual o novo valor ?");
					BigDecimal valor = sc.nextBigDecimal();
					
					try{
					tipoloc.setPreco(valor);
					
					tipolocacaoServico.inserirAtualizar(tipoloc);
					
					System.out.println("Novo valor alterado com sucesso");
					}
					catch (Exception e) {
						
						System.out.println("Falha ao alterar o valor da locação!");
				}
				}
				else if (opcao1 == 2){
					System.out.println("OK então..");
				}
				else{
					System.out.println("Opção incorreta.");
				}
					
				
				break;
			case 6:
				List<Vaga> listVagas = vagaServico.buscarTodos();
				
				System.out.println("Vagas existentes: ");
				for (Vaga x : listVagas) {
					System.out.println(x);
				}
				
				System.out.println("Deseja habilitar ou desabilitar alguma vaga ? 1 - Sim 2 - Não");
				int opcao = Integer.parseInt(sc.next()); 
				
				
				if (opcao == 1){
					
					// Vaga
					System.out.println("Digite o cog do vaga que deseja habilitar ou dsabilitar: ");
					int vaguinha = Integer.parseInt(sc.next());
					
					vag = vagaServico.buscar(vaguinha);
					try{
					//	vagaServico.inserirAtualizar(vag);
					vagaServico.Atualizar(vag);
					System.out.println("Vaga alterada com sucesso");
					}
					catch (Exception e) {
						
						System.out.println("Falha ao alterar a vaga!");
				}
					
				}
				
			break;
			case 7:
				System.out.println("Saindo do programa.");
				break;
			default:
					System.out.println("Opção Invalida.");

		} 
		}
		while (op != 7);

		
	}

}
