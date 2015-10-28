package dominio;



import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javafx.scene.chart.PieChart.Data;



@Entity
@Table(name="tb_locacao")
public class Locacao implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codLocacao;
	
	@Basic
	@Column(nullable=false)
    private Date entrada;
	
	@Basic
	@Column(nullable=true)
    private BigDecimal preco;
	
	@Basic
	@Column(nullable=true)
    private Date saida;
	

    @ManyToOne
    @JoinColumn(name="cliente")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name="funcionario")
    private Funcionario funcionario;
    
    @ManyToOne
    @JoinColumn(name="tipoLocacao")
    private TipoLocacao tipoLocacao;
    
	
    
    @ManyToOne
    @JoinColumn(name="vaga")
    private Vaga vaga;
    
    
    @ManyToOne
    @JoinColumn(name="veiculo")
    private Veiculo veiculo;
    

    public Locacao() {
    }

    public Locacao(Integer codLocacao, Date entrada, Funcionario funcionario, Veiculo veiculo, Vaga vaga, Cliente cliente, TipoLocacao tipolocacao) {
        this.codLocacao = codLocacao;
        this.entrada = entrada;
        this.funcionario = funcionario;
        this.veiculo = veiculo;
        this.vaga = vaga;
        this.cliente = cliente;
        this.tipoLocacao = tipolocacao;
    }

    public Integer getCodLocacao() {
        return codLocacao;
    }

    public void setCodLocacao(Integer codLocacao) {
        this.codLocacao = codLocacao;
    }

  


    public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public TipoLocacao getTipoLocacao() {
		return tipoLocacao;
	}

	public void setTipoLocacao(TipoLocacao tipoLocacao) {
		this.tipoLocacao = tipoLocacao;
	}

	public Date getEntrada() {
		return entrada;
	}

	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}

	public Date getSaida() {
		return saida;
	}

	public void setSaida(Date saida) {
		this.saida = saida;
	}

	public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }



    @Override
	public String toString() {
		return "Locacao [codLocacao=" + codLocacao + ", entrada=" + entrada + ", saida=" + saida + ", preco=" + preco
				+ ", funcionario=" + funcionario + ", veiculo=" + veiculo + ", vaga=" + vaga + ", cliente=" + cliente
				+ ", tipoLocacao=" + tipoLocacao + "]";
	}

	@Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.codLocacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Locacao other = (Locacao) obj;
        if (!Objects.equals(this.codLocacao, other.codLocacao)) {
            return false;
        }
        return true;
    }
    
    
    public boolean realizarLocacao(Cliente c, Vaga v, Veiculo ve, Funcionario f, TipoLocacao l, Date d){
    	this.cliente = c;
    	this.vaga = v;
    	this.veiculo = ve;
    	this.funcionario = f;
    	this.tipoLocacao = l;
    	this.entrada = d;
    	
    	return true;
    }
    
    public void finalizarLocacao(){
    	//Data d = new Data();
    	//Calendar c = Calendar.getInstance(); 
    	//Convertendo as datas para milisegundos  
       //long milisecondBegin = saida.getTime();  
       //long milisecondEnd = entrada.getTime();
        
        //Date d = c.getTime();  
      // long qtdhoras = milisecondBegin - milisecondEnd;
        //Date qtdhoras = this.entrada - this.saida;
     //  int a = Integer.parseInt(qtdhoras.format(d));
       //int a = (int)d.getTime();  
       
    	//BigDecimal resultado = a * tipoLocacao.getPreco();
    	//this.preco = resultado;
    	
    }
    
    public void consultarValorPagar(){
    	//Date data=new Date();
    	//Date data1=new Date();
    	//long tempo =data1.getTime() - data.getTime();
    	//Date data2 = new Date(tempo);
    	//System.out.println("Os minutos são:" + data2);
    	
    }
    
    
    	
    
    
    
}
