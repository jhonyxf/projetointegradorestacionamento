package aplicacao;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import dominio.Cliente;
import dominio.Funcionario;
import dominio.Locacao;
import dominio.TipoLocacao;
import dominio.Vaga;
import dominio.Veiculo;

public class Principal{
	
	public static void main(String[] args) throws ParseException{
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("meujpa");
		EntityManager em = emf.createEntityManager();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	Date d = sdf.parse("15/08/2015");
    	Date e = sdf.parse("25/09/2015");

        Funcionario f1 = new Funcionario(null, "Pedro", "Porteiro");
               
        Cliente c1 = new Cliente(null,"João","3225448");
        Cliente c2 = new Cliente(null, "Maria", "96685421");
	    Cliente c3 = new Cliente(null, "José", "87787451");
		
		
        
        Veiculo v1 = new Veiculo(null,"NGK9246",c1);
        Veiculo v2 = new Veiculo(null,"UTC1234",c2);
        Veiculo v3 = new Veiculo(null,"MMM6666",c3);
        Veiculo v4 = new Veiculo(null,"TNT4444",c1);
        
        TipoLocacao tipo1 = new TipoLocacao(null, "Horista", new BigDecimal(5.00));
        TipoLocacao tipo3 = new TipoLocacao(null, "Mensal", new BigDecimal(2.00));
              
          
        Vaga vg1 = new Vaga(null, 1, true);
        Vaga vg2 = new Vaga(null, 2, true);
        Vaga vg3 = new Vaga(null, 3, false);
        
       
       Locacao loc1 = new Locacao(null,d,f1,v4,vg2,c1,tipo1);
       Locacao loc2 = new Locacao(null,e,f1,v3,vg1,c3,tipo3);
       
       loc1.consultarValorPagar();
       em.getTransaction().begin();
       
       em.persist(f1);
       em.persist(c1);
       em.persist(c2);
       em.persist(c3);
       em.persist(v1);
       em.persist(v2);
       em.persist(v3);
       em.persist(v4);
       em.persist(tipo1);
       em.persist(tipo3);
       em.persist(vg1);
       em.persist(vg2);
       em.persist(vg3);
       em.persist(loc1);
       em.persist(loc2);
       
       em.getTransaction().commit();
       em.close();
       emf.close();
        
       
		
		
	}

}
