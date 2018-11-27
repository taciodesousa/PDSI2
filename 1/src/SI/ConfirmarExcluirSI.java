/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import Conexao.Users;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tiago
 */
public class ConfirmarExcluirSI extends JFrame{
    
    Users DAO = new Users();
    JPanel jPanel4 = new JPanel();
      
    JLabel info = new JLabel("Deseja realmente excluir as informações? ");
      
    JButton cadastra = new JButton("Excluir");
    JButton cancelar = new JButton("Cancelar");
    
    String mat;
            
    public ConfirmarExcluirSI(String Matricula){
       
        setLayout(null);
        setTitle("Tela de Confirmação de Remoção");
        setSize(500, 280);
        setVisible(true); 
        setLocationRelativeTo(null); 
        setResizable(false); 
                 
        this.mat = Matricula;
        
        jPanel4.setLayout(null);
   
        jPanel4.setBounds(0,0, 596, 250);
        
        
        info.setBounds(120,50,280,30);

        cadastra.setBounds(120,150,100,40);        
        cancelar.setBounds(260,150,120,40);
        
        jPanel4.add(info);
        jPanel4.add(cadastra);
        jPanel4.add(cancelar);
               
        add(jPanel4);
        
        
        cadastra.setIcon(new ImageIcon(getClass().getResource("/icones/disk.png")));
        cancelar.setIcon(new ImageIcon(getClass().getResource("/icones/cancel.png")));
        
        cadastra.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastrarActionPerformed(e);
            }
            
        });
        
        cancelar.addActionListener(new ActionListener (){
            @Override
            public void actionPerformed(ActionEvent e) {
                CancelarActionPerformed(e);
            }
            
        });
        
      
        
    }
    
    public void CadastrarActionPerformed(ActionEvent evt){
       DAO.Excluir_SI(mat);
       new ConfirmarExcluirSI(mat).setVisible(false);
       dispose();
    }
       
    public void CancelarActionPerformed(ActionEvent evt){         
       new ConfirmarExcluirSI(mat).setVisible(false);
       dispose();

    }
    
   
}

    

