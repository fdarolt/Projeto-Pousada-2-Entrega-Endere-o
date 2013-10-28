package br.com.fabianodarolt.pousada.Model.Persistencia;

import br.com.fabianodarolt.pousada.Model.Endereco;
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

    private static final String INSERT = "insert into fornecedor (nome, sexo, datanascimento, cnpj, "
            + " descricao, pessoacontato, endereco_id, telefoneresidencial, telefonecelular, \n"
            + "email) values (?,?,?,?,?,?,?,?,?,?);";
    private static final String LIST = "select * from fornecedor, endereco where  "
            + "fornecedor.endereco_id = endereco.id;";
    private static final String REMOVE = "delete from fornecedor where id = ?;";
    private static final String UPDATE = "update fornecedor set nome =?, sexo=?, datanascimento=?, cnpj=?, "
            + "descricao=?, pessoacontato = ?, endereco_id= ?, telefoneresidencial=?, telefonecelular=?,"
            + "email=? where id = ?;";
    private static final String LISTBYID = "select * from fornecedor, endereco where "
            + "fornecedor.endereco_id = endereco.id and fornecedor.id = ?;";
    private static final String LISTBYNOME = "select * from fornecedor where nome like ?;";

   
    public int salvar(Fornecedor fo) {
        if (fo.getId() == 0) {
            return insert(fo);
        } else {
            return update(fo);
        }
    }

    private int insert(Fornecedor fo) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, fo.getNome());
            pstm.setString(2, fo.getSexo());
            pstm.setDate(3, new java.sql.Date(fo.getDataNascimento().getTime()));
            pstm.setString(4, fo.getCnpj());
            pstm.setString(5, fo.getDescricao());
            pstm.setString(6, fo.getPessoaContatoEmpresa());
            pstm.setInt(7, fo.getEndereco().getIdEndereco());
            pstm.setString(8, fo.getTelefoneResindecial());
            pstm.setString(9, fo.getTelefoneCelular());
            pstm.setString(10, fo.getEmail());

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
    public List<Fornecedor> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> funcionarios = new ArrayList<>();
        List<Endereco> endereco = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor fo = new Fornecedor();
                fo.setId(rs.getInt("id"));
                fo.setNome(rs.getString("nome"));
                fo.setSexo(rs.getString("sexo"));
                fo.setDataNascimento(rs.getDate("datanascimento"));
                fo.setCnpj(rs.getString("cnpj"));
                fo.setDescricao(rs.getString("descricao"));
                fo.setPessoaContatoEmpresa(rs.getString("pessoacontato"));

                //***********************************************************************************************

                Endereco en = new Endereco();

                en.setIdEndereco(rs.getInt("endereco.id"));
                en.setRua(rs.getString("endereco.rua"));
                en.setNumero(Integer.parseInt(rs.getString("endereco.numero")));
                en.setComplemento(rs.getString("endereco.complemento"));
                en.setBairro(rs.getString("endereco.bairro"));
                en.setCidade(rs.getString("endereco.cidade"));
                en.setEstado(rs.getString("endereco.estado"));
                en.setPais(rs.getString("endereco.pais"));
                en.setCep(rs.getString("endereco.cep"));

                fo.setEndereco(en);

                //********************************************************************************************  

                fo.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                fo.setTelefoneCelular(rs.getString("telefonecelular"));
                fo.setEmail(rs.getString("email"));
                funcionarios.add(fo);

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
    public Fornecedor listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Fornecedor fo = new Fornecedor();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                fo.setId(rs.getInt("id"));
                fo.setNome(rs.getString("nome"));
                fo.setSexo(rs.getString("sexo"));
                fo.setDataNascimento(rs.getDate("datanascimento"));
                fo.setCnpj(rs.getString("cnpj"));
                fo.setDescricao(rs.getString("descricao"));
                fo.setPessoaContatoEmpresa(rs.getString("pessoacontato"));

                //***********************************************************************************************

                Endereco en = new Endereco();

                en.setIdEndereco(rs.getInt("endereco.id"));
                en.setRua(rs.getString("endereco.rua"));
                en.setNumero(Integer.parseInt(rs.getString("endereco.numero")));
                en.setComplemento(rs.getString("endereco.complemento"));
                en.setBairro(rs.getString("endereco.bairro"));
                en.setCidade(rs.getString("endereco.cidade"));
                en.setEstado(rs.getString("endereco.estado"));
                en.setPais(rs.getString("endereco.pais"));
                en.setCep(rs.getString("endereco.cep"));

                fo.setEndereco(en);

                //********************************************************************************************  

                fo.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                fo.setTelefoneCelular(rs.getString("telefonecelular"));
                fo.setEmail(rs.getString("email"));

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
        return fo;
    }

    public int update(Fornecedor fo) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, fo.getNome());
            pstm.setString(2, fo.getSexo());
            pstm.setDate(3, new java.sql.Date(fo.getDataNascimento().getTime()));
            pstm.setString(4, fo.getCnpj());
            pstm.setString(5, fo.getDescricao());
            pstm.setString(6, fo.getPessoaContatoEmpresa());
            pstm.setInt(7, fo.getEndereco().getIdEndereco());
            pstm.setString(8, fo.getTelefoneResindecial());
            pstm.setString(9, fo.getTelefoneCelular());
            pstm.setString(10, fo.getEmail());
            pstm.setInt(11, fo.getId());
            pstm.execute();
            retorno = fo.getId();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Editar Funcionário " + e.getMessage());
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
    public List<Fornecedor> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Fornecedor> fornecedor = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Fornecedor fo = new Fornecedor();                
                fo.setId(rs.getInt("id"));
                fo.setNome(rs.getString("nome"));
                fo.setSexo(rs.getString("sexo"));
                fo.setDataNascimento(rs.getDate("datanascimento"));
                fo.setCnpj(rs.getString("cnpj"));
                fo.setDescricao(rs.getString("descricao"));
                fo.setPessoaContatoEmpresa(rs.getString("pessoacontato"));

                //***********************************************************************************************

                Endereco en = new Endereco();

                en.setIdEndereco(rs.getInt("endereco.id"));
                en.setRua(rs.getString("endereco.rua"));
                en.setNumero(Integer.parseInt(rs.getString("endereco.numero")));
                en.setComplemento(rs.getString("endereco.complemento"));
                en.setBairro(rs.getString("endereco.bairro"));
                en.setCidade(rs.getString("endereco.cidade"));
                en.setEstado(rs.getString("endereco.estado"));
                en.setPais(rs.getString("endereco.pais"));
                en.setCep(rs.getString("endereco.cep"));

                fo.setEndereco(en);

                //********************************************************************************************  

                fo.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                fo.setTelefoneCelular(rs.getString("telefonecelular"));
                fo.setEmail(rs.getString("email"));
                fornecedor.add(fo);
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
        return fornecedor;
    }         
}
