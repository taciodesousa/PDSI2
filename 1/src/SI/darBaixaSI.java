/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import Conexao.ConexaoBD;
import Conexao.Users;
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

public class darBaixaSI  extends JFrame{
    
    ConexaoBD connection = new ConexaoBD();
    Users DAO = new Users();
    
    JPanel jPanel3 = new JPanel();
    JPanel jPanel6 = new JPanel();
      
    JLabel buscar = new JLabel("Informe a matrícula do Aluno: ");
    JTextField buscar1 = new JTextField();
    
    JButton bus = new JButton("Buscar");

    JButton exc = new JButton("Liberar");
    
    JButton cancelar = new JButton("Cancelar");
    
    JTable list = new JTable();
    JScrollPane scroll = new JScrollPane(list);
    
   
    public darBaixaSI(){
     
        setLayout(null);
        setTitle("Liberar Uso");
        setSize(800, 500);
        setVisible(true); 
        setLocationRelativeTo(null); 
        setResizable(false); 
             
        jPanel3.setLayout(null);
        jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Liberar", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel3.setForeground(Color.BLACK);
        jPanel3.setBounds(5, 2, 780, 300); 
       
         
        jPanel6.setLayout(null);
        jPanel6.setBorder(BorderFactory.createTitledBorder(null,"", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel6.setForeground(Color.BLACK);       
        jPanel6.setBounds(5, 320, 780, 130);    
        
        buscar.setBounds(50,40,200,30);
        buscar1.setBounds(240,40,130,30);
        bus.setBounds(390,40,105,30);
        exc.setBounds(280,35,130,40);
        cancelar.setBounds(430, 35, 110,40);
        scroll.setBounds(50, 150,720, 120);
        exc.setEnabled(false);
       
       
        jPanel3.add(scroll);
        jPanel3.add(bus);
       
        jPanel3.add(buscar);
        jPanel3.add(buscar1);
        
        jPanel6.add(cancelar);
        jPanel6.add(exc);         
        
        add(jPanel3);
        add(jPanel6);
        
        bus.setIcon(new ImageIcon(getClass().getResource("/icones/buscar.png")));
        exc.setIcon(new ImageIcon(getClass().getResource("/icones/delete.png")));
        cancelar.setIcon(new ImageIcon(getClass().getResource("/icones/cancel.png")));
        
        exc.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                EXCActionPerformed(e);
            }
            
        });
        
        bus.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                BuscarActionPerformed(e);
            }
            
        });
        
        
        cancelar.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelarActionPerformed(e);
            }
            
        });
    }
    
    public void EXCActionPerformed(ActionEvent evt){
       DAO.LiberarSI(buscar1.getText());
        dispose();
  
    }
    
    public void CancelarActionPerformed(ActionEvent evt){
     
            dispose();
         
    }
    
    
     public void BuscarActionPerformed(ActionEvent evt){
         
        try {
            TabelaSI("select nome_aluno, maquina, hora_entrada from em_uso where nome_aluno='"+buscar1.getText()+"'");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Excluir_SI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void TabelaSI(String sql) throws ClassNotFoundException{
        
        ArrayList dados = new ArrayList<>();
        
        
        String [] colunas = new String[]{ "nome_aluno", "maquina", "hora_entrada"};
        
        connection.Conexao();
        
        connection.executaSql(sql);
       
        try {
            
            connection.rs.first();
            
            do{
                dados.add(new Object[]{
                connection.rs.getInt("nome_aluno"), 
                connection.rs.getString("maquina"),
                  connection.rs.getString("hora_entrada"),
              });
            }while(connection.rs.next());
            
            JOptionPane.showMessageDialog(null, "Matrícula Encontrada!");
            exc.setEnabled(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Matrícula não existe !!");
            exc.setEnabled(false);
            
        }
        
              
        TabelaSI modelo = new TabelaSI(dados, colunas);
        
        list.setModel(modelo);
        
        
        list.getColumnModel().getColumn(0).setPreferredWidth(240); 
        list.getColumnModel().getColumn(0).setResizable(false);
        
        list.getColumnModel().getColumn(1).setPreferredWidth(240); 
        list.getColumnModel().getColumn(1).setResizable(false);
        
        list.getColumnModel().getColumn(2).setPreferredWidth(225); 
        list.getColumnModel().getColumn(2).setResizable(false);
        

        list.getTableHeader().setReorderingAllowed(false);
        list.setAutoResizeMode(list.AUTO_RESIZE_OFF); 
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        connection.Desconecta();
            
    }
    
    
     public static void main (String[] args){
        
       new darBaixaSI();
    }
   
}

    


    

