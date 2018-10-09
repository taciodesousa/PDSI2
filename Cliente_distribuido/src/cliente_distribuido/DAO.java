/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente_distribuido;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nupasd-ufpi
 */
public class DAO {

    ConexaoBD connection = new ConexaoBD();

    public int verificaUsuario(String nomeUsuario, String senhaUsuario) throws ClassNotFoundException {
        
        connection.Conexao();
        String cmd = "select login, senha from login where login = '"+nomeUsuario+"' and Senha;";
             
        Statement stmt;
        ResultSet dados = null;
        
        String user = null, senha = null;
            
       
        
        try{
        stmt = connection.con.prepareStatement(cmd);

        dados = stmt.executeQuery(cmd);

        while (dados.next()) {
            user = (dados.getString("Login"));
            senha = (dados.getString("Senha"));
            System.out.println("Usuario: "+user+"     Senha: "+senha);
        }
        }catch(SQLException v){
            System.out.println("\n\nErro: "+v+" na verificação do Banco!\n\n");
        }

        
        return 0;
    }

}
