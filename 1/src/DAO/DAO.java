/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexao.ConexaoBD;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author nupasd-ufpi
 */
public class DAO {

    PreparedStatement st;
    ResultSet rs;
    Connection con = ConexaoBD.getConnection();

    public boolean LiberarMaquina(String nome_aluno, String maquina) {
        try {
            String insere = "insert into em_uso (nome_aluno, maquina, hora_entrada) values (?, ?, ?)";
            String insert = "insert into em_uso values ('" + nome_aluno + "','" + maquina + "');";
            PreparedStatement stmt = con.prepareStatement(insere);
            stmt.setString(1, nome_aluno);
            stmt.setString(2, maquina);
            
            stmt.setString(3, Double.toString(System.currentTimeMillis()));

            stmt.execute();
        } catch (SQLException e) {
            System.out.println("Erro no salvamento das informações");
        }

        return false;
    }
}
