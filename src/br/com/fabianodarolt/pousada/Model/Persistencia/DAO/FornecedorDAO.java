
package br.com.fabianodarolt.pousada.Model.Persistencia.DAO;


import br.com.fabianodarolt.pousada.Model.Fornecedor;
import java.util.List;

public interface FornecedorDAO {
    
    int salvar (Fornecedor fo);
    int update (Fornecedor fo);
    boolean remove (int id);
    List<Fornecedor> listAll();    
    Fornecedor listById (int codigo);
    List<Fornecedor> listByNome (String nome);
    
    
}
