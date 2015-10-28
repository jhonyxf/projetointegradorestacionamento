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
@Table(name="tb_vaga")
public class Vaga implements Serializable{
    
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer codVaga;
	
	@Basic
	@Column(nullable=false)
    private Integer numero;
	
    private boolean disponibilidade;
    
   
    @OneToMany(mappedBy="vaga") 
    private List<Locacao> locacoes;

    public Vaga() {
    	
    	this.locacoes = new ArrayList<Locacao>();
    }

    public Vaga(Integer codVaga, Integer numero, boolean disponibilidade) {
        this.codVaga = codVaga;
        this.numero = numero;
        this.disponibilidade = disponibilidade;
        this.locacoes = new ArrayList<Locacao>();
    }

    public Integer getCodVaga() {
        return codVaga;
    }

    public void setCodVaga(Integer codVaga) {
        this.codVaga = codVaga;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
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
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.codVaga);
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
        final Vaga other = (Vaga) obj;
        if (!Objects.equals(this.codVaga, other.codVaga)) {
            return false;
        }
        return true;
    }
    
    
    
}
