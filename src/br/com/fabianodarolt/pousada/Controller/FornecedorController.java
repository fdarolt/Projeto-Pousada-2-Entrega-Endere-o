package br.com.fabianodarolt.pousada.Controller;


import br.com.fabianodarolt.pousada.Model.Funcionario;
import br.com.fabianodarolt.pousada.Model.Persistencia.DAO.FuncionarioDAO;
import br.com.fabianodarolt.pousada.Model.Persistencia.FuncionarioDAOImplements;
import java.util.List;

public class FornecedorController {

    public int salvar(Funcionario f) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.salvar(f);
    }

    public List< Funcionario> listarTodos() {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listAll();
    }
     public List<Funcionario> listByNome(String nome) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listByNome(nome);
    }

    public boolean remove(int id) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.remove(id);
    }

    public Funcionario listById(int codigo) {
        FuncionarioDAO dao = new FuncionarioDAOImplements();
        return dao.listById(codigo);
    }   
}
