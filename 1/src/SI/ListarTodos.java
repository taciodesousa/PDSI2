/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

/**
 *
 * @author Tiago Mendes
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Conexao.ConexaoBD;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

public class ListarTodos extends JFrame {

    JPanel jPanel1 = new JPanel();
    JPanel jPanel2 = new JPanel();
    ConexaoBD connection = new ConexaoBD();

    JButton buscar1 = new JButton("Clique para Listar");

    JButton OK = new JButton("Sair");

    JTable list = new JTable();
    JScrollPane scroll = new JScrollPane(list);

    public ListarTodos() {

        jPanel1.setLayout(null);
        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Listar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel1.setForeground(Color.BLACK);
        jPanel1.setBounds(5, 2, 780, 300);

        buscar1.setBounds(300, 40, 170, 40);
        scroll.setBounds(23, 150, 720, 120);

        jPanel1.add(scroll);

        jPanel1.add(buscar1);

        add(jPanel1);

        jPanel2.setLayout(null);
        jPanel2.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel2.setForeground(Color.BLACK);
        jPanel2.setBounds(5, 320, 780, 130);

        OK.setBounds(330, 35, 110, 40);

        jPanel2.add(OK);

        add(jPanel2);

        OK.setIcon(new ImageIcon(getClass().getResource("/icones/door_in.png")));
        buscar1.setIcon(new ImageIcon(getClass().getResource("/icones/list.png")));

        buscar1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarActionPerformed(e);
            }
            
        });

        OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OKActionPerformed(e);
            }

        });
        
        setLayout(null);
        setTitle("Listar Alunos");
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);


    }

    public void BuscarActionPerformed(ActionEvent evt) {
        TabelaSI("select * from alunos order by Nome");
        buscar1.setEnabled(false);

    }

    public void OKActionPerformed(ActionEvent evt) {
        dispose();

    }

    public void TabelaSI(String sql) {

        ArrayList dados = new ArrayList<>();

         String[] colunas = new String[]{"Nome", "Sexo", "DN", "RG",
            "CPF", "Curso"};

        try {
            connection.Conexao();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ListarTodos.class.getName()).log(Level.SEVERE, null, ex);
        }

        connection.executaSql(sql);

        try {

            connection.rs.first();

            do {
                dados.add(new Object[]{
                    connection.rs.getString("Nome"),
                    connection.rs.getString("Sexo"),
                    connection.rs.getString("DataNascimento"),
                    connection.rs.getString("RG"),
                    connection.rs.getString("CPF"),                    
                    connection.rs.getString("Curso")});
            } while (connection.rs.next());

        } catch (SQLException ex) {

        }

        TabelaSI modelo = new TabelaSI(dados, colunas);

        list.setModel(modelo);
       list.getColumnModel().getColumn(0).setPreferredWidth(225);
        list.getColumnModel().getColumn(0).setResizable(false);

        list.getColumnModel().getColumn(1).setPreferredWidth(85);
        list.getColumnModel().getColumn(1).setResizable(false);

        list.getColumnModel().getColumn(2).setPreferredWidth(85);
        list.getColumnModel().getColumn(2).setResizable(false);

        list.getColumnModel().getColumn(3).setPreferredWidth(75);
        list.getColumnModel().getColumn(3).setResizable(false);
        
        list.getColumnModel().getColumn(4).setPreferredWidth(105);
        list.getColumnModel().getColumn(4).setResizable(false);

        list.getColumnModel().getColumn(5).setPreferredWidth(140);
        list.getColumnModel().getColumn(5).setResizable(false);    
  
        list.getTableHeader().setReorderingAllowed(false);
        list.setAutoResizeMode(list.AUTO_RESIZE_OFF);

        connection.Desconecta();

    }
}
