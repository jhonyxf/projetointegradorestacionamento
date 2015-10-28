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



@Entity
@Table(name="tb_funcionario")
public class Funcionario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codFuncionario;
	
	@Basic
	@Column(nullable=false, length=100)
    private String nome;
	
	@Basic
	@Column(nullable=false, length=30)
	private String cargo;
    
    @OneToMany(mappedBy="funcionario")    
    private List<Locacao> locacoes;

    public Funcionario() {
    	this.locacoes = new ArrayList<Locacao>();
    }

    public Funcionario(Integer codFuncionario, String nome, String cargo) {
        this.codFuncionario = codFuncionario;
        this.nome = nome;
        this.cargo = cargo;
        this.locacoes = new ArrayList<Locacao>();
    }

    public Integer getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(Integer codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    @Override
    public String toString() {
        return "Funcionario{" + "codFuncionario=" + codFuncionario + ", nome=" + nome + ", cargo=" + cargo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.codFuncionario);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.codFuncionario, other.codFuncionario)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
