package br.com.fabianodarolt.pousada.Controller;


import br.com.fabianodarolt.pousada.Model.Fornecedor;
import br.com.fabianodarolt.pousada.Model.Persistencia.DAO.FornecedorDAO;
import br.com.fabianodarolt.pousada.Model.Persistencia.FornecedorDAOImplements;
import java.util.List;

public class FornecedorController {

    public int salvar(Fornecedor fo) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.salvar(fo);
    }

    public List< Fornecedor> listarTodos() {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.listAll();
    }
     public List<Fornecedor> listByNome(String nome) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.listByNome(nome);
    }

    public boolean remove(int id) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.remove(id);
    }

    public Fornecedor listById(int codigo) {
        FornecedorDAO dao = new FornecedorDAOImplements();
        return dao.listById(codigo);
    }   
}
