package dominio;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="tb_veiculo")
public class Veiculo implements Serializable{
    
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codVeiculo;
	
	@Basic
	@Column(nullable=false, length=10)
    private String placa;
    
    @ManyToOne
    @JoinColumn(name="cliente")
    private Cliente cliente;
    
    @Basic
	@Column(nullable=false)
    @OneToMany(mappedBy="veiculo") 
    private List<Locacao> locacoes;

    public Veiculo() {
    	this. locacoes = new ArrayList<Locacao>();
    }

    public Veiculo(Integer codVeiculo,String placa, Cliente cliente) {
        this.codVeiculo = codVeiculo;
        this.cliente = cliente;
        this.placa = placa;
        this. locacoes = new ArrayList<Locacao>();
    }

    public Integer getCodVeiculo() {
        return codVeiculo;
    }

    public void setCodVeiculo(Integer codVeiculo) {
        this.codVeiculo = codVeiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }
    
    public void addLocacao(Locacao l){
        this.locacoes.add(l);
    }
    public void removeLocacao(Locacao l){
        this.locacoes.remove(l);
    }
    


    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	
	
	
	
	@Override
	public String toString() {
		return "Veiculo [codVeiculo=" + codVeiculo + ", placa=" + placa + ", cliente=" + cliente ;
	}

	@Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.codVeiculo);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.codVeiculo, other.codVeiculo)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
