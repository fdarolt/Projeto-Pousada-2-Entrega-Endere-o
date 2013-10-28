package br.com.fabianodarolt.pousada.Model.Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionFactory {

    //String de Conexao do MySQL
    private static final String STR_CONEXAO = "jdbc:mysql://localhost:3306/";
    //Nomeda base de dados criada no MySQL
    private static final String DATABASE = "pousadabd";
    //Usuario do MySQL
    private static final String USER = "root";
    //Senha do MySQL
    private static final String PASSWORD = "1234";

    //Metodo que pega Conexao
    public static Connection getConnection() throws SQLException {

        try {
            return DriverManager.getConnection(STR_CONEXAO + DATABASE, USER, PASSWORD);
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    //Metodo que Fecha Conexao
    public static void closeConnection(Connection con) throws SQLException {
        if (con!= null){
            con.close();
        }
    }
    //Metodo que fecha o Statement
    public static void closeConnection(Connection con, Statement stmt) throws SQLException {
        if (stmt != null){
            stmt.close();
        }
        closeConnection(con);
    }
    public static void closeConnection (Connection con, Statement stmt, ResultSet rs) throws SQLException {
        if (rs!= null){
            rs.close();
        }
        closeConnection(con ,stmt);        
    }
}
