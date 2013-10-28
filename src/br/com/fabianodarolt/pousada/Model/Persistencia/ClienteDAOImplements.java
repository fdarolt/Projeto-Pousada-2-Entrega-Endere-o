package br.com.fabianodarolt.pousada.Model.Persistencia;


import br.com.fabianodarolt.pousada.Model.Cliente;
import br.com.fabianodarolt.pousada.Model.Persistencia.DAO.ClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAOImplements implements ClienteDAO {

//    private static final String INSERT = "insert into cliente (nome,login,senha,cpf,telefone,"
//            + "datanascimento,sexo) values (?,?,?,?,?,?,?);";
//    private static final String LIST = "select * from cliente;";
//    private static final String REMOVE = "delete from cliente where id = ?;";
//    private static final String UPDATE = "update cliente set "
//            + "nome = ?,login = ?, senha = ?, "
//            + "cpf = ?, telefone = ?, datanascimento = ?,"
//            + "sexo = ? where id = ?;";
//    private static final String LISTBYID = "select * from cliente where id = ?;";
//    private static final String LISTBYNOME = "select * from cliente where nome like ?;";
//
//    @Override
//    public int salvar(Cliente c) {
//        if (c.getId() == 0) {
//            return insert(c);
//        } else {
//            return update(c);
//        }
//    }
//
//    private int insert(Cliente c) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        int retorno = -1;
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
//            pstm.setString(1, c.getNome());
//            pstm.setString(2, c.getLogin());
//            pstm.setString(3, c.getSenha());
//            pstm.setString(4, c.getCpf());
//            pstm.setString(5, c.getTelefone());
//            pstm.setDate(6, new java.sql.Date(c.getDataNascimento().getTime()));
//            pstm.setString(7, c.getSexo());
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
//    public List<Cliente> listAll() {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        List<Cliente> usuarios = new ArrayList<>();
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(LIST);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                Cliente c = new Cliente();
//                c.setCodigo(rs.getInt("id"));
//                c.setNome(rs.getString("nome"));
//                c.setLogin(rs.getString("login"));
//                c.setSenha(rs.getString("senha"));
//                c.setCpf(rs.getString("cpf"));
//                c.setTelefone(rs.getString("telefone"));
//                c.setDataNascimento(rs.getDate("dataNascimento"));
//                c.setSexo(rs.getString("sexo"));
//                usuarios.add(c);
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
//    public Cliente listById(int codigo) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        Cliente c = new Cliente();
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(LISTBYID);
//            pstm.setInt(1, codigo);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                c.setCodigo(rs.getInt("id"));
//                c.setNome(rs.getString("nome"));
//                c.setLogin(rs.getString("login"));
//                c.setSenha(rs.getString("senha"));
//                c.setCpf(rs.getString("cpf"));
//                c.setTelefone(rs.getString("telefone"));
//                c.setDataNascimento(rs.getDate("dataNascimento"));
//                c.setSexo(rs.getString("sexo"));
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
//        return c;
//    }
//
//    @Override
//    public int editar(Cliente c) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public int inserir(Cliente c) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    private int update(Cliente c) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        int retorno = -1;
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(UPDATE);
//            pstm.setString(1, c.getNome());
//            pstm.setString(2, c.getLogin());
//            pstm.setString(3, c.getSenha());
//            pstm.setString(4, c.getCpf());
//            pstm.setString(5, c.getTelefone());
//            pstm.setDate(6, new java.sql.Date(c.getDataNascimento().getTime()));
//            pstm.setString(7, c.getSexo());
//            pstm.setInt(8, c.getCodigo());
//            pstm.execute();
//            retorno = c.getCodigo();
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
//    public List<Cliente> listByNome(String nome) {
//        Connection con = null;
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//        List<Cliente> usuarios = new ArrayList<>();
//        try {
//            con = ConnectionFactory.getConnection();
//            pstm = con.prepareStatement(LISTBYNOME);
//            pstm.setString(1,   nome + "%");
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                Cliente c = new Cliente();
//                c.setCodigo(rs.getInt("id"));
//                c.setNome(rs.getString("nome"));
//                c.setLogin(rs.getString("login"));
//                c.setSenha(rs.getString("senha"));
//                c.setCpf(rs.getString("cpf"));
//                c.setTelefone(rs.getString("telefone"));
//                c.setDataNascimento(rs.getDate("dataNascimento"));
//                c.setSexo(rs.getString("sexo"));
//                usuarios.add(c);
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
