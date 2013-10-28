package br.com.fabianodarolt.pousada.Model.Persistencia;

import br.com.fabianodarolt.pousada.Model.Endereco;
import br.com.fabianodarolt.pousada.Model.Persistencia.DAO.EnderecoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class EnderecoDAOImplements implements EnderecoDAO {

    private static final String INSERT = "insert into endereco "
            + "(rua,numero,complemento,bairro,cidade,estado,pais,cep) values (?,?,?,?,?,?,?,?);";    
    private static final String REMOVE = "delete from endereco where id = ?;";
    private static final String UPDATE = "update endereco set rua =?, numero=?,"
            + "complemento=?,bairro=?, cidade=?, estado=?, pais=?, cep=? where id = ?;";

    private int inserir(Endereco e) {
        int status = -1;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, e.getRua());
            pstm.setInt(2, e.getNumero());
            pstm.setString(3, e.getComplemento());
            pstm.setString(4, e.getBairro());
            pstm.setString(5, e.getCidade());
            pstm.setString(6, e.getEstado());
            pstm.setString(7, e.getPais());
            pstm.setString(8, e.getCep());

            pstm.execute();
            try (ResultSet rs = pstm.getGeneratedKeys()) {
                rs.next();
                status = rs.getInt(1);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir um Endereço " + ex.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Fechar " + ex.getMessage());
            }
        }
        return status;
    }

    @Override
    public int salvar(Endereco e) {
        if (e.getIdEndereco() == 0) {
            return inserir(e);

        } else {
            return update(e);
        }
    }

    public boolean remove(int id) {
        boolean status = false;
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(REMOVE);
            pstm.setInt(1, id);
            pstm.execute();
            status = true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Excluir Funcionário " + e.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão " + ex);
            }
        }
        return status;
    }

    private int update(Endereco e) {

        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
       
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, e.getRua());
            pstm.setInt(2, e.getNumero());
            pstm.setString(3, e.getComplemento());
            pstm.setString(4, e.getBairro());
            pstm.setString(5, e.getCidade());
            pstm.setString(6, e.getEstado());
            pstm.setString(7, e.getPais());
            pstm.setString(8, e.getCep());
            pstm.setInt(9, e.getIdEndereco());
            pstm.execute();
            retorno = e.getIdEndereco();

        } catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Endereço " + ee);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception ee) {
                JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão " + ee.getMessage());
            }
        }
        return retorno;
    }
}
