package br.com.fabianodarolt.pousada.Model.Persistencia;


import br.com.fabianodarolt.pousada.Model.Fornecedor;
import br.com.fabianodarolt.pousada.Model.Persistencia.DAO.FornecedorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FornecedorDAOImplements implements FornecedorDAO {

//    private static final String INSERT = "insert into fornecedor (nome,login,senha,cpf,telefone,"
//            + "datanascimento,sexo) values (?,?,?,?,?,?,?);";
//    private static final String LIST = "select * from fornecedor;";
//    private static final String REMOVE = "delete from fornecedor where id = ?;";
//    private static final String UPDATE = "update fornecedor set "
//            + "nome = ?,login = ?, senha = ?, "
//            + "cpf = ?, telefone = ?, datanascimento = ?,"
//            + "sexo = ? where id = ?;";
//    private static final String LISTBYID = "select * from fornecedor where id = ?;";
//    private static final String LISTBYNOME = "select * from fornecedor where nome like ?;";
//
//    @Override
//    public int salvar(Fornecedor fo) {
//        if (fo.getId() == 0) {
//            return insert(fo);
//        } else {
//            return update(fo);
//        }
//    }
//
//    private int insert(Fornecedor fo) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        int retorno = -1;
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
//            pstm.setString(1, fo.getNome());
//            pstm.setString(2, fo.getLogin());
//            pstm.setString(3, fo.getSenha());
//            pstm.setString(4, fo.getCpf());
//            pstm.setString(5, fo.getTelefone());
//            pstm.setDate(6, new java.sql.Date(fo.getDataNascimento().getTime()));
//            pstm.setString(7, fo.getSexo());
//            pstm.execute();
//
//            try (ResultSet rs = pstm.getGeneratedKeys()) {
//                if (rs.next()) {
//                    retorno = rs.getInt(1);
//                }
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao Inserir" + e);
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(con, pstm);
//            } catch (SQLException ex) {
//            }
//            return retorno;
//        }
//    }
//
//    @Override
//    public boolean remove(int codigo) {
//        boolean status = false;
//        Connection con = null;
//        PreparedStatement pstm = null;
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(REMOVE);
//            pstm.setInt(1, codigo);
//            pstm.execute();
//            status = true;
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao Excluir o Usuário" + e.getMessage());
//
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(con, pstm);
//            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão" + ex);
//            }
//        }
//        return status;
//    }
//
//    @Override
//    public List<Fornecedor> listAll() {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        List<Fornecedor> usuarios = new ArrayList<>();
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(LIST);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                Fornecedor fo = new Fornecedor();
//                fo.setCodigo(rs.getInt("id"));
//                fo.setNome(rs.getString("nome"));
//                fo.setLogin(rs.getString("login"));
//                fo.setSenha(rs.getString("senha"));
//                fo.setCpf(rs.getString("cpf"));
//                fo.setTelefone(rs.getString("telefone"));
//                fo.setDataNascimento(rs.getDate("dataNascimento"));
//                fo.setSexo(rs.getString("sexo"));
//                usuarios.add(fo);
//
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao Listar as Pessoas" + e.getMessage());
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(con, pstm, rs);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao Fechar a conexão" + e.getMessage());
//            }
//        }
//        return usuarios;
//    }
//
//    @Override
//    public Fornecedor listById(int codigo) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        Fornecedor fo = new Fornecedor();
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(LISTBYID);
//            pstm.setInt(1, codigo);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                fo.setCodigo(rs.getInt("id"));
//                fo.setNome(rs.getString("nome"));
//                fo.setLogin(rs.getString("login"));
//                fo.setSenha(rs.getString("senha"));
//                fo.setCpf(rs.getString("cpf"));
//                fo.setTelefone(rs.getString("telefone"));
//                fo.setDataNascimento(rs.getDate("dataNascimento"));
//                fo.setSexo(rs.getString("sexo"));
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao Listar Usuário" + e.getMessage());
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(con, pstm, rs);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao fechar Conexão" + e.getMessage());
//            }
//        }
//        return fo;
//    }
//
//    @Override
//    public int editar(Fornecedor fo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public int inserir(Fornecedor fo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private int update(Fornecedor fo) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        int retorno = -1;
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(UPDATE);
//            pstm.setString(1, fo.getNome());
//            pstm.setString(2, fo.getLogin());
//            pstm.setString(3, fo.getSenha());
//            pstm.setString(4, fo.getCpf());
//            pstm.setString(5, fo.getTelefone());
//            pstm.setDate(6, new java.sql.Date(fo.getDataNascimento().getTime()));
//            pstm.setString(7, fo.getSexo());
//            pstm.setInt(8, fo.getCodigo());
//            pstm.execute();
//            retorno = fo.getCodigo();
//
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erro ao Editar" + e);
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(con, pstm);
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão" + e.getMessage());
//            }
//        }
//        return retorno;
//    }
//
//    @Override
//    public List<Fornecedor> listByNome(String nome) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        List<Fornecedor> usuarios = new ArrayList<>();
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(LISTBYNOME);
//            pstm.setString(1,   nome + "%");
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                Fornecedor fo = new Fornecedor();
//                fo.setCodigo(rs.getInt("id"));
//                fo.setNome(rs.getString("nome"));
//                fo.setLogin(rs.getString("login"));
//                fo.setSenha(rs.getString("senha"));
//                fo.setCpf(rs.getString("cpf"));
//                fo.setTelefone(rs.getString("telefone"));
//                fo.setDataNascimento(rs.getDate("dataNascimento"));
//                fo.setSexo(rs.getString("sexo"));
//                usuarios.add(fo);
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Erroa ao Pesquisar Usuário" + e.getMessage());
//
//        } finally {
//            try {
//                ConnectionFactory.closeConnection(con, pstm, rs);
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão" + e.getMessage());
//            }
//        }
//        return usuarios;
//    }
}
