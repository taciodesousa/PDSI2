package Conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConexaoBD {

    public ResultSet rs;
    String url = "jdbc:mysql://localhost:3306/gerenciamento";
    String usuario = "root";
    String senha = "root";
    public Connection con = null;

    public void Conexao() throws ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "aqui ao mysql\n" + ex);
        }
    }

    public void Desconecta() {
        try {
            this.con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet executaSql(String sql) {
        try {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);

            return rs;

        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public static Connection getConnection() {
        String db_url = "jdbc:mysql://localhost/gerenciamento";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection(db_url, "root", "root");

        } catch (ClassNotFoundException ex) {
            System.out.println("Driver mysql nao encontrado");
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar conectar ao mysql");
        }
        return con;
    }

}
