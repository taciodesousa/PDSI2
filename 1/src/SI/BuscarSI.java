/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import Conexao.ConexaoBD;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Tiago
 */

public class BuscarSI extends JFrame {

    ConexaoBD connection = new ConexaoBD();

    JPanel jPanel3 = new JPanel();
    JPanel jPanel6 = new JPanel();

    JLabel buscar = new JLabel("Informe a matrícula do Aluno: ");
    JTextField buscar1 = new JTextField();

    JButton bus = new JButton("Buscar");

    JButton exc = new JButton("Sair");

    JTable list = new JTable();
    JScrollPane scroll = new JScrollPane(list);

    public BuscarSI() {

        jPanel3.setLayout(null);
        jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Buscar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel3.setForeground(Color.BLACK);

        jPanel3.setBounds(5, 2, 780, 300);

        buscar.setBounds(50, 40, 200, 30);
        buscar1.setBounds(240, 40, 130, 30);
        bus.setBounds(390, 40, 105, 30);
        scroll.setBounds(50, 150, 720, 120);

        jPanel3.add(scroll);
        jPanel3.add(bus);

        jPanel3.add(buscar);
        jPanel3.add(buscar1);

        add(jPanel3);

        jPanel6.setLayout(null);
        jPanel6.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel6.setForeground(Color.BLACK);

        jPanel6.setBounds(5, 320, 780, 130);

        exc.setBounds(330, 35, 110, 40);
        jPanel6.add(exc);

        add(jPanel6);

        bus.setIcon(new ImageIcon(getClass().getResource("/icones/buscar.png")));
        exc.setIcon(new ImageIcon(getClass().getResource("/icones/Out.png")));

        exc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                exCActionPerformed(e);
            }

        });

        bus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarActionPerformed(e);
            }

        });
                
        setLayout(null);
        setTitle("Buscar Usuário");
        setSize(800, 500);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);

    }

    public void exCActionPerformed(ActionEvent evt) {
        dispose();
    }

    public void BuscarActionPerformed(ActionEvent evt) {

        if(buscar1.getText().isEmpty()){
        
         JOptionPane.showMessageDialog(null, "O campo Buscar deve ser preenchido !");
            buscar1.requestFocus();
        }else{
        
        try {
            TabelaSI("select Nome, Sexo, DataNascimento, RG, CPF, Curso from alunos where Matricula='" + buscar1.getText() + "' order by Nome");
        } catch (ClassNotFoundException ex) {
           
        }

    }
    }

    public void TabelaSI(String sql) throws ClassNotFoundException {

        ArrayList dados = new ArrayList<>();

        String[] colunas = new String[]{"Nome", "Sexo", "DN", "RG",
            "CPF", "Curso"};

        connection.Conexao();

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

            JOptionPane.showMessageDialog(null, "Matrícula Encontrada!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Matrícula não existe !!");

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
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
       
        connection.Desconecta();
    }
    
}
