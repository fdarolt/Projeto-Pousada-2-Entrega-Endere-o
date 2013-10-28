package br.com.fabianodarolt.pousada.Model.Persistencia;


import br.com.fabianodarolt.pousada.Model.Endereco;
import br.com.fabianodarolt.pousada.Model.Cliente;
import br.com.fabianodarolt.pousada.Model.Persistencia.DAO.ClienteDAO;
import br.com.fabianodarolt.pousada.Model.ServicoGeral;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDAOImplements implements ClienteDAO {
    
     private static final String INSERT = "insert into cliente (nome, sexo, datanascimento, rg, "
            + "cpf,endereco_id, telefoneresidencial, telefonecelular, \n"
            + "email, salario, dataadmissao,funcao,login,senha) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
    private static final String LIST = "select * from cliente, endereco where  cliente.endereco_id = endereco.id;";
    private static final String REMOVE = "delete from cliente where id = ?;";
    private static final String UPDATE = "update cliente set nome =?,sexo=?,"
            + "datanascimento=?,rg=?,cpf=?,endereco_id= ?, telefoneresidencial=?,telefonecelular=?,email=?,salario=?,dataadmissao=?,"
            + "funcao=?,login=?,senha=? where id = ?;";
    private static final String LISTBYID = "select * from cliente, endereco where cliente.endereco_id = endereco.id  and cliente.id = ?;";
    private static final String LISTBYNOME = "select * from cliente where nome like ?;";
    

        public int salvar(Cliente c) {
        if (c.getId() == 0) {
            return insert(c);
        } else {
            return update(c);
        }
    }

    private int insert(Cliente c) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getSexo());
            pstm.setDate(3, new java.sql.Date(c.getDataNascimento().getTime()));
            pstm.setString(4, c.getRg());
            pstm.setString(5, c.getCpf());
            pstm.setString(6, c.getPassaporte());
            pstm.setString(7, c.getCartaoCredito());
            pstm.setString(8, c.getProcedenciaCliente());
            pstm.setString(9, c.getDestinoCliente());
            pstm.setInt(10, c.getEndereco().getIdEndereco());
            pstm.setString(11, c.getTelefoneResindecial());
            pstm.setString(12, c.getTelefoneCelular());
            pstm.setString(13, c.getTelefoneEmpresaCliente());
            pstm.setString(14, c.getEmail());
            pstm.setInt(15, c.getServicoGeral().getIdServicoGeral());            
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
        public List<Cliente> listAll() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> funcionarios = new ArrayList<>();
        List<Endereco> endereco = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LIST);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();

                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setDataNascimento(rs.getDate("datanascimento"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setPassaporte("passaporte");
                c.setCartaoCredito("cartaocredito");
                c.setProcedenciaCliente("procedencia");
                c.setDestinoCliente("destino");
                

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

                c.setEndereco(en);

                //********************************************************************************************  

                c.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                c.setTelefoneCelular(rs.getString("telefonecelular"));
                c.setTelefoneEmpresaCliente("telefoneempresa");
                c.setEmail(rs.getString("email"));
                
                //***********************************************************************************************
                
                ServicoGeral sg = new ServicoGeral();
                
                sg.setIdServicoGeral(rs.getInt("servicogeral.id"));
                sg.setNomenclatura(rs.getString("servicogeral.nomenclatura"));
                sg.setDescricao(rs.getString("servicogeral.descricao"));
                sg.setQuantidadeServico(rs.getInt("servicogeral.quantidade"));
                sg.setValorInicialServico(rs.getDouble("servicogeral.valorincial"));
                sg.setMargemLucroValorServico(rs.getDouble("servicogeralmargemlucro"));
                sg.setValorFinalServico(rs.getDouble("servicogeral.valorfinal"));
                
                c.setServicoGeral(sg);

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
        public Cliente listById(int codigo) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Cliente c = new Cliente();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYID);
            pstm.setInt(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setDataNascimento(rs.getDate("datanascimento"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setPassaporte("passaporte");
                c.setCartaoCredito("cartaocredito");
                c.setProcedenciaCliente("procedencia");
                c.setDestinoCliente("destino");
                

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

                c.setEndereco(en);

                //********************************************************************************************  

                c.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                c.setTelefoneCelular(rs.getString("telefonecelular"));
                c.setTelefoneEmpresaCliente("telefoneempresa");
                c.setEmail(rs.getString("email"));
                
                //***********************************************************************************************
                
                ServicoGeral sg = new ServicoGeral();
                
                sg.setIdServicoGeral(rs.getInt("servicogeral.id"));
                sg.setNomenclatura(rs.getString("servicogeral.nomenclatura"));
                sg.setDescricao(rs.getString("servicogeral.descricao"));
                sg.setQuantidadeServico(rs.getInt("servicogeral.quantidade"));
                sg.setValorInicialServico(rs.getDouble("servicogeral.valorincial"));
                sg.setMargemLucroValorServico(rs.getDouble("servicogeralmargemlucro"));
                sg.setValorFinalServico(rs.getDouble("servicogeral.valorfinal"));
                
                c.setServicoGeral(sg);

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
        return c;
    }

    public int update(Cliente c) {
        Connection con = null;
        PreparedStatement pstm = null;
        int retorno = -1;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(UPDATE);
            pstm.setString(1, c.getNome());
            pstm.setString(2, c.getSexo());
            pstm.setDate(3, new java.sql.Date(c.getDataNascimento().getTime()));
            pstm.setString(4, c.getRg());
            pstm.setString(5, c.getCpf());
            pstm.setString(6, c.getPassaporte());
            pstm.setString(7, c.getCartaoCredito());
            pstm.setString(8, c.getProcedenciaCliente());
            pstm.setString(9, c.getDestinoCliente());
            pstm.setInt(10, c.getEndereco().getIdEndereco());
            pstm.setString(11, c.getTelefoneResindecial());
            pstm.setString(12, c.getTelefoneCelular());
            pstm.setString(13, c.getTelefoneEmpresaCliente());
            pstm.setString(14, c.getEmail());
            pstm.setInt(15, c.getServicoGeral().getIdServicoGeral()); 
            pstm.execute();
            retorno = c.getId();

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
        public List<Cliente> listByNome(String nome) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<Cliente> funcionarios = new ArrayList<>();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(LISTBYNOME);
            pstm.setString(1, nome + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setSexo(rs.getString("sexo"));
                c.setDataNascimento(rs.getDate("datanascimento"));
                c.setRg(rs.getString("rg"));
                c.setCpf(rs.getString("cpf"));
                c.setPassaporte("passaporte");
                c.setCartaoCredito("cartaocredito");
                c.setProcedenciaCliente("procedencia");
                c.setDestinoCliente("destino");
                

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

                c.setEndereco(en);

                //********************************************************************************************  

                c.setTelefoneResindecial(rs.getString("telefoneresidencial"));
                c.setTelefoneCelular(rs.getString("telefonecelular"));
                c.setTelefoneEmpresaCliente("telefoneempresa");
                c.setEmail(rs.getString("email"));
                
                //***********************************************************************************************
                
                ServicoGeral sg = new ServicoGeral();
                
                sg.setIdServicoGeral(rs.getInt("servicogeral.id"));
                sg.setNomenclatura(rs.getString("servicogeral.nomenclatura"));
                sg.setDescricao(rs.getString("servicogeral.descricao"));
                sg.setQuantidadeServico(rs.getInt("servicogeral.quantidade"));
                sg.setValorInicialServico(rs.getDouble("servicogeral.valorincial"));
                sg.setMargemLucroValorServico(rs.getDouble("servicogeralmargemlucro"));
                sg.setValorFinalServico(rs.getDouble("servicogeral.valorfinal"));
                
                c.setServicoGeral(sg);
              
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
}
