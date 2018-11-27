
package SI;

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
public class Excluir_SI  extends JFrame{
    
    ConexaoBD connection = new ConexaoBD();
    
    JPanel jPanel3 = new JPanel();
    JPanel jPanel6 = new JPanel();
      
    JLabel buscar = new JLabel("Informe a matrícula do Aluno: ");
    JTextField buscar1 = new JTextField();
    
    JButton bus = new JButton("Buscar");

    JButton exc = new JButton("Excluir");
    
    JButton cancelar = new JButton("Cancelar");
    
    JTable list = new JTable();
    JScrollPane scroll = new JScrollPane(list);
    
   
    public Excluir_SI(){
     
        setLayout(null);
        setTitle("Alterrar Usuário");
        setSize(800, 500);
        setVisible(true); 
        setLocationRelativeTo(null); 
        setResizable(false); 
             
        jPanel3.setLayout(null);
        jPanel3.setBorder(BorderFactory.createTitledBorder(null, "Excluir", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel3.setForeground(Color.BLACK);
        jPanel3.setBounds(5, 2, 780, 300); 
       
         
        jPanel6.setLayout(null);
        jPanel6.setBorder(BorderFactory.createTitledBorder(null,"", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Tahoma", Font.BOLD, 14)));
        jPanel6.setForeground(Color.BLACK);       
        jPanel6.setBounds(5, 320, 780, 130);    
        
        buscar.setBounds(50,40,200,30);
        buscar1.setBounds(240,40,130,30);
        bus.setBounds(390,40,105,30);
        exc.setBounds(280,35,110,40);
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
       new ConfirmarExcluirSI(buscar1.getText());
       new Excluir_SI().setVisible(false);
       dispose();
    }
    
    public void CancelarActionPerformed(ActionEvent evt){
     
            dispose();
    }
    
    
     public void BuscarActionPerformed(ActionEvent evt){
         
        try {
            TabelaSI("select Nome, Sexo, DataNascimento, RG, CPF, Curso from alunos where Matricula='"+buscar1.getText()+"' order by Cod_Aluno");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Excluir_SI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void TabelaSI(String sql) throws ClassNotFoundException{
        
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
             exc.setEnabled(true);
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Matrícula não existe !!");
            exc.setEnabled(false);
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

    

    