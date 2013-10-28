
package br.com.fabianodarolt.pousada.Model.Persistencia.DAO;

import br.com.fabianodarolt.pousada.Model.Endereco;


public interface EnderecoDAO {
    
    int salvar (Endereco e);
 
    boolean remove (int id);

    
}
