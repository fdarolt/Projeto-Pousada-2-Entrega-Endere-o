package br.com.fabianodarolt.pousada.Model.Persistencia;

import br.com.fabianodarolt.pousada.Model.Endereco;
import br.com.fabianodarolt.pousada.Model.Funcionario;
import br.com.fabianodarolt.pousada.Model.Persistencia.DAO.FuncionarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class FuncionarioDAOImplements implements FuncionarioDAO {

    private static final String INSERT = "insert into funcionario (nome, sexo, datanascimento, rg, "
            + "cpf,endereco_id, telefoneresidencial, telefonecelular, \n"
            + "email, salario, dataadmissao,funcao,login,senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String LIST = "select * from funcionario, endereco where  funcionario.endereco_id = endereco.id;";
    private static final String REMOVE = "delete from funcionario where id = ?;";
    private static final String UPDATE = "update funcionario set nome =?,sexo=?,"
            + "datanascimento=?,rg=?,cpf=?,endereco_id= ?, telefoneresidencial=?,telefonecelular=?,email=?,salario=?,dataadmissao=?,"
            + "funcao=?,login=?,senha=? where id = ?;";
    private static final String LISTBYID = "select * from funcionario, endereco where funcionario.endereco_id = endereco.id  and funcionario.id = ?;";
    private static final String LISTBYNOME = "select * from funcionario where nome like ?;";
    private static final String AUTENTICA = "select login,senha from funcionario;";

    @Override
    public int salvar(Funcionario f) {
        if (f.getId() == 0) {
            return insert(f);
        } else {
            return update(f);
        }
    }

    private int insert(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getSexo());
            pstm.setDate(3, new java.sql.Date(f.getDataNascimento().getTime()));
            pstm.setString(4, f.getRg());
            pstm.setString(5, f.getCpf());
            pstm.setInt(6, f.getEndereco().getIdEndereco());
            pstm.setString(7, f.getTelefoneResindecial());
            pstm.setString(8, f.getTelefoneCelular());
            pstm.setString(9, f.getEmail());
            pstm.setString(10, f.getSalario());
            pstm.setDate(11, new java.sql.Date(f.getDataAdmissao().getTime()));
            pstm.setString(12, f.getFuncao());
            pstm.setString(13, f.getLogin());
            pstm.setString(14, f.getSenha());
            pstm.execute();

            try (ResultSet rs = pstm.getGeneratedKeys()) {
                if (rs.next()) {
                    retorno = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (SQLException ex) {
            }
            return retorno;
        }
    }

    @Override
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

    @Override
    public List<Funcionario> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        List<Endereco> endereco = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();

                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setSexo(rs.getString("sexo"));
                f.setDataNascimento(rs.getDate("datanascimento"));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));

                //***********************************************************************************************

                Endereco en = new Endereco();

                en.setRua(rs.getString("endereco.rua"));
                en.setNumero(Integer.parseInt(rs.getString("endereco.numero")));
                en.setComplemento(rs.getString("endereco.complemento"));
                en.setBairro(rs.getString("endereco.bairro"));
                en.setCidade(rs.getString("endereco.cidade"));
                en.setEstado(rs.getString("endereco.estado"));
                en.setPais(rs.getString("endereco.pais"));
                en.setCep(rs.getString("endereco.cep"));

                f.setEndereco(en);

                //********************************************************************************************  

                f.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                f.setTelefoneCelular(rs.getString("telefonecelular"));
                f.setEmail(rs.getString("email"));
                f.setSalario(rs.getString("salario"));
                f.setDataAdmissao(rs.getDate("dataadmissao"));
                f.setFuncao(rs.getString("funcao"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Funcionário " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Fechar a conexão " + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public Funcionario listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Funcionario f = new Funcionario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setSexo(rs.getString("sexo"));
                f.setDataNascimento(rs.getDate("datanascimento"));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));

                //***********************************************************************************************

                Endereco en = new Endereco();

                en.setRua(rs.getString("endereco.rua"));
                en.setNumero(Integer.parseInt(rs.getString("endereco.numero")));
                en.setComplemento(rs.getString("endereco.complemento"));
                en.setBairro(rs.getString("endereco.bairro"));
                en.setCidade(rs.getString("endereco.cidade"));
                en.setEstado(rs.getString("endereco.estado"));
                en.setPais(rs.getString("endereco.pais"));
                en.setCep(rs.getString("endereco.cep"));
                en.setIdEndereco(rs.getInt("endereco.id"));

                f.setEndereco(en);

                //********************************************************************************************  

                f.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                f.setTelefoneCelular(rs.getString("telefonecelular"));
                f.setEmail(rs.getString("email"));
                f.setSalario(rs.getString("salario"));
                f.setDataAdmissao(rs.getDate("dataadmissao"));
                f.setFuncao(rs.getString("funcao"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Listar Funcionário " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar Conexão " + e.getMessage());
            }
        }
        return f;
    }

    private int update(Funcionario f) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, f.getNome());
            pstm.setString(2, f.getSexo());
            pstm.setDate(3, new java.sql.Date(f.getDataNascimento().getTime()));
            pstm.setString(4, f.getRg());
            pstm.setString(5, f.getCpf());
            pstm.setString(6, f.getTelefoneResindecial());
            pstm.setInt(7, f.getEndereco().getIdEndereco());
            pstm.setString(8, f.getTelefoneCelular());
            pstm.setString(9, f.getEmail());
            pstm.setString(10, f.getSalario());
            pstm.setDate(11, new java.sql.Date(f.getDataAdmissao().getTime()));
            pstm.setString(12, f.getFuncao());
            pstm.setString(13, f.getLogin());
            pstm.setString(14, f.getSenha());
            pstm.setInt(15, f.getId());
            pstm.execute();
            retorno = f.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Funcionário " + e);
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão " + e.getMessage());
            }
        }
        return retorno;
    }

    @Override
    public List<Funcionario> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setSexo(rs.getString("sexo"));
                f.setDataNascimento(rs.getDate("datanascimento"));
                f.setRg(rs.getString("rg"));
                f.setCpf(rs.getString("cpf"));

                //***********************************************************************************************

                Endereco en = new Endereco();

                en.setRua(rs.getString("endereco.rua"));
                en.setNumero(Integer.parseInt(rs.getString("endereco.numero")));
                en.setComplemento(rs.getString("endereco.complemento"));
                en.setBairro(rs.getString("endereco.bairro"));
                en.setCidade(rs.getString("endereco.cidade"));
                en.setEstado(rs.getString("endereco.estado"));
                en.setPais(rs.getString("endereco.pais"));
                en.setCep(rs.getString("endereco.cep"));

                f.setEndereco(en);

                //********************************************************************************************  

                f.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                f.setTelefoneCelular(rs.getString("telefonecelular"));
                f.setEmail(rs.getString("email"));
                f.setSalario(rs.getString("salario"));
                f.setDataAdmissao(rs.getDate("dataadmissao"));
                f.setFuncao(rs.getString("funcao"));
                f.setLogin(rs.getString("login"));
                f.setSenha(rs.getString("senha"));
                funcionarios.add(f);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Pesquisar Funcionário " + e.getMessage());

        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao Fechar a Conexão " + e.getMessage());
            }
        }
        return funcionarios;
    }

    @Override
    public int editar(Funcionario f) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean autenticador(String txLogin, String txSenha) {
        boolean autentica = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(AUTENTICA);
            rs = pstm.executeQuery();
            while (rs.next()) {
                if (rs.getString("login").equals(txLogin) && rs.getString("senha").equals(txSenha)) {
                    autentica = true;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao autenticar: " + e.getMessage());
        } finally {
            try {
                ConnectionFactory.closeConnection(con, pstm, rs);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
            }
        }
        return autentica;
    }
}