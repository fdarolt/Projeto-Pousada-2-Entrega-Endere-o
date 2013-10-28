
package br.com.fabianodarolt.pousada.Model.Persistencia.DAO;


import br.com.fabianodarolt.pousada.Model.Funcionario;
import java.util.List;

public interface FuncionarioDAO {
    
    int salvar (Funcionario f);
    int editar (Funcionario f);
    boolean remove (int id);
    List<Funcionario> listAll();    
    Funcionario listById (int codigo);
    List<Funcionario> listByNome (String nome);
    
    
}
