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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Jhony
 */

@Entity
@Table(name="tb_cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codCliente;
	
	@Basic
	@Column(nullable=false, length=100)
    private String nome;
	
	@Basic
	@Column(nullable=false, length=15)
    private String telefone;
    

    @OneToMany(mappedBy="cliente") 
    private List<Locacao> locacoes;
    
    @OneToMany(mappedBy="cliente") 
    private List<Veiculo> veiculos;

    public Cliente() {

        locacoes = new ArrayList<Locacao>();
        veiculos = new ArrayList<Veiculo>();
    }

    public Cliente(Integer codCliente, String nome,String telefone) {
        this.codCliente = codCliente;
        this.nome = nome;
        this.telefone = telefone;
        locacoes = new ArrayList<Locacao>();
        veiculos = new ArrayList<Veiculo>();
    }
    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(ArrayList<Locacao> locacoes) {
        this.locacoes = locacoes;
    }


    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(ArrayList<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
    
    public void addLocacao(Locacao l){
        this.locacoes.add(l);
    }
    public void removeLocacao(Locacao l){
        this.locacoes.remove(l);
    }
    

    public void addVeiculo(Veiculo v){
        this.veiculos.add(v);
    }

    public void removeVeiculo(Veiculo v){
        this.veiculos.remove(v);
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nome=" + nome + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.codCliente);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.codCliente, other.codCliente)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}
